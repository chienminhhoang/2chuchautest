package com.example.demo.Repository;

import com.example.demo.model.Transcript;
//import com.example.md6be.model.Transcript;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableSpringConfigured
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
    @Modifying

    @Query("SELECT t FROM Transcript t WHERE t.student.classes.classesId=:classId AND t.subject.subjectId=:subjectId ORDER BY t.point DESC ")
    List<Transcript> selectTranscriptBySubjectAndClass(@Param("classId") long classId, @Param("subjectId") long subjectId);
}
