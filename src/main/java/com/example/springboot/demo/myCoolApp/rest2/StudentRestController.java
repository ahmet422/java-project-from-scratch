package com.example.springboot.demo.myCoolApp.rest2;

import com.example.springboot.demo.myCoolApp.entity2.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();
    @GetMapping("/students")
    public List<Student> getStudents(){
        students.add(new Student("Aho", "Maho"));
        students.add(new Student("Aho1", "Maho1"));
        students.add(new Student("Aho2", "Maho2"));
        students.add(new Student("Aho3", "Maho3"));

        return students;
    }


}
