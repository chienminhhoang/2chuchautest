package com.example.demo.service;

import com.example.demo.model.Subject;
//import com.example.md6be.model.Subject;

public interface ISubject extends  ICRUD<Subject>{
    Subject findSubjectByName(String subjectName);
}
