package com.example.demo.service.Student;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);

    void save(Student student);

    Student findById(Integer id);

    void delete(Student student);
}
