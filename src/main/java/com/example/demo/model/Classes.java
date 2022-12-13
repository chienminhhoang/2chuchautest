package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classes {
    public Classes(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "CLASS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long classesId;
    private String name;
    @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Student> students = new ArrayList<>();

    public Classes(Long classesId, String name) {
        this.classesId = classesId;
        this.name = name;
    }

    public Long getClassesId() {
        return classesId;
    }

    public Classes setClassesId(Long classesId) {
        this.classesId = classesId;
        return null;
    }
    @ManyToOne
    @JoinColumn(name = "SEMESTER_ID")
    private Semester semester;
    @Override
    public String toString() {
        return "Classes{" +
                "classesId=" + classesId +
                ", name='" + name + '\'' +
                "," +
                '}';
    }
}
