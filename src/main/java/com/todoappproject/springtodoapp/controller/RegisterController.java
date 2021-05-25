package com.todoappproject.springtodoapp.controller;

import com.todoappproject.springtodoapp.model.Login;
import com.todoappproject.springtodoapp.model.Register;
import com.todoappproject.springtodoapp.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.net.RegisteredDomain;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    @PostMapping("/register")
        public Register addUser(@RequestBody Register register){
          return registerRepository.save(register);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login login){
        Register register=registerRepository.findByEmailAndPassword(login.getEmail(),login.getPassword());
        if (register == null){
            return "Error in login";
        }

        List<Register> registerList=registerRepository.findAll();
        return "Login successful";
    }

}
