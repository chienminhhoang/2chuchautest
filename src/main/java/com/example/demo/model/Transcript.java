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
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"STUDENT_ID", "SUBJECT_ID"})})

public class Transcript {
    @Id
    @Column(name = "TRANSCIPT_ID", nullable = false)

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long transcriptId;
    private double point;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")

    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    public Transcript(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", point=" + point +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
