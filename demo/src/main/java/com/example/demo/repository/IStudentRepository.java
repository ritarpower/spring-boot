package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT s FROM Student s JOIN FETCH s.clazz WHERE s.name LIKE %?1%")
    Page<Student> findByName(String name, Pageable pageable);
}
