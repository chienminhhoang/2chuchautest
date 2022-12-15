package com.example.demo.service.implement;

import com.example.demo.Repository.SemesterRepository;
import com.example.demo.model.Semester;
import com.example.demo.service.ISemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SemesterService implements ISemester {
    @Autowired
    SemesterRepository semesterRepository;
    @Override
    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public void delete(Long id) {
        semesterRepository.deleteById(id);

    }

    @Override
    public List<Semester> getAll() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester update(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public Optional<Semester> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Semester> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester findBySemesterName(String nameSemester) {
        Semester semester = new Semester();
//        return semesterRepository.findBySemesterName(nameSemester);
        return semester;
    }

}
