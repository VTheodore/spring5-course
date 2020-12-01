package com.vezenkov.restmvc.web;

import com.vezenkov.restmvc.exception.InvalidEntityDataException;
import com.vezenkov.restmvc.model.User;
import com.vezenkov.restmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController("/api/users")
public class UserResource {
    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User created = this.userService.createUser(user);

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                        .buildAndExpand(created.getId())
                        .toUri()
        ).body(created);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String id, User user) {
        if (!id.equals(user.getId())) {
            throw new InvalidEntityDataException(String.format("User URL ID:%s differs from body entity ID:%s", id, user.getId()));
        }

        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") String id) {
        return this.userService.deleteUserById(id);
    }
}
