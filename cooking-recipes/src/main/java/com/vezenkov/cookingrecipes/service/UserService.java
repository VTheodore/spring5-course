package com.vezenkov.cookingrecipes.service;

import com.vezenkov.cookingrecipes.entity.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsername(String username);

    User addUser(@Valid User user);

    User updateUser(User user);

    User deleteUserById(Long id);

    long usersCount();
}
