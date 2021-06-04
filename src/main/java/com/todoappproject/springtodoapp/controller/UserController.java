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
        if (user==null){
            return ResponseEntity.badRequest().body("Invalid Credentials") ;
        }
        return ResponseEntity.ok("Success");
    }



}
