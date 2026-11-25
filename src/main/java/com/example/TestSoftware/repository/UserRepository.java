/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.TestSoftware.repository;

import com.example.TestSoftware.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author michael
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
