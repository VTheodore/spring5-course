package org.vezenkov.cookingrecipes.web;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.vezenkov.cookingrecipes.exception.InvalidEntityDataException;
import org.vezenkov.cookingrecipes.model.User;
import org.vezenkov.cookingrecipes.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static org.vezenkov.cookingrecipes.util.ErrorHandlingUtil.getViolationsAsStringList;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") String id, @Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            throw new InvalidEntityDataException("Invalid user data", getViolationsAsStringList(errors));
        }

        if (!id.equals(user.getId())) {
            throw new InvalidEntityDataException(String.format("User ID:%s differs from body entity ID:%s", id, user.getId()));
        }

        return this.userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") String id) {
        return this.userService.deleteUserById(id);
    }
}
