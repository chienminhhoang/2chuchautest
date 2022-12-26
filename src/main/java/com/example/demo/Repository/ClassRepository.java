package com.example.demo.Repository;
import com.example.demo.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {
    Classes findClassesByName(String className);



}
