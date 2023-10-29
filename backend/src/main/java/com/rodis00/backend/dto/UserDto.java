package com.rodis00.backend.dto;

import com.rodis00.backend.model.User;
import com.rodis00.backend.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private UserProfile userProfile;

    public static UserDto from (User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUserProfile()
        );
    }
}
