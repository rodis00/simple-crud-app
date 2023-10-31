package com.rodis00.backend.service;

import com.rodis00.backend.model.User;

import java.util.List;

public interface UserServiceInterface {
    User addUser(User user);
    User getUser(Long id);
    List<User> getUsers();
    User deleteUser(Long id);
    User getUserByEmail(String email);
}
