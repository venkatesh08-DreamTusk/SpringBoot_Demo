package com.DreamTusk.venkatesh.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long studentID;
    private String studentName;
    private double studentPercentage;

    public long getStudentID(){
        return studentID;
    }
    public String getStudentName(){
        return studentName;
    }
    public double getStudentPercentage(){
        return studentPercentage;
    }


    public void setStudentID(long id){
        this.studentID = id;
    }
    public void setStudentName(String name){
        this.studentName = name;
    }
    public  void setStudentPercentage(double percentage){
        this.studentPercentage = percentage;
    }

    public Student(){}

   public Student(long id,String name,double percentage){
        this.studentID  = id;
        this.studentName = name;
        this.studentPercentage = percentage;
    }

    public  String toString(){
        return "Student ID : "+ studentID+
               "Student Name : "+ studentName+
               "Student Percentage : "+ studentPercentage;
    }

}
