package com.example.hello.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.spring.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    
}

