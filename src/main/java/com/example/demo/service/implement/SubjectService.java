package com.example.demo.service.implement;

import com.example.demo.Repository.SubjectRepository;
import com.example.demo.model.Subject;
import com.example.demo.service.ISubject;
//import com.example.md6be.Repository.SubjectRepository;
//import com.example.md6be.model.Subject;
//import com.example.md6be.service.ISubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubjectService implements ISubject {
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);

    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Optional<Subject> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }
    @Override
    public Subject findSubjectByName(String subjectName) {
        Subject s = new Subject();
//        return subjectRepository.findSubjectByName(subjectName);
        return  s;
    }
}
