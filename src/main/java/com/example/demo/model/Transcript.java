package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    private double point;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Student student;
}
