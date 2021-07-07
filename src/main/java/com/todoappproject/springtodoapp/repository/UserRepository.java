package com.todoappproject.springtodoapp.repository;

import com.todoappproject.springtodoapp.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Register,Integer> {
   Optional<Register> findByEmailAndPassword(String email, String password);





}
