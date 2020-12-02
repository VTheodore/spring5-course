package org.vezenkov.cookingrecipes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vezenkov.cookingrecipes.exception.InvalidEntityDataException;
import org.vezenkov.cookingrecipes.model.Credentials;
import org.vezenkov.cookingrecipes.model.JwtResponse;
import org.vezenkov.cookingrecipes.model.User;
import org.vezenkov.cookingrecipes.service.UserService;
import org.vezenkov.cookingrecipes.util.JwtUtils;

import javax.validation.Valid;


import static org.vezenkov.cookingrecipes.util.ErrorHandlingUtil.getViolationsAsStringList;

@RestController
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

        return new JwtResponse(user, token);
    }

    @PostMapping("/api/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid user data", getViolationsAsStringList(errors));
        }

        User created = this.userService.addUser(user);
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                        .buildAndExpand(created.getId())
                        .toUri()
        ).body(created);
    }
}
