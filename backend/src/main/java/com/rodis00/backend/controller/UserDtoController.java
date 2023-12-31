package com.rodis00.backend.controller;

import com.rodis00.backend.dto.UserDto;
import com.rodis00.backend.exception.UserNotFoundException;
import com.rodis00.backend.model.User;
import com.rodis00.backend.model.UserProfile;
import com.rodis00.backend.service.UserProfileService;
import com.rodis00.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDtoController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("")
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        UserProfile userProfile = userProfileService.addUserProfile(
                new UserProfile()
        );
        newUser.setUserProfile(userProfile);
        userService.addUser(newUser);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(UserDto.from(newUser));
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users.stream().map(UserDto::from).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUser(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(UserDto.from(user));

        }catch (UserNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getErrorDetail());
        }
    }
}
