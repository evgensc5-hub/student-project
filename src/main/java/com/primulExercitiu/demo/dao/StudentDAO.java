package com.primulExercitiu.demo.dao;

import com.primulExercitiu.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll ();
}

