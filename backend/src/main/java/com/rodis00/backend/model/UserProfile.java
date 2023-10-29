package com.rodis00.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
