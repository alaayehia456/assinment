package com.spring.controller;

import com.spring.model.student;
import com.spring.services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class studentController {

    @Autowired
    studentService studentserice;

    //get all student

    //https://localhost:8443/api/getstudent
    @GetMapping("/getstudent")
    public List<student>  getAllStudent(){

       return  studentserice.studentList();
    }




    //https://localhost:8443/api/addstudent

    @PostMapping("/addstudent")
    public void addStudent(@RequestBody student Student){

        studentserice.addStudent(Student);

    }


    //https://localhost:8443/api/editestudent
    @PutMapping("/editestudent")
    public void editeStudent(@RequestBody student s){

        studentserice.editeStudent(s);
    }


    //https://localhost:8443/api/getstudent

    @GetMapping("/search")
    public student getStudent(@RequestParam Long id){

        return studentserice.getStudentById(id);

    }


    @DeleteMapping("/deletestudent")
    public void deletestudent(@RequestParam Long id){

        studentserice.deleteStudent(id);
    }

}
