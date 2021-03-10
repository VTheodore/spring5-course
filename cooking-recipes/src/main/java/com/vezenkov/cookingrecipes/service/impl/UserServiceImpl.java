package com.vezenkov.cookingrecipes.service.impl;

import com.vezenkov.cookingrecipes.dao.UserRepository;
import com.vezenkov.cookingrecipes.entity.User;
import com.vezenkov.cookingrecipes.exception.InvalidEntityDataException;
import com.vezenkov.cookingrecipes.exception.NonExistingEntityException;
import com.vezenkov.cookingrecipes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
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
    public User getUserById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format("User with id=%d does not exist.", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidEntityDataException("Invalid username or password"));
    }

    @Override
    @Transactional
    public User addUser(@Valid User user) {
        user.setId(null);

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        this.getUserById(user.getId());
        user.setModified(new Date());
        return this.userRepository.save(user);
    }

    @Override
    @Transactional
    public User deleteUserById(Long id) {
        User toBeDeleted = this.getUserById(id);
        this.userRepository.deleteById(id);

        return toBeDeleted;
    }

    @Override
    public long usersCount() {
        return this.userRepository.count();
    }
}
