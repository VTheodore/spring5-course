package com.vezenkov.restmvc.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vezenkov.restmvc.model.ErrorResponse;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class FilterChainExceptionHandlerFilter extends OncePerRequestFilter {

    private final ErrorHandlerControllerAdvice controllerAdvice;

    @Autowired
    public FilterChainExceptionHandlerFilter(ErrorHandlerControllerAdvice controllerAdvice) {
        this.controllerAdvice = controllerAdvice;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (JwtException | AuthenticationException e) {
            log.error("Spring Security Chain Exception: ", e);
            ResponseEntity<ErrorResponse> responseEntity = this.controllerAdvice.handleAuthenticationException(e);
            response.setStatus(responseEntity.getStatusCodeValue());
            PrintWriter out = response.getWriter();
            new ObjectMapper().writeValue(out, responseEntity.getBody());
        }
    }
}
