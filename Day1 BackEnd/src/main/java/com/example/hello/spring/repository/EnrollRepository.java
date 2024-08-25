package com.example.hello.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.spring.entity.EnrollEntity;

public interface EnrollRepository extends JpaRepository<EnrollEntity, Integer> {
    
}
