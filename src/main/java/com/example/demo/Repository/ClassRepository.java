package com.example.demo.Repository;

import com.example.demo.model.Classes;
import com.example.demo.model.Student;
//import com.example.md6be.model.Classes;
//import com.example.md6be.model.Student;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableSpringConfigured
public interface ClassRepository extends JpaRepository<Classes, Long> {
    Classes findClassesByName(String className);
    @Query("SELECT c.students FROM Classes c WHERE c.name=:name")
    List<Student> findStudentByClass(@Param("name") String name);


}
