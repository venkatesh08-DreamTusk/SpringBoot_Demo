package com.DreamTusk.venkatesh.demo.controller;

import com.DreamTusk.venkatesh.demo.entity.Student;
import com.DreamTusk.venkatesh.demo.response.ResponseHandler;
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
    public ResponseHandler getStudentList(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudentbyID/{id}")
    public ResponseHandler getStudentById(@PathVariable("id") long id){
        return studentService.getStudentById(id);

    }

    @GetMapping("/getStudentByGender")
    public ResponseHandler getStudentByGender(@RequestParam(value = "Gender",required = false) String gender){
        return studentService.getStudentByGender(gender);
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
