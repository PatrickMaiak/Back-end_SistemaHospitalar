package com.patrickmaia.demo.mappers;

import com.patrickmaia.demo.dtos.RoleDto;
import com.patrickmaia.demo.entity.Role;

public class RoleMapper {
    public static RoleDto ToDto(Role role){

        return new RoleDto(role.getId(),role.getRole());
    }

    public static Role toEntity(RoleDto roleDto) {

        return new Role(roleDto.id(),roleDto.name());
    }

}
