package com.vezenkov.restmvc.service.impl;

import com.vezenkov.restmvc.dao.UserRepository;
import com.vezenkov.restmvc.exception.NonExistingEntityException;
import com.vezenkov.restmvc.model.User;
import com.vezenkov.restmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("User with ID:%s does not exist.", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new NonExistingEntityException("Invalid username or password."));
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return this.userRepository.insert(user);
    }

    @Override
    public User updateUser(User user) {
        this.getUserById(user.getId());
        user.setModified(LocalDateTime.now());
        return this.userRepository.save(user);
    }

    @Override
    public User deleteUserById(String id) {
        User removed = this.getUserById(id);
        this.userRepository.deleteById(id);
        return removed;
    }

    @Override
    public long getCount() {
        return this.userRepository.count();
    }
}
