package com.restproject.blog.blogApplicationApis.controllers;

import com.restproject.blog.blogApplicationApis.payloads.ApiResponse;
import com.restproject.blog.blogApplicationApis.payloads.UserDto;
import com.restproject.blog.blogApplicationApis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = userService.createUser(userDto);
        return savedUserDto;
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable int userId){
        UserDto savedUserDto = userService.getUser(userId);
        return savedUserDto;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAllUsers(){
        List<UserDto> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto updateUser(@PathVariable int userId,@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = userService.updateUser(userDto,userId);
        return savedUserDto;
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteUser(@PathVariable int userId){
        userService.deleteUserById(userId);
        return new ApiResponse("User Deleted Successfully:",true);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@RequestBody UserDto userDto){
        userService.deleteUser(userDto);
    }

}
