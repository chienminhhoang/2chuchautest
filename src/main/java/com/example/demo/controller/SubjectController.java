package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.implement.SubjectService;
import com.example.demo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@CrossOrigin(origins = "*", maxAge = 3600)


@RequestMapping(value = "/api/Subject")
@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> findAllSubject() {
        return new ResponseEntity<>(subjectService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create-subject")
    public ResponseEntity<?> creatSubject(@RequestBody Subject subject) {
        return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("/update-subject")
    public ResponseEntity<?> updateSubject(@RequestBody Subject subject) {
        Optional<Subject> subjectOptional = subjectService.findById(subject.getSubjectId());
        if (subjectOptional.isPresent()) {
            return new ResponseEntity<>(subjectService.save(subject), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/delete-subject/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable("subjectId") Long subjectId){
        Optional<Subject> subjectOptional = subjectService.findById(subjectId);
        if(subjectOptional.isPresent()){
            subjectService.delete(subjectId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Optional<Subject> optionalSubject = subjectService.findById(id);

        if (optionalSubject.isPresent()) {
            return new ResponseEntity<>(optionalSubject.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//
//    public Subject createSubject() {
//        System.out.println("Enter Id");
//        Long subjectId = scanner.nextLong();
//        scanner.nextLine();
//        System.out.println("Enter Name");
//        String name = scanner.nextLine();
//        Subject subject = new Subject(subjectId,name);
//        return subjectService.save(subject);
//    }
//
//    public ResponseEntity<?> updateSubject() {
//        System.out.println("Enter Id");
//        Long subjectId = scanner.nextLong();
//        Optional<Subject> subjectOptional = subjectService.findById(subjectId);
//        if (subjectOptional.isPresent()) {
//            scanner.nextLine();
//            System.out.println("Enter Name");
//            String name = scanner.nextLine();
//            Subject subject = new Subject(subjectId, name);
//            return new ResponseEntity<>(subjectService.save(subject), HttpStatus.CREATED);
//        } else {
//            System.out.println("Not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//
//    }
//
//    public ResponseEntity<?> deleteSubject() {
//        System.out.println("Enter id");
//        Long id = scanner.nextLong();
//        Optional<Subject> subjectOptional = subjectService.findById(id);
//        if (subjectOptional.isPresent()) {
//            subjectService.delete(id);
//            return new ResponseEntity<>(subjectOptional.get(), HttpStatus.OK);
//        } else {
//            System.out.println("not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
