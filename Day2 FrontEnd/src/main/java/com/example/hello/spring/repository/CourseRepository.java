package com.example.hello.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hello.spring.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    
}
