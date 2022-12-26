package com.example.demo.controller;

import com.example.demo.model.Semester;
import com.example.demo.service.implement.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/semester/")
@RestController

public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public ResponseEntity<List<Semester>> findAllSemester() {
        return new ResponseEntity<>(semesterService.getAll(), HttpStatus.OK);
    }


    @PostMapping("create-semester")
    public ResponseEntity<?> createSemester(@RequestBody Semester semester) {
        return new ResponseEntity<>(semesterService.save(semester), HttpStatus.CREATED);
    }

    @PutMapping(value = "update-semester")
    public ResponseEntity<Semester> update(@RequestBody Semester semester) {
        Optional<Semester> updateSemester = semesterService.findById(semester.getSemesterId());
        if (updateSemester.isPresent()) {
            return new ResponseEntity<>(semesterService.save(semester), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "delete-semester/{semesterId}")
    public ResponseEntity<?> deleteSemester(@PathVariable("semesterId") Long semesterId) {
        Optional<Semester> semesterOptional = semesterService.findById(semesterId);
        if (semesterOptional.isPresent()) {
            semesterService.delete(semesterId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{semesterId}")
    private ResponseEntity getSemesterById(@PathVariable Long semesterId) {
        Optional<Semester> optionalSemester = semesterService.findById(semesterId);

        if (optionalSemester.isPresent()) {
            return new ResponseEntity(optionalSemester.get(),HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
