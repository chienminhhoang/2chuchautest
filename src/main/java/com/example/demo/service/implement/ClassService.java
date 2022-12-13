package com.example.demo.service.implement;

//import com.example.md6be.Repository.ClassRepository;
//import com.example.md6be.model.Classes;
//import com.example.md6be.model.Student;
//import com.example.md6be.service.IClasses;
import com.example.demo.Repository.ClassRepository;
import com.example.demo.model.Classes;
import com.example.demo.model.Student;
import com.example.demo.service.IClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClasses {

    @Autowired
    ClassRepository classRepository;
    @Override
    public Classes save(Classes classes) {

        return classRepository.save(classes);
    }


    @Override
    public void delete(Long id) {
        classRepository.deleteById(id);

    }

    @Override
    public List<Classes> getAll() {
        return classRepository.findAll();
    }

    @Override
    public Classes update(Classes classes) {
        return classRepository.save(classes);
    }

    @Override
    public Optional<Classes> findById(Long idClass) {
        return classRepository.findById(idClass);
    }

    @Override
    public Optional<Classes> findByName(String Name) {
        return Optional.empty();
    }

    @Override
    public List<Classes> findAll() {
        return classRepository.findAll();
    }


    @Override
    public Classes findClassesByName(String className) {
        return classRepository.findClassesByName(className);
    }

    @Override
    public List<Student> findAllStudentFromClass(String name) {
        return classRepository.findStudentByClass(name);
    }
}
