package com.example.demo.Repository;
import com.example.demo.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
//    @Query("SELECT t FROM Transcript t WHERE t.student.classes.classesId=:classId AND t.subject.subjectId=:subjectId ORDER BY t.point DESC ")
//    List<Transcript> selectTranscriptBySubjectAndClass(@Param("classId") long classId, @Param("subjectId") long subjectId);
    List<Transcript> findTranscriptBySubject(Long subjectId);
//    @Query("SELECT t FROM  transcript t WHERE subjectId");
//    @Query("SELECT * FROM Transcript left join subject on Transcript .subject_subject_id = subject.subject_id")
    List<Transcript> findTranscriptsBySubject_SubjectId(Long id);
    @Query(value = "select * from Transcript where subject_subject_id = ?",   nativeQuery = true)
    List<Transcript> findTranscriptsBySubject_id(@Param("subjectId") Long id);
    List<Transcript> findAllBySubject_SubjectId(Long id);
    @Query(value = "select m from Transcript m where m.student.classes.classesId=:classesID And m.subject.subjectId=:subjectId ORDER BY m.point desc ")
    List<Transcript> selectTranscriptBySubjectAndClass(@Param("classesID") long classId,@Param("subjectId") long subjectId);

}
