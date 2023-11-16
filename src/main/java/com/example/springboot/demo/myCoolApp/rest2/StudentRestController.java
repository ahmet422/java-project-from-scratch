package com.example.springboot.demo.myCoolApp.rest2;

import com.example.springboot.demo.myCoolApp.entity2.Student;
import com.example.springboot.demo.myCoolApp.exception.StudentErrorResponse;
import com.example.springboot.demo.myCoolApp.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();

    // define @postconstruct to load the student data
   // The PostConstruct annotation is used on a method that needs to be executed after dependency injection is done to
    // perform any initialization. This method MUST be invoked before the class is put into service.
    // This annotation MUST be supported on all classes that support dependency injection.
    @PostConstruct
    public void loadData(){
        students.add(new Student("Aho", "Maho"));
        students.add(new Student("Aho1", "Maho1"));
        students.add(new Student("Aho2", "Maho2"));
        students.add(new Student("Aho3", "Maho3"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable("id")  Integer id){

        if(id<students.get(0).getId() || id>students.get(students.size()-1).getId())
            throw new StudentNotFoundException("No student with such id: " + id);

        for (Student s: students) {
            if(s.getId()==id) return s;
        }
        return null;
    }

    // @ExceptionHandler is used in Spring Boot to handle specific exceptions and send custom responses to the client.
    // The annotated method is invoked when the specified exceptions are thrown from a @Controller
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
                                    //  body             , status code
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }


    // ResponseEntity in Spring Boot
    // is a class that represents an HTTP response. It includes the status code, headers
    //, and body of the response. ResponseEntity can be used to customize the HTTP response that your Spring application
    // sends to the client. For example, you can set the HTTP status code, set custom headers, and include a response body.

    // catch any exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        //                                   body             , status code
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
