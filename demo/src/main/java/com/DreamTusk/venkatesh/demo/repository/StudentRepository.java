package com.DreamTusk.venkatesh.demo.repository;

import com.DreamTusk.venkatesh.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByGender(String gender);

}
