package com.patrickmaia.demo.service;

import com.patrickmaia.demo.entity.User;
import com.patrickmaia.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

    public User getById(int id){
        return usersRepository.findById(id).orElse(null);
    }
    public User createUser(User user){
        return  usersRepository.save(user);
    }
    public User updateUser(int id,User userDetails){
        return usersRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    user.setRole(userDetails.getRole());
                    return usersRepository.save(user);
                }).orElse(null);
    }

    public void deleteUser(int id){
        usersRepository.deleteById(id);

    }
}
