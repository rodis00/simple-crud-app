package com.rodis00.backend.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserNotFoundException extends RuntimeException {

    private Map<String, String> errorDetail = new HashMap<>();
    public UserNotFoundException(Long id) {
        this.errorDetail.put(
                "message", "User with id: " + id + " not found."
        );
    }
}
