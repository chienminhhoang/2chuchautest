package com.example.demo.Repository;

import com.example.demo.model.Subject;
//import com.example.md6be.model.Subject;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableSpringConfigured
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findSubjectByName(String subjectName);
}
