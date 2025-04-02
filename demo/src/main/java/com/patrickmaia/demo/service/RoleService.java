package com.patrickmaia.demo.service;

import com.patrickmaia.demo.entity.Role;
import com.patrickmaia.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getOneRole(int id){
        return roleRepository.findById(id).orElse(null);
    }

}
