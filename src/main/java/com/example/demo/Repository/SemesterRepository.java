package com.example.demo.Repository;

import com.example.demo.model.Semester;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableSpringConfigured

public interface SemesterRepository extends JpaRepository<Semester,Long> {
    Semester findBySemesterName(String nameSemester);
}
