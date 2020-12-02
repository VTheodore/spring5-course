package org.vezenkov.cookingrecipes.service;

import org.vezenkov.cookingrecipes.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(String id);

    User getUserByUsername(String username);

    User addUser(User user);

    User updateUser(User user);

    User deleteUserById(String id);

    long getCount();
}
