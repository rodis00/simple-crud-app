package com.rodis00.backend.service;

import com.rodis00.backend.model.UserProfile;

public interface UserProfileServiceInterface {
    UserProfile addUserProfile(UserProfile userProfile);
    UserProfile findUserProfileById(Long id);
    UserProfile deleteUserProfile(Long id);
    UserProfile updateUserProfile(Long id, UserProfile userProfile);
}
