package com.rodis00.backend.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserProfileNotFoundException extends RuntimeException{

    private Map<String, String> errorDetail = new HashMap<>();
    public UserProfileNotFoundException(Long id) {
        this.errorDetail.put(
                "message", "UserProfile with id: " + id + " not found."
        );
    }
}
