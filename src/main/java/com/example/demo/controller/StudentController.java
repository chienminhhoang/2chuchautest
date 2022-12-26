package com.example.demo.controller;
import com.example.demo.model.Student;
import com.example.demo.service.IClasses;
import com.example.demo.service.ISubject;
import com.example.demo.service.implement.StudentService;
import com.example.demo.service.implement.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    TranscriptService transcriptService;
    @Autowired
    IClasses iClasses;
    @Autowired
    ISubject iSubject;


    @GetMapping
    public ResponseEntity<List<Student>> findAllStudent() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }


    @GetMapping("ListScholarShip")
    private ResponseEntity<?> getListScholarship() {
        return new ResponseEntity<>(studentService.ListScholarship(), HttpStatus.OK);
    }

    @PostMapping("create-student")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("update-student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Optional<Student> optionalStudent = studentService.findById(student.getId());
        if (optionalStudent.isPresent()) {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete-student/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable("id") Long id) {
        Optional<Student> optionalStudent = studentService.findById(id);
        if (optionalStudent.isPresent()) {
            studentService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{id}")
    private ResponseEntity getStudentById(@PathVariable("id") Long id) {
        Optional<Student> optionalStudent = studentService.findById(id);

        if (optionalStudent.isPresent()) {
            return new ResponseEntity(optionalStudent.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }



//    Scanner scanner = new Scanner(System.in);
//
//
//    public Student CreateStudent() {
//        System.out.println("Enter id");
//        Long id = scanner.nextLong();
//        scanner.nextLine();
//        System.out.println("Enter Name");
//        String name = scanner.nextLine();
//        System.out.println("Enter Age");
//        int age = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Nhap ten lop:");
//        String classesName = scanner.nextLine();
//        Student student = new Student(id, name, age);
//        student.setClasses(classService.findClassesByName(classesName));
//        return studentService.save(student);
//
//
//    }
//
//    public ResponseEntity<?> updateStudent2() {
//        System.out.println("Enter Id");
//        Long studentId = scanner.nextLong();
//        Optional<Student> studentOptional = studentService.findById(studentId);
//        if (studentOptional.isPresent()) {
//            scanner.nextLine();
//            System.out.println("Enter Name");
//            String name = scanner.nextLine();
//            System.out.println("enter age");
//            int age = scanner.nextInt();
//            Student student = new Student(studentId, name, age);
//            return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
//        } else {
//            System.out.println("Not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//
//    }
//
//    public boolean updateStudent() {
//        System.out.println("Thay doi thong tin co ban:");
//        System.out.println("Nhap id:");
//        long id = scanner.nextLong();
//        scanner.nextLine();
//        System.out.println("Nhap ten:");
//        String name = scanner.nextLine();
//        System.out.println(name);
//        System.out.println("Nhap tuoi");
//        int age = scanner.nextInt();
//        Student student = new Student(name, age);
//        student.setId(id);
////    return studentService.save(student)!=null?true:false;
//        try {
//            studentService.save(student);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public ResponseEntity<?> deleteStudent() {
//        System.out.println("Enter Id");
//        Long id = scanner.nextLong();
//        Optional<Student> studentOptional = studentService.findById(id);
//        if (studentOptional.isPresent()) {
//            studentService.delete(id);
//            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
//        } else {
//            System.out.println("not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//

//
//    public void getPointStudent() {
//        System.out.println("Enter Name Subject want to see result");
//        String nameSubject = scanner.nextLine();
//        System.out.println("Enter Name Class");
//        String nameClass = scanner.nextLine();
//        Subject subject = subjectService.findSubjectByName(nameSubject);
//        Classes classes = classService.findClassesByName(nameClass);
//        List<Transcript> transcripts = transcriptService.selectTranscriptBySubjectAndClass(classes.getClassesId(), subject.getSubjectId());
//        if (transcripts == null) {
//            System.out.println("Not found");
//            return;
//        }
//        System.out.println("point of subject " + nameSubject + " classes " + nameClass);
//        for (int i = 0; i < transcripts.size(); i++) {
//            String rank = "";
//            System.out.println("name: " + transcripts.get(i).getStudent().getName());
//            if (transcripts.get(i).getPoint() < 5) {
//                rank = "Hoc sinh yeu";
//            } else if (transcripts.get(i).getPoint() < 8) {
//                rank = "hoc sinh kha";
//            } else if (transcripts.get(i).getPoint() >= 8) {
//                rank = "hoc sinh gioi";
//            } else {
//                System.out.println("Nhap sai diem");
//            }
//            System.out.println(" have point " + transcripts.get(i).getPoint() + " rank is " + rank);
//
//        }
//        System.out.println("");
//
//    }
//
//    public void ListGoodStudents() {
//        System.out.println("Enter Name subject want to see list good students");
//        String nameSubject = scanner.nextLine();
//        System.out.println("Enter Name class");
//        String className = scanner.nextLine();
//        Subject subject = subjectService.findSubjectByName(nameSubject);
//        Classes classes = classService.findClassesByName(className);
//        List<Transcript> transcripts = transcriptService.selectTranscriptBySubjectAndClass(classes.getClassesId(), subject.getSubjectId());
//        for (int i = 0; i < transcripts.size(); i++) {
//            transcripts = transcriptService.selectTranscriptBySubjectAndClass(classes.getClassesId(), subject.getSubjectId());
//            if (transcripts.get(i).getPoint() > 8) {
//                System.out.println(transcripts.get(i).getStudent().getName() + " is goodStudent");
//            }
//
//        }
//    }
//
//    public void rating() {
//        System.out.println("Enter Name Subject want to see result");
//        String nameSubject = scanner.nextLine();
//        System.out.println("Enter Name Class");
//        String nameClass = scanner.nextLine();
//        Subject subject = subjectService.findSubjectByName(nameSubject);
//        Classes classes = classService.findClassesByName(nameClass);
//        List<Transcript> transcripts = transcriptService.selectTranscriptBySubjectAndClass(classes.getClassesId(), subject.getSubjectId());
//        if (transcripts == null) {
//            System.out.println("Not found");
//            return;
//        }
//        for (int i = 0; i < transcripts.size(); i++) {
//
//
//            transcripts = transcriptService.selectTranscriptBySubjectAndClass(classes.getClassesId(), subject.getSubjectId());
//            if (transcripts == null) {
//                System.out.println("not found");
//            }
//            System.out.println(" student " + transcripts.get(i).getStudent().getName());
//            String rank = "";
//            if (transcripts.get(i).getPoint() < 5) {
//                rank = "false";
//
//            } else {
//                rank = "pass";
//
//            }
//
//            System.out.println(" Subject: " + transcripts.get(i).getSubject().getName() + " point: " + transcripts.get(i).getPoint() + "status " + rank + " ");
//
//        }
//        System.out.println(" ");
//
//    }


}
