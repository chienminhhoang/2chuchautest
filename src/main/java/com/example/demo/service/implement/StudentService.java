package com.example.demo.service.implement;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;
//import com.example.md6be.Repository.StudentRepository;
//import com.example.md6be.model.Student;
//import com.example.md6be.service.IStudent;
import com.example.demo.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudent {
@Autowired
StudentRepository studentRepository;
    @Override
    public Student save(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> selectStudentFailed() {
        return studentRepository.selectStudentFailed();
    }
}
