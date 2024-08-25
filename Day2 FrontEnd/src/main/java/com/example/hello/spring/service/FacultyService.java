package com.example.hello.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hello.spring.entity.FacultyEntity;
import com.example.hello.spring.repository.FacultyRepository;

@Service
public class FacultyService {
    
    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyEntity> getFacultyAll(){
        return facultyRepository.findAll();
    }

    public FacultyEntity getFacultyById(Integer facultyId){
        Optional<FacultyEntity> faculty = facultyRepository.findById(facultyId);
        if(faculty.isPresent()){
            return faculty.get();
        }
        return null;
    }

    public FacultyEntity saveFaculty(FacultyEntity facultyEntity){
        FacultyEntity faculty = facultyRepository.save(facultyEntity);
        return faculty;
    }

    public void deleteFacultyById(Integer facultyId){
        facultyRepository.deleteById(facultyId);
    }

}
