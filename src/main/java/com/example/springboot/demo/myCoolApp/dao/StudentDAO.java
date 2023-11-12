package com.example.springboot.demo.myCoolApp.dao;

import com.example.springboot.demo.myCoolApp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void remove(Student student);

    void deleteById(Integer id);

    int deleteAll();
}
