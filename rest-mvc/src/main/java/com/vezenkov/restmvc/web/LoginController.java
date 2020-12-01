package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.exception.InvalidEntityDataException;
import com.vezenkov.restmvc.model.Credentials;
import com.vezenkov.restmvc.model.JwtResponse;
import com.vezenkov.restmvc.model.Role;
import com.vezenkov.restmvc.model.User;
import com.vezenkov.restmvc.service.UserService;
import com.vezenkov.restmvc.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Set;

import static com.vezenkov.restmvc.util.ErrorHandlingUtil.getViolationsAsStringList;

@RestController
@Slf4j
public class LoginController {
    private final UserService userService;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(UserService userService, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/login")
    public JwtResponse login(@Valid @RequestBody Credentials credentials, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid username or password");
        }

        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));

        final User user = this.userService.getUserByUsername(credentials.getUsername());
        final String token = this.jwtUtils.generateToken(user);

        log.info("Login successful for {}: {}", user, token); // not for production code

        return new JwtResponse(user, token);
    }

    @PostMapping("/api/register")
    public User register(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid user data", getViolationsAsStringList(errors));
        }

        user.setRoles(Set.of(Role.READER));
        return this.userService.createUser(user);
    }
}
