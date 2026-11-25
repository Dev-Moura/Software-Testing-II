/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TestSoftware.controllers;

import com.example.TestSoftware.model.User;
import com.example.TestSoftware.repository.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author michael
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
public class UserControllerIntegrationTest {
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private UserRepository userRepository;
    
    @AfterEach
    void tearDown()
    
    {userRepository.deleteAll();}
    
    @Test
    void ShouldCreateUserViaApi() {
        // Arrange
        var name = "Integration Test";
        User user = new User();
        user.setName(name);
        
        String url = "http://localhost:" + port + "/api/users";
        
        //Act
        ResponseEntity<User> response = restTemplate.postForEntity(
                url,
                user,
                User.class
        );
        
        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Integration Test");
        
        
        // verify it is persisted
        assertThat(userRepository.findAll()).hasSize(1);
    }    
}
