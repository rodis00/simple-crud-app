package com.rodis00.backend.service;

import com.rodis00.backend.model.User;

public interface AuthServiceInterface {
    User authenticateUser(String email, String password);
}
