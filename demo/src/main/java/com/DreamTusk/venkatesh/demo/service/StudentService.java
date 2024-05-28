package com.DreamTusk.venkatesh.demo.service;

import com.DreamTusk.venkatesh.demo.entity.Student;
import com.DreamTusk.venkatesh.demo.response.ResponseHandler;


public interface StudentService {
  public  Student saveStudentDetails(Student student);
  public ResponseHandler getStudents();

 public ResponseHandler getStudentById(long id);
 public ResponseHandler getStudentByGender(String gender);

 public void deleteStudent(long id);

   public Student updateStudentById(long id, Student student);
}
