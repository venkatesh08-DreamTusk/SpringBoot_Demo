package com.DreamTusk.venkatesh.demo.service;

import com.DreamTusk.venkatesh.demo.entity.Student;

import java.util.List;

public interface StudentService {
  public  Student saveStudentDetails(Student student);
  public List<Student> getStudents();

 public Student getStudentById(long id);

 public void deleteStudent(long id);

}
