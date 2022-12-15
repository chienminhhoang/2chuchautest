package com.example.demo.controller;

import com.example.demo.Inp.Input;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.model.Transcript;
import com.example.demo.service.IClasses;
import com.example.demo.service.IStudent;
import com.example.demo.service.ISubject;
import com.example.demo.service.ITranscript;
//import com.example.md6be.Inp.Input;
//import com.example.md6be.model.Student;
//import com.example.md6be.model.Subject;
//import com.example.md6be.model.Transcript;
//import com.example.md6be.service.IClasses;
//import com.example.md6be.service.IStudent;
//import com.example.md6be.service.ISubject;
//import com.example.md6be.service.ITranscript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping(value = "api/transcript")
public class TranscriptController {
    @Autowired
    ITranscript transcriptService;
    @Autowired
    ISubject subjectService;
    @Autowired
    IStudent studentService;
    @Autowired
    IClasses iClasses;

    @GetMapping
    public ResponseEntity<List<Transcript>> findAll() {
        return new ResponseEntity<>(transcriptService.getAll(), HttpStatus.OK);
    }

    @PostMapping("create-transcript")
    public ResponseEntity<?> creatTranscript(@RequestBody Transcript transcript) {
        return new ResponseEntity<>(transcriptService.save(transcript), HttpStatus.CREATED);
    }

    @PutMapping("update-transcript")
    public ResponseEntity<?> updateTranscript(@RequestBody Transcript transcript) {
        Optional<Transcript> transcriptOptional = transcriptService.findById(transcript.getTranscriptId());
        if (transcriptOptional.isPresent()) {
            return new ResponseEntity<>(transcriptService.save(transcript), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("delete-transcript/{id}")
    public ResponseEntity<?> deleteTranscript(@PathVariable("id") Long id){
        Optional<Transcript> transcriptOptional = transcriptService.findById(id);
        if(transcriptOptional.isPresent()){
            transcriptService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
