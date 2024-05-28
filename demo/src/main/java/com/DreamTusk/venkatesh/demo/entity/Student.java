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
    private String name;
    private double percentage;
    private String gender;

    public long getStudentID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
    public double getPercentage(){
        return percentage;
    }
    public String getGender() {
        return gender;
    }


    public void setStudentID(long id){
        this.studentID = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public  void setStudentPercentage(double percentage){
        this.percentage = percentage;
    }
    public void setGender(String studentGender) {
        this.gender = studentGender;
    }

    public Student(){}

   public Student(long id,String name,double percentage,String gender){
        this.studentID  = id;
        this.name = name;
        this.percentage = percentage;
        this.gender = gender;
    }

    public  String toString(){
        return "Student ID : "+ studentID+
               "Student Name : "+ name+
               "Student Percentage : "+percentage+
               "Student Gender : " +gender;
    }

}
