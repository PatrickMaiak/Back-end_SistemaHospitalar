package com.patrickmaia.demo.controller;

import com.patrickmaia.demo.dtos.MedicineDto;
import com.patrickmaia.demo.dtos.UserDto;
import com.patrickmaia.demo.entity.Medicine;
import com.patrickmaia.demo.mappers.MedicineMapper;
import com.patrickmaia.demo.mappers.UserMapper;
import com.patrickmaia.demo.repository.UsersRepository;
import com.patrickmaia.demo.service.UserService;
import com.patrickmaia.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAllUsers().stream().map(userMapper::toDto).toList();
//        return userService.getAllUsers().stream().map(user -> userMapper.toDto(user)).toList();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id")  int id){
        return userMapper.toDto(userService.getById(id));
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userdto){
        User user = userMapper.toEntity(userdto);
        User savedUser = userService.createUser(user);
        return userMapper.toDto(savedUser);
    }


    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable int id,@RequestBody UserDto userDto){
        User userDetails = userMapper.toEntity(userDto);
        User updateUser = userService.updateUser(id,userDetails);

        return userMapper.toDto(updateUser);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
