package com.example.demo.controller;

import com.example.demo.model.Classes;
import com.example.demo.service.IClasses;
import com.example.demo.service.ISemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/Class")

public class ClassController {
    @Autowired
    private IClasses iClasses;
    @Autowired
    private ISemester iSemester;

    @GetMapping
    public ResponseEntity<List<Classes>> findAllClass() {
        return new ResponseEntity<>(iClasses.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Classes> classesOptional = iClasses.findById(id);
        if(classesOptional.isPresent()){
        return new ResponseEntity<>(classesOptional.get(),HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/create-class")
    private ResponseEntity<?> createClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(iClasses.save(classes), HttpStatus.CREATED);

    }

    @PutMapping("/update-class")
    private ResponseEntity<?> updateClass(@RequestBody Classes classes) {
        Optional<Classes> optionalClasses = iClasses.findById(classes.getClassesId());
        if (optionalClasses.isPresent()) {
            return new ResponseEntity<>(iClasses.save(classes), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Long id) {
        Optional<Classes> customerOptional = iClasses.findById(id);
        if (customerOptional.isPresent()) {
            iClasses.delete(id);
            return new ResponseEntity<>("The customer has been deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/{id}")
//    private ResponseEntity<Classes> getClass(@PathVariable("id") Long id) {
//        Optional<Classes> classesOptional = iClasses.findById(id);
//        if (classesOptional.isPresent()) {
//            return new ResponseEntity<>(classesOptional.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

}
