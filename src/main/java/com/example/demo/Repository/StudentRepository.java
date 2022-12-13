package com.example.demo.Repository;

import com.example.demo.model.Student;
//import com.example.md6be.model.Student;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableSpringConfigured
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT distinct s.student AS sumAll FROM Transcript AS s WHERE s.point<5 ")
    List<Student> selectStudentFailed();

}
