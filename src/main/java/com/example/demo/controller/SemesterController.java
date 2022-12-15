package com.example.demo.controller;

import com.example.demo.model.Semester;
import com.example.demo.model.Student;
import com.example.demo.service.implement.SemesterService;
//import com.example.md6be.model.Semester;
//import com.example.md6be.service.implement.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
@RequestMapping(value = "api/semester/")
@Controller
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @GetMapping
    public ResponseEntity<List<Semester>> findAll() {
        return new ResponseEntity<>(semesterService.getAll(), HttpStatus.OK);
    }

    @PostMapping("create-semester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester) {
        return new ResponseEntity<>(semesterService.save(semester), HttpStatus.CREATED);
    }

    @PutMapping("update-semester")
    public ResponseEntity<?> updateSemester(@RequestBody Semester semester) {
        Optional<Semester> semesterOptional = semesterService.findById(semester.getSemesterId());
        if(semesterOptional.isPresent()){
            return new ResponseEntity<>(semesterService.save(semester),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("delete-semester")
    public ResponseEntity<?> deleteSemester(@PathVariable("id") Long id){
        Optional<Semester> semesterOptional = semesterService.findById(id);
        if(semesterOptional.isPresent()){
            semesterService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
