package com.ali.java.todo.service;

import com.ali.java.todo.dto.CreateUserDto;
import com.ali.java.todo.dto.UserDto;

import java.util.List;


public interface UserService {

    UserDto save(CreateUserDto createUserDto);
    UserDto update(CreateUserDto createUserDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    String delete(Long id);


}
