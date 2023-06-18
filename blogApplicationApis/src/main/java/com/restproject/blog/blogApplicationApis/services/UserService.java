package com.restproject.blog.blogApplicationApis.services;

import com.restproject.blog.blogApplicationApis.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,int userId);
    UserDto getUser(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(UserDto userDto);
    void deleteUserById(int userId);

}
