package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;@Entity
@Getter
@Setter
@NoArgsConstructor

public class Semester {
    @Id
    @Column(name = "SEMESTER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semesterId;

    private String semesterName;

    private int numberOfSubjects;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Classes> classess = new ArrayList<>();

    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public Semester(String semesterName) {
        this.semesterName = semesterName;
    }

    public Semester(String semesterName, int numberOfSubjects) {
        this.semesterName = semesterName;
        this.numberOfSubjects = numberOfSubjects;
    }
}
