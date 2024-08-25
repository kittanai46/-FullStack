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
import com.example.hello.spring.entity.StudentEntity;
import com.example.hello.spring.service.FacultyService;
import com.example.hello.spring.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping({"","/"})
    public String getAll(
    ) {
        System.out.println("----- StudentController getAll() -----");

        List<StudentEntity> student = studentService.getStudentAll();
        System.out.println("----- StudentController getAll() Result -----");
        System.out.println("Size : "+student.size());
    return "student/index";
    }

    @GetMapping("/{student-id}")
    public String getById(@PathVariable(name = "student-id")Integer studentId) {
        System.out.println("----- StudentController getById() -----");
        System.out.println("Student ID : "+ studentId);

        StudentEntity entity = studentService.getStudentById(studentId);
        System.out.println("----- StudentController getById() Result -----");
        System.out.println("Student First Name : "+ entity.getStudentFirstName());
        System.out.println("Student Last Name : "+ entity.getStudentLastName());
        return "student/index";
    }
    
    @GetMapping("/delete/{student-id}")
    public String getDeleteById(
        @PathVariable(name = "student-id") Integer studentId)
    {
        System.out.println("----- StudentController getDeleteById -----");
        System.out.println("student-id : "+ studentId);

        System.out.println("----- StudentController getDeleteById Result -----");
        studentService.deleteStudentById(studentId);
        return "index";
    }
    
    @PostMapping("/")
    public String postMethodName(
        @RequestParam() Map<String, String> param)
    {
        //TODO: process POST request
        
        System.out.println("----- StudentController postInsertAndUpdate() -----");
        System.out.println("student-id : "+ param.get("student-id"));
        System.out.println("student-name : "+ param.get("student-name"));

        System.out.println("----- StudentController postInsertAndUpdate() Result-----");
        Integer facultyId = Integer.parseInt(param.get("faculty-id"));
        FacultyEntity facultyEntity = facultyService.getFacultyById(facultyId);
        System.out.println(facultyEntity.getFacultyId());

        StudentEntity entity = new StudentEntity();
        if(null != param.get("student-id")){
            entity.setStudentId(Integer.parseInt(param.get("student-id")));
        }
        entity.setStudentCode(param.get("student-code"));
        entity.setStudentFirstName(param.get("student-fname"));
        entity.setStudentLastName(param.get("student-lname"));
        entity.setFaculty(facultyEntity);
        StudentEntity result = studentService.saveStudent(entity);
        System.out.println("Student Id : "+result.getStudentId());
        System.out.println("Student First Name : "+result.getStudentFirstName());
        System.out.println("Student Last Name : "+result.getStudentLastName());
        return "index";
    }
    
}
