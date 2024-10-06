/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.it.taskzenapp.services;

import com.it.taskzenapp.entities.UserEntity;
import com.it.taskzenapp.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aditya Pathak R
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(7);

    public UserEntity signUpUser(UserEntity userEntity) {
        if (userEntity.getFirst_name() == null || userEntity.getFirst_name().isEmpty()) {
            throw new IllegalArgumentException("First name can't be empty!");
        }
        if (userEntity.getLast_name() == null || userEntity.getLast_name().isEmpty()) {
            throw new IllegalArgumentException("Last name can't be empty!");
        }
        if (userEntity.getEmail() == null || userEntity.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email can't be empty!");
        }
        if (userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password can't be empty!");
        }
        if (userEntity.getRole().toString() == null || userEntity.getRole().toString().isEmpty()) {
            throw new IllegalArgumentException("Role can't be empty!");
        }

        String subject = "Welcome to TaskZen 😊.";
        String body = "Dear " + userEntity.getFirst_name() + " " + userEntity.getLast_name() + ",\n\nThank you for registering with us. We're excited to have you onboard!";
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        emailService.sendEmail(userEntity.getEmail(), subject, body);
        return userRepository.save(userEntity);
    }

    public String loginUser(UserEntity userEntity) {
        if (userEntity.getEmail() == null || userEntity.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email can't be empty!");
        }
        if (userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password can't be empty!");
        }

        UserEntity existUser = userRepository.findByEmail(userEntity.getEmail());

        if (existUser == null) {
            throw new IllegalArgumentException("Email dose not exist!");
        }

        boolean checkPassword = encoder.matches(userEntity.getPassword(), existUser.getPassword());
        if (!checkPassword) {
            throw new IllegalArgumentException("Invalid password!");
        }

        String checkRole = existUser.getRole().toString();
        if (checkRole.equals("client")) {
            return "client";
        } else {
            return "company";
        }
    }
}
