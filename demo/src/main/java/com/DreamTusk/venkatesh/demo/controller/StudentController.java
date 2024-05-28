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

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return  studentService.saveStudentDetails(student);

    }


    @GetMapping("/student/{id}")
    public ResponseHandler getStudentById(@PathVariable("id") long id){
        ResponseHandler responseHandler = new ResponseHandler();
        Student student =  studentService.getStudentById(id);

        if(student !=  null){
            responseHandler.setStatus(true);
            responseHandler.setData(student);
            responseHandler.setError(null);
        }else{
            responseHandler.setStatus(false);
            responseHandler.setData(null);
            responseHandler.setError("Student Not Found");
        }
        return responseHandler;

    }


    @GetMapping("/student")
    public ResponseHandler getStudentByGender(@RequestParam(value = "gender",required = false) String gender){
        ResponseHandler responseHandler = new ResponseHandler();
        if(gender != null){

            if(!genderIsValide(gender)){
                responseHandler.setStatus(false);
                responseHandler.setData(null);
                responseHandler.setError("Gender Not Found");
                return responseHandler;
            }
            List<Student> students = studentService.getStudentByGender(gender);
            if(!students.isEmpty()){
                responseHandler.setStatus(true);
                responseHandler.setData(students);
                responseHandler.setError(null);
            }else{
                responseHandler.setStatus(false);
                responseHandler.setData(null);
                responseHandler.setError("Student Not Found");

            }
        }else{
            List<Student> totalStudent = studentService.getStudents();
            responseHandler.setStatus(true);
            responseHandler.setData(totalStudent);
            responseHandler.setError(null);
        }
              return responseHandler;
    }

    private  boolean genderIsValide(String gender){
        return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female");
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") long id){
         studentService.deleteStudent(id);
        return "Student Successfully Deleted...";
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") long id ,@RequestBody Student student){
        return  studentService.updateStudentById(id,student);
    }


}
