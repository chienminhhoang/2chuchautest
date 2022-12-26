package com.example.demo.service;

import com.example.demo.model.Transcript;
import org.springframework.data.repository.query.Param;
//import com.example.md6be.model.Transcript;

import java.util.List;

public interface ITranscript extends ICRUD<Transcript>{
//  List<Transcript> selectTranscriptBySubjectAndClass(Long classId, Long subjectId);
  List<Transcript> findTranscriptBySubject(Long subjectId);
  List<Transcript> findTranscriptsBySubject_SubjectId(Long id);
List<Transcript>findTranscriptsBySubject_id(Long id);
Iterable<Transcript>findAllBySubject_Id(Long id);
  List<Transcript> selectTranscriptBySubjectAndClass(long classesId,long subjectId);


}
