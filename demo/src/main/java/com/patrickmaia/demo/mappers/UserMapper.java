package com.patrickmaia.demo.mappers;

import com.patrickmaia.demo.dtos.UserDto;
import com.patrickmaia.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public  UserDto toDto(User user){
        return new UserDto(user.getId(), user.getEmail(),user.getUsername(), user.getPassword(),user.getRole());
    }
    public  User toEntity(UserDto userDto){
        return new User(userDto.id(),userDto.email(),userDto.username(),userDto.password(),userDto.role());
    }
}
