package com.example.demo.service.implement;

import com.example.demo.Repository.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.model.Transcript;
import com.example.demo.service.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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
        List<Student> students = new ArrayList<>();
//        return studentRepository.selectStudentFailed();
        return students;
    }

    public double totalPoint(List<Transcript> transcriptList) {
        double total = 0;
        for (Transcript transcript : transcriptList) {
            total += transcript.getPoint();

        }
        return total;
    }
}
