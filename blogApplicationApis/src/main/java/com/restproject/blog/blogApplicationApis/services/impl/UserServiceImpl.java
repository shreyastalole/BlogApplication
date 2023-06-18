package com.restproject.blog.blogApplicationApis.services.impl;

import com.restproject.blog.blogApplicationApis.exceptions.ResourceNotFoundException;
import com.restproject.blog.blogApplicationApis.models.User;
import com.restproject.blog.blogApplicationApis.payloads.UserDto;
import com.restproject.blog.blogApplicationApis.repositories.UserRepository;
import com.restproject.blog.blogApplicationApis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = dtoToUserMapper(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = userToDtoMapper(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto,int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));

        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepository.save(user);
        return userToDtoMapper(updatedUser);
    }

    @Override
    public UserDto getUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(" User ", "id" ,userId));
        return userToDtoMapper(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDto> allUsersDto = allUsers.stream().map(a-> this.userToDtoMapper(a)).collect(Collectors.toList());

        return allUsersDto;
    }

    @Override
    public void deleteUser(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new ResourceNotFoundException("User","id",userDto.getId()));
        userRepository.deleteById(userDto.getId());
    }

    @Override
    public void deleteUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        userRepository.deleteById(userId);
    }

    public User dtoToUserMapper(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);

//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDtoMapper(User user){
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

}
