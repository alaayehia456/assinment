package com.spring.services;

import com.spring.Dao.studenDao;
import com.spring.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    @Autowired
    studenDao studentdao;

    //get all student

    public List<student> studentList(){

        return studentdao.findAll();

    }


    //add student

    public void addStudent(student s){

        studentdao.save(s);


    }

    //edite student
    public void editeStudent(student s){

        Long id=s.getId();
        Optional<student> studentSave= studentdao.findById(id);


        studentSave.get().setName(s.getName());
        studentSave.get().setAge(s.getAge());
        studentSave.get().setEmail(s.getEmail());
        studentSave.get().setPhoneNumber(s.getPhoneNumber());

        studentdao.save(studentSave.get());
    }


    //delete student
    public void deleteStudent(Long id){
        studentdao.deleteById(id);

    }


    // search by id

    public student getStudentById(Long id){

        return studentdao.findById(id).get();
    }

}
