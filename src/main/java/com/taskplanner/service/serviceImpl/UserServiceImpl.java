package com.taskplanner.service.serviceImpl;

import com.taskplanner.dto.UserRequestDto;
import com.taskplanner.dto.UserResponseDto;
import com.taskplanner.entity.Users;
import com.taskplanner.mapper.UserMapper;
import com.taskplanner.repository.UserRepository;
import com.taskplanner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUsers(UserRequestDto userRequestDto) {
        Users user = userMapper.toEntity(userRequestDto);
        return userMapper.toDto(userRepository.save(user));    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }
}
