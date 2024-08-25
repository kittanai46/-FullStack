package com.example.hello.spring.controller;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hello.spring.entity.FacultyEntity;
import com.example.hello.spring.service.FacultyService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    
    @GetMapping({"","/"})
    public String getAll() {
        System.out.println("----- getAll() -----");

        List<FacultyEntity> faculties = facultyService.getFacultyAll();
        System.out.println("----- getAll() Result -----");
        System.out.println("Size : "+faculties.size());
        return "faculty/index";
    }
    
    @GetMapping("/{faculty-id}")
    public String getById(
        @PathVariable(name = "faculty-id") Integer facultyId
    ){
        System.out.println("----- getById ----- ");
        System.out.println("faculty-id : "+ facultyId);

        FacultyEntity entity = facultyService.getFacultyById(facultyId);
        System.out.println("----- getById() Result -----");
        System.out.println("Faculty Name : "+ entity.getFacultyName());

        return "faculty/index";
    }
    
    @GetMapping("/delete/{faculty-id}")
    public String getDeleteById(@PathVariable(name = "faculty-id") Integer facultyId) {
        System.out.println("----- getDeleteById -----");
        System.out.println("faculty-id : "+ facultyId);

        System.out.println("----- getDeleteById() Result -----");
        facultyService.deleteFacultyById(facultyId);

        return "index";
    }
    
    @PostMapping("/")
    public String postInsertAndUpdate(
        @RequestParam() Map<String, String> param
    ) {
        //TODO: process POST request
        System.out.println("----- postInsertAndUpdate -----");
        System.out.println("faculty-id : "+ param.get("faculty-id"));
        System.out.println("faculty-name : "+ param.get("faculty-name"));

        System.out.println("----- postInsertAndUpdate() Result -----");
        FacultyEntity entity = new FacultyEntity();
        if(null != param.get("faculty-id")){
            entity.setFacultyId(Integer.parseInt(param.get("faculty-id")));
        }
        entity.setFacultyName(param.get("faculty-name"));
        FacultyEntity result = facultyService.saveFaculty(entity);
        System.out.println("Faculty ID : "+ result.getFacultyId());
        System.out.println("Faculty Name : "+ result.getFacultyName());

        return "index";
    }
    

}
