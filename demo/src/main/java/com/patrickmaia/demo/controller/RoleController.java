package com.patrickmaia.demo.controller;

import com.patrickmaia.demo.dtos.RoleDto;
import com.patrickmaia.demo.entity.Role;
import com.patrickmaia.demo.mappers.RoleMapper;
import com.patrickmaia.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getAllRoles() {

        return roleService.getAll().stream().map(RoleMapper::ToDto).toList();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable("id") int id){

        return RoleMapper.ToDto(roleService.getById(id));
    }


}
