package com.bendrioue.expressmenu.service;

import com.bendrioue.expressmenu.dto.UserDto;
import com.bendrioue.expressmenu.exception.UserNotFoundException;
import com.bendrioue.expressmenu.mapper.AppMapper;
import com.bendrioue.expressmenu.model.User;
import com.bendrioue.expressmenu.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AppMapper appMapper;

    public UserService(UserRepository userRepository, AppMapper appMapper) {
        this.userRepository = userRepository;
        this.appMapper = appMapper;
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(appMapper::userToUserDto)
                .toList();
    }

    public UserDto getUserById(UUID id) {
        return userRepository.findById(id)
                .map(appMapper::userToUserDto)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public UserDto createUser(UserDto userDto) {
        User user = appMapper.userDtoToUser(userDto);
        return appMapper.userToUserDto(userRepository.save(user));
    }

    public UserDto updateUser(UUID id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        User updatedUser = appMapper.userDtoToUser(userDto);
        updatedUser.setId(user.getId());
        return appMapper.userToUserDto(userRepository.save(updatedUser));
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
    }
}