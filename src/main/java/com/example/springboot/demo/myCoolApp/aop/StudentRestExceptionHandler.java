package com.example.springboot.demo.myCoolApp.aop;

import com.example.springboot.demo.myCoolApp.exception.StudentErrorResponse;
import com.example.springboot.demo.myCoolApp.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //
//The @ControllerAdvice annotation
// is a Spring annotation that allows you to handle exceptions across the whole application, not just to an individual
// controller. You can think of it as an interceptor of exceptions thrown by methods annotated with @RequestMapping or
// one of the shortcuts.
public class StudentRestExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());
        //  body             , status code
        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }

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
