package com.example.hello.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.spring.entity.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Integer> {
    
}
