package com.rodis00.backend.dto;

import com.rodis00.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;

    public static UserDto from (User user) {
        return new UserDto(
                user.getId(),
                user.getEmail()
        );
    }
}
