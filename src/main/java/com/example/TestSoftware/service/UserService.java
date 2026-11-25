/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestSoftware.service;

import com.example.TestSoftware.model.User;
import com.example.TestSoftware.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author michael
 */
@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
}
