package com.taskplanner.service;

import com.taskplanner.dto.UserRequestDto;
import com.taskplanner.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserResponseDto createUsers(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllUsers();
}
