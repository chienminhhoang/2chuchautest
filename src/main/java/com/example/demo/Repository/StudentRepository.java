package com.example.demo.Repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //    @Query("SELECT distinct s.student AS sumAll FROM Transcript AS s WHERE s.point<5 ")
//    List<Student> selectStudentFailed();
@Query(value = "SELECT s.id, s.name, s.age , sum(point) as Total from Student s join Transcript t on s.id = t.student_id where s.id not in(select distinct student_Id from transcript where point<5 ) group by s.id order by Total desc LIMIT 5",nativeQuery = true)
    List<?> ListScholarship();
}
