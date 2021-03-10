package com.vezenkov.webmvc.service;

import com.vezenkov.webmvc.entity.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsername(String username);

    User addUser(@Valid User user);

    User updateUser(@Valid User user);

    User deleteUser(Long id);

    long getUsersCount();
}