package com.it.taskzenapp.controllers;

import com.it.jpatest.exceptions.ResourceNotFoundException;
import com.it.taskzenapp.entities.UserEntity;
import com.it.taskzenapp.services.EmailService;
import com.it.taskzenapp.services.UserService;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api")
public class UserController {

    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/Java")
    public String greetJava() {
        return "Hello Java!";
    }

    @GetMapping(value = "/Spring")
    public String greetSpring() {
        return "Hello Spring!";
    }

    @GetMapping(value = "/RodJohnson")
    public String greetRodJohnson() {
        return "Hello RodJohnson!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }

    @PostMapping(value = "/signUpUser")
    public ResponseEntity signUpUser(@RequestBody UserEntity userEntity) {
        try {
            userService.signUpUser(userEntity);
            return new ResponseEntity("User registered successfully.", HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity("User not found! " + ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println("Something went wrong! " + ex.getMessage());
            return new ResponseEntity("Something went wrong!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/loginUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody UserEntity userEntity) {
        try {
            String userResponse = userService.loginUser(userEntity);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            System.out.println("Login faield! Please try again! " + ex.getMessage());
            return new ResponseEntity<>("Login faield! Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
