package org.vezenkov.cookingrecipes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vezenkov.cookingrecipes.dao.UserRepository;
import org.vezenkov.cookingrecipes.exception.NonExistingEntityException;
import org.vezenkov.cookingrecipes.model.User;
import org.vezenkov.cookingrecipes.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final String NON_EXISTING_USER_PATTERN = "User with %s:%s does not exist";

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
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format(NON_EXISTING_USER_PATTERN, "ID", id)));
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new NonExistingEntityException(String.format(NON_EXISTING_USER_PATTERN, "username", username)));
    }

    @Override
    public User addUser(User user) {
        user.setId(null);
        if (user.getImageUrl() == null) {
            switch (user.getGender()) {
                case MALE:
                    user.setImageUrl("image/jpeg;base64,bWFsZWltYWdlLmpwZWcK");
                    break;
                case FEMALE:
                    user.setImageUrl("image/jpeg;base64,ZmVtYWxlaW1hZ2UuanBlZwo=");
                    break;
                case OTHER:
                    user.setImageUrl("image/jpeg;base64,b3RoZXJpbWFnZS5qcGVnCg==");
                    break;
            }
        }

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
        User deleted = this.getUserById(id);
        this.userRepository.deleteById(id);
        return deleted;
    }

    @Override
    public long getCount() {
        return this.userRepository.count();
    }
}
