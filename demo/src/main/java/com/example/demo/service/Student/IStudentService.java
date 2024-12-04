package com.example.demo.service.Student;

import com.example.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(Integer id);

    void delete(Student student);
}
