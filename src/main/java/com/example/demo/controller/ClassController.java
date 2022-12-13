package com.example.demo.controller;

import com.example.demo.model.Classes;
import com.example.demo.model.Semester;
import com.example.demo.service.IClasses;
import com.example.demo.service.ISemester;
//import com.example.md6be.model.Classes;
//import com.example.md6be.model.Semester;
//import com.example.md6be.service.IClasses;
//import com.example.md6be.service.ISemester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/api/Class")

public class ClassController {
    @Autowired
    private IClasses iClasses;
    @Autowired
    private ISemester iSemester;

    @GetMapping
    public ResponseEntity<List<Classes>> findAll() {
        return new ResponseEntity<>(iClasses.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    private ResponseEntity<?> createClass(@RequestBody Classes classes) {
        return new ResponseEntity<>(iClasses.save(classes), HttpStatus.CREATED);

    }

    @PutMapping("/update")
    private ResponseEntity<?> updateClass(@RequestBody Classes classes) {
        Optional<Classes> optionalClasses = iClasses.findById(classes.getClassesId());
        if (optionalClasses.isPresent()) {
            return new ResponseEntity<>(iClasses.save(classes), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @DeleteMapping("/delete-class/{id}")
//    public ResponseEntity<?> deleteClass(PathVariable("id") Long id) {
//        Optional<Classes> classesOptional = iClasses.findById(id);
//        if (classesOptional.isPresent()) {
//            return new ResponseEntity<>("Delete succesfully",HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//
//    }
    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Long id) {
        Optional<Classes> customerOptional = iClasses.findById(id);
        if (customerOptional.isPresent()) {
            return new ResponseEntity<>("The customer has been deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}

//    public ResponseEntity<List<Classes>> findAll() {
//        List<Classes> classes = iClasses.getAll();
//        System.out.println("List class : ");
//
//        for (int i = 0; i < classes.size(); i++) {
//            System.out.println(classes.get(i));
//        }
//        return new ResponseEntity<>(iClasses.findAll(), HttpStatus.OK);
//    }

//    public Classes createClass() {
//        System.out.println("Enter id");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//        System.out.println("Enter Name");
//        String name = scanner.nextLine();
//        scanner.nextLine();
//        System.out.println("Enter semester");
//        String nameSemester = scanner.nextLine();
//        Classes classes = new Classes(id, name);
//        Semester semester = iSemester.findBySemesterName(nameSemester);
//        classes.setSemester(semester);
//        return iClasses.save(classes);
//    }
//
//    public Classes updateClass() {
//        System.out.println("Enter Id");
//        Long id = scanner.nextLong();
//        Optional<Classes> classesOptional = iClasses.findById(id);
//        if (classesOptional.isPresent()) {
//            Classes classes = new Classes();
//            System.out.println("Enter Id");
//            Long idClass = scanner.nextLong();
//            scanner.nextLine();
//            System.out.println("Enter Name");
//            String name = scanner.nextLine();
//            classes.setName(name);
//            classes.setClassesId(idClass);
//        } else {
//            System.out.println("Not found");
//        }
//        return new Classes();
//    }
//
//
//    public boolean deleteClass() {
//        Classes classes = new Classes();
//        boolean flag = true;
//        try {
//            System.out.println("Enter Id");
//            Long id = scanner.nextLong();
//            classes.getClassesId();
//            Optional<Classes> classesOptional = iClasses.findById(id);
//            if (classesOptional.isPresent()) {
//                iClasses.delete(id);
//                System.out.println("Delete successfull");
//                flag = true;
//            } else {
//                System.out.println("not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return flag = false;
//    }
////        try {
////            System.out.println("enter id");
////            id = scanner.nextLong();
////            iClasses.delete(id);
////            return new ResponseEntity<>(HttpStatus.OK);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return new ResponseEntity<>(HttpStatus.OK);
////        }
//
//}
