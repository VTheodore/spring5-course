package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.model.User;
import com.vezenkov.restmvc.service.UserService;
import com.vezenkov.restmvc.util.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@Order
public class JwtRequestFilter extends OncePerRequestFilter {
    private final UserService userService;

    private final JwtUtils jwtUtils;

    @Autowired
    public JwtRequestFilter(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (authorizationHeader != null) {
            if (authorizationHeader.startsWith("Bearer ")) {
                jwtToken = authorizationHeader.substring(7);

                try {
                    username = this.jwtUtils.getUsernameFromToken(jwtToken);
                } catch (IllegalArgumentException ex) {
                    log.error("Unable to get JWT Token.");
                    throw new BadCredentialsException("Unable to get JWT Token.");
                } catch (ExpiredJwtException ex) {
                    log.error("JWT token has expired.");
                    throw new BadCredentialsException("JWT Token has expired.");
                }
            } else {
                log.error("JWT Token does not begin with 'Bearer ' prefix.");
                throw new BadCredentialsException("JWT Token does not begin with 'Bearer ' prefix.");
            }
        }

        if (username != null) {
            User user = this.userService.getUserByUsername(username);

            if (jwtUtils.validateToken(jwtToken, user)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
