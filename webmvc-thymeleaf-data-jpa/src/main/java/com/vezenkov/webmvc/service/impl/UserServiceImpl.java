package com.vezenkov.webmvc.service.impl;

import com.vezenkov.webmvc.dao.UserRepository;
import com.vezenkov.webmvc.entity.User;
import com.vezenkov.webmvc.exception.NonExistingEntityException;
import com.vezenkov.webmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Validated
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(
                () -> new NonExistingEntityException(
                        String.format("User with ID='%d' does not exists", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepo.findByUsername(username).orElseThrow(() -> new NonExistingEntityException(
                String.format("User with username='%s' does not exists", username)));
    }

    @Override
    @Transactional
    public User addUser(@Valid User user) {
        user.setId(null);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User updateUser(@Valid User user) {
        User old = getUserById(user.getId());
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User deleteUser(Long id) {
        User deleted = getUserById(id);
        userRepo.deleteById(id);
        return deleted;
    }

    @Override
    public long getUsersCount() {
        return userRepo.count();
    }
}