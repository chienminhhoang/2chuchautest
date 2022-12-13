package com.example.demo.controller;

import com.example.demo.model.Semester;
import com.example.demo.service.implement.SemesterService;
//import com.example.md6be.model.Semester;
//import com.example.md6be.service.implement.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    Scanner scanner = new Scanner(System.in);

    public Semester createSemester() {
        System.out.println("Enter name semester");
        String nameSemester = scanner.nextLine();
        System.out.println("Enter Number of semester");
        int numberSemester = scanner.nextInt();
        Semester semester = new Semester(nameSemester,numberSemester);
        semesterService.save(semester);
        return semester;
    }
    public  void getAllSemester(){
        List<Semester> list = semesterService.getAll();
        if(list.isEmpty()){
            System.out.println("class rong");
            return;
        }
        System.out.println("Toan bo semesters:");
        for(int i=0;i<list.size();i++){
            System.out.println("Semester id: "+list.get(i).getSemesterId()+ ", semester name: "+list.get(i).getSemesterName()+", numbers of classes: "+list.get(i).getClassess().size()+", numbers of subjects: "+list.get(i).getSubjects().size());
        }
    }


}
