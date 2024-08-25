package com.example.hello.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.spring.entity.EnrollEntity;
import com.example.hello.spring.repository.EnrollRepository;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;

    public List<EnrollEntity> getEnrollAll(){
        return enrollRepository.findAll();
    }

    public EnrollEntity getEnrollById(Integer enrollId){
        Optional<EnrollEntity> enroll = enrollRepository.findById(enrollId);
        if(enroll.isPresent()){
            return enroll.get();
        }
        return null;
    }

    public EnrollEntity saveEnroll(EnrollEntity enrollEntity){
        EnrollEntity enroll = enrollRepository.save(enrollEntity);
        return enroll;
    }

    public void deleteEnrollById(Integer enrollId){
        enrollRepository.deleteById(enrollId);
    }
}
