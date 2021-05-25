package com.todoappproject.springtodoapp.repository;

import com.todoappproject.springtodoapp.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Integer> {
    Register findByEmailAndPassword(String email,String password);
}
