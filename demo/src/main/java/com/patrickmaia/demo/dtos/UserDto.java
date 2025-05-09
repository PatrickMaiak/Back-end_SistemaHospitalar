package com.patrickmaia.demo.dtos;

import java.util.UUID;
import com.patrickmaia.demo.entity.Role;

public record UserDto (int id,String email,String username,String password,Role role){

};


