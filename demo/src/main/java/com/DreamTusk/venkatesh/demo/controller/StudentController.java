package com.DreamTusk.venkatesh.demo.controller;

import com.DreamTusk.venkatesh.demo.entity.Student;
import com.DreamTusk.venkatesh.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return  studentService.saveStudentDetails(student);

    }

    @GetMapping("getStudent")
    public List<Student> getStudentList(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudentbyID/{id}")
    public Student getStudentById(@PathVariable("id") long id){
        return studentService.getStudentById(id);

    }

    @DeleteMapping("/removeStudent/{id}")
    public String deleteStudentById(@PathVariable("id") long id){
         studentService.deleteStudent(id);
        return "Student Successfully Deleted...";
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") long id ,@RequestBody Student student){
        return  studentService.updateStudentById(id,student);
    }


}
