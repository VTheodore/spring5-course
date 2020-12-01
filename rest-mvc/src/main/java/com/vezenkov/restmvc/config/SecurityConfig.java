package com.vezenkov.restmvc.config;

import com.vezenkov.restmvc.service.UserService;
import com.vezenkov.restmvc.web.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import static com.vezenkov.restmvc.model.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(GET,"/api/posts/**").permitAll()
                .antMatchers(POST, "/api/posts").hasAnyRole(AUTHOR.toString(), ADMIN.toString())
                .antMatchers(PUT, "/api/posts").hasAnyRole(AUTHOR.toString(), ADMIN.toString())
                .antMatchers(DELETE, "/api/posts").hasAnyRole(AUTHOR.toString(), ADMIN.toString())
                .antMatchers("/api/users/**").hasRole(ADMIN.toString())
                .antMatchers("/**").permitAll()
                .and().exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public UserDetailsService getUserDetailsService(UserService userService) {
        return userService::getUserByUsername;
    }
}
