package org.vezenkov.cookingrecipes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.vezenkov.cookingrecipes.service.UserService;
import org.vezenkov.cookingrecipes.web.FilterChainExceptionHandlerFilter;
import org.vezenkov.cookingrecipes.web.JwtAuthenticationEntryPoint;
import org.vezenkov.cookingrecipes.web.JwtAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.vezenkov.cookingrecipes.model.Role.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final FilterChainExceptionHandlerFilter filterChainExceptionHandlerFilter;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAuthenticationFilter jwtAuthenticationFilter, FilterChainExceptionHandlerFilter filterChainExceptionHandlerFilter) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.filterChainExceptionHandlerFilter = filterChainExceptionHandlerFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(POST, "/api/login/**", "/api/register/**").permitAll()
                .antMatchers("/api/users/**").hasRole(ADMIN.toString())
                .antMatchers(GET, "/api/recipes").permitAll()
                .antMatchers(GET, "/api/recipes/**").hasAnyRole(ADMIN.toString(), USER.toString())
                .antMatchers(PUT, "/api/recipes/**").hasAnyRole(ADMIN.toString(), USER.toString())
                .antMatchers(POST, "/api/recipes").hasAnyRole(ADMIN.toString(), USER.toString())
                .antMatchers(DELETE, "/api/recipes/**").hasAnyRole(ADMIN.toString(), USER.toString())
                .antMatchers("/**").permitAll()
                .and().exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(this.filterChainExceptionHandlerFilter, LogoutFilter.class);
    }

    @Bean
    public UserDetailsService getUserDetailsService(UserService userService) {
        return userService::getUserByUsername;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
