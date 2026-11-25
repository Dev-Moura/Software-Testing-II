/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestSoftware.service;

import com.example.TestSoftware.model.User;
import com.example.TestSoftware.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author michael
 */
public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {

        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);

    }

    @Test
    void shouldCreateUser() {

        User user = new User();
        user.setName("Alice");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertEquals("Alice", createdUser.getName());

    }

    @Test
    void shouldReturnAllUsers() {

        List<User> users = Arrays.asList(
                new User(1L, "Alice"),
                new User(2l, "John")
        );

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUser();

        assertEquals(2, result.size());
        assertEquals("John", result.get(1).getName());

    }
}
