package com.taskplanner.dto;

import com.taskplanner.enums.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
