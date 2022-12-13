package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CascadeType;

//import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "STUDENT_ID")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;


    }

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Transcript> transcriptList ;

    @ManyToOne
    @JoinColumn(name = "CLASS_ID")

    private Classes classes;


    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Transcript> getTranscriptList() {
        return transcriptList;
    }

    public void setTranscriptList(List<Transcript> transcriptList) {
        this.transcriptList = transcriptList;
    }

    public Classes getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", transcriptList=" + transcriptList +
                ", classes=" + classes +
                '}';
    }

    public double totalPoint() {
        double total = 0;
        for (int i = 0; i < transcriptList.size(); i++) {
            total += transcriptList.get(i).getPoint();


        }
        return total;
    }
}
