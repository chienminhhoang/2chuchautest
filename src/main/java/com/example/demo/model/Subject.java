package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {
    @Id
    @Column(name = "SUBJECT_ID")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private List<Transcript> transcripts;

    public Subject(Long subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                '}';
    }
}
