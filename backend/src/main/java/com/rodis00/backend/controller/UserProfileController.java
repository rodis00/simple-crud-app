package com.rodis00.backend.controller;

import com.rodis00.backend.exception.UserProfileNotFoundException;
import com.rodis00.backend.model.UserProfile;
import com.rodis00.backend.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> udpateUserProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
        try {
            UserProfile oldProfile = userProfileService.updateUserProfile(id, userProfile);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(oldProfile);
        } catch (UserProfileNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetail());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserProfile(@PathVariable Long id) {
        try {
            UserProfile userProfile = userProfileService.findUserProfileById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userProfile);
        } catch (UserProfileNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetail());
        }
    }
}
