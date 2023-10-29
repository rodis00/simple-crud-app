package com.rodis00.backend.service;

import com.rodis00.backend.exception.UserNotFoundException;
import com.rodis00.backend.model.User;
import com.rodis00.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
        return user;
    }
}
