package com.example.demo.Repository;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query("SELECT distinct s.student AS sumAll FROM Transcript AS s WHERE s.point<5 ")
//    List<Student> selectStudentFailed();

}
