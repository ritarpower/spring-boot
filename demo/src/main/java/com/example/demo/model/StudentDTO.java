package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.Serializable;

public class StudentDTO implements Validator {
    private Integer id;

    /*Tim hieu notempty,
    notnull
    size: do dai cua 1 chuoi(chua Min, Max)
    Min/Max*/
//    @NotBlank(message = "Ten khong duoc de trong!")
//    @Size(min = 5, max = 50, message = "Tu 5 toi 50 ky tu!")
//    @Pattern(regexp = "",message = "Khong dung format!")
    private String name;

    private Clazz clazz;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    // Chỉ hoạt động khí sử dụng với @InitBinder để đky validator
    // Chỉ định class sử dụng validate này
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDTO studentDTO = (StudentDTO) target;
        String name = studentDTO.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.rejectValue("name","","Khong duoc de trong!");
        } else if (name.length() >50 || name.length() < 5) {
            errors.rejectValue("name","","Ten sai");
        }
    }
}
