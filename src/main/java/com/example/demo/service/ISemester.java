package com.example.demo.service;

//import com.example.md6be.model.Semester;

import com.example.demo.model.Semester;

public interface ISemester extends ICRUD<Semester>{

    Semester findBySemesterName(String nameSemester);


}
