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

    @PostMapping("/getStudent")
    public Student saveStudent(@RequestBody Student student){
        return  studentService.saveStudentDetails(student);

    }

    @GetMapping("/getStudent")
    public ResponseHandler getStudentList(){
        ResponseHandler responseHandler = new ResponseHandler();
       List<Student> students =  studentService.getStudents();

        if(!students.isEmpty()){
            responseHandler.setStatus(true);
            responseHandler.setData(students);
            responseHandler.setError(null);
        }else{
            responseHandler.setStatus(false);
            responseHandler.setData(null);
            responseHandler.setError("Data Not Found");
        }

        return responseHandler;
    }


    @GetMapping("/getStudent/{id}")
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


    @GetMapping("/getStudentByGender")
    public ResponseHandler getStudentByGender(@RequestParam(value = "gender",required = false) String gender){
        ResponseHandler responseHandler = new ResponseHandler();
        if(gender != null){
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

            List<Student> students = studentService.getStudents();
        }
              return responseHandler;
    }

    @DeleteMapping("/getStudent/{id}")
    public String deleteStudentById(@PathVariable("id") long id){
         studentService.deleteStudent(id);
        return "Student Successfully Deleted...";
    }

    @PutMapping("/getStudent/{id}")
    public Student updateStudent(@PathVariable("id") long id ,@RequestBody Student student){
        return  studentService.updateStudentById(id,student);
    }


}
