package com.taskplanner.mapper;

import com.taskplanner.dto.UserRequestDto;
import com.taskplanner.dto.UserResponseDto;
import com.taskplanner.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toDto(Users user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public Users toEntity(UserRequestDto dto) {
        Users user = new Users();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        return user;
    }
}
