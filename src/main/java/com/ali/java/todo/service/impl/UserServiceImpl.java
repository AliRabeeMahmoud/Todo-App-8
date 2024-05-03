package com.ali.java.todo.service.impl;

import com.ali.java.todo.dto.CreateUserDto;
import com.ali.java.todo.dto.UserDto;
import com.ali.java.todo.exception.NotFoundException;
import com.ali.java.todo.model.User;
import com.ali.java.todo.repository.UserRepository;
import com.ali.java.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public UserDto save(CreateUserDto createUserDto) {

        return toUserDto(userRepository.save(toUser(createUserDto)));
    }

    @Override
    public UserDto update(CreateUserDto createUserDto) {

        User user= toUser(createUserDto);

        User oldUser = userRepository.findById(user.getId()).orElse(null);
        oldUser.setUserName(user.getUserName());
        oldUser.setCategory(user.getCategory());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        userRepository.save(oldUser);
        return toUserDto(oldUser);
    }

    @Override
    public List<UserDto> findAll() {

       return userRepository.findAll()
               .stream()
               .map(this::toUserDto)
               .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) throws NotFoundException {

        User user = userRepository.findById(id).orElse(null);
        if(user!=null){
            return toUserDto(user) ;
        }

            throw new NotFoundException("the requested user does not exist");
    }

    @Override
    public String delete(Long id) {

        userRepository.deleteById(id);
        return "Deleted";

    }

    private UserDto toUserDto(User user){

    return mapper.map(user, UserDto.class);
    }

    private User toUser(CreateUserDto createUserDto){

        return mapper.map(createUserDto, User.class);
    }




}
