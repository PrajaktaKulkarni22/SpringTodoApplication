package com.todoappproject.springtodoapp.controller;

import com.todoappproject.springtodoapp.model.Login;
import com.todoappproject.springtodoapp.model.Register;
import com.todoappproject.springtodoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody Login login){
        Optional<Register> user=userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
        System.out.println(user);
        if (user.isPresent()){
            return ResponseEntity.ok("Success");

        }
        return ResponseEntity.badRequest().body("Invalid Credentials") ;

    }

    @PostMapping("/register")
    public Register addUser(@RequestBody Register register){
        return userRepository.save(register);
    }

    /*@PutMapping("/updatePassword/{email}")
    public ResponseEntity<?> updatePassword(@PathVariable String email,@RequestBody Register register){


    }*/



}
