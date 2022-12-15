package com.example.demo.Repository;
import com.example.demo.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
//    @Query("SELECT t FROM Transcript t WHERE t.student.classes.classesId=:classId AND t.subject.subjectId=:subjectId ORDER BY t.point DESC ")
//    List<Transcript> selectTranscriptBySubjectAndClass(@Param("classId") long classId, @Param("subjectId") long subjectId);
}
