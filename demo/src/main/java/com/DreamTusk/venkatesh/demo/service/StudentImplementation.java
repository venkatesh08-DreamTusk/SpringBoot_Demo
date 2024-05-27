package com.DreamTusk.venkatesh.demo.service;

import com.DreamTusk.venkatesh.demo.entity.Student;
import com.DreamTusk.venkatesh.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImplementation implements StudentService{


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }


}