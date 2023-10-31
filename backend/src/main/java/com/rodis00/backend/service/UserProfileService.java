package com.rodis00.backend.service;

import com.rodis00.backend.exception.UserProfileNotFoundException;
import com.rodis00.backend.model.UserProfile;
import com.rodis00.backend.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements UserProfileServiceInterface {
    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfile addUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileById(Long id) {
        return userProfileRepository
                .findById(id)
                .orElseThrow(() -> new UserProfileNotFoundException(id));
    }

    @Override
    public UserProfile deleteUserProfile(Long id) {
        UserProfile userProfile = findUserProfileById(id);
        userProfileRepository.delete(userProfile);
        return userProfile;
    }

    @Override
    public UserProfile updateUserProfile(Long id, UserProfile userProfile) {
        UserProfile oldUserProfile = findUserProfileById(id);
        oldUserProfile.setAge(userProfile.getAge());
        oldUserProfile.setFirstName(userProfile.getFirstName());
        oldUserProfile.setLastName(userProfile.getLastName());
        return userProfileRepository.save(oldUserProfile);
    }
}
