package com.DreamTusk.venkatesh.demo.service;

import com.DreamTusk.venkatesh.demo.entity.Student;
import com.DreamTusk.venkatesh.demo.repository.StudentRepository;
import com.DreamTusk.venkatesh.demo.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentImplementation implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseHandler getStudents() {
        ResponseHandler responseHandler = new ResponseHandler();

        List<Student> students = studentRepository.findAll();
        if(!students.isEmpty()){
            responseHandler.setStatus(true);
            responseHandler.setData(students);
            responseHandler.setError(null);
        }

        return responseHandler;
    }

    @Override
    public ResponseHandler getStudentById(long id) {
        ResponseHandler responseHandler = new ResponseHandler();

        Student student =  studentRepository.findById(id).orElse(null);

        if(student != null){
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

    @Override
    public ResponseHandler getStudentByGender(String gender){
        ResponseHandler responseHandler = new ResponseHandler();

        if(gender != null) {
            List<Student> students = studentRepository.findByGender(gender);
            if (!students.isEmpty()) {
                responseHandler.setStatus(true);
                responseHandler.setData(students);
                responseHandler.setError(null);
            } else {
                responseHandler.setStatus(false);
                responseHandler.setData(null);
                responseHandler.setError("Gender Not Found");
            }
        }else{
            List<Student> students = studentRepository.findAll();
        }
        return responseHandler;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


    @Override
    public Student updateStudentById(long id, Student student){
        Student studentDB = studentRepository.findById(id).get(); //first get that particular id

        if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
            studentDB.setName(student.getName());
        }
        studentDB.setStudentPercentage(student.getPercentage());
            return studentRepository.save(studentDB);
    }
}
