package com.rodis00.backend.exception;

import java.util.HashMap;
import java.util.Map;

public class BookNotFoundException extends RuntimeException{

    private Map<String, String> errorDetails = new HashMap<>();
    public BookNotFoundException(Long id) {
        this.errorDetails.put(
                "message", "Book with id: " + id + " not found."
        );
    }
    public Map<String, String> getErrorDetails() {
        return errorDetails;
    }
}
