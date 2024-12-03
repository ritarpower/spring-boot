package com.example.demo.controller;

import com.example.demo.model.Clazz;
import com.example.demo.model.Student;
import com.example.demo.service.Clazz.IClazzService;
import com.example.demo.service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClazzService clazzService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Student> list = studentService.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/show-create-form")
    public String showCreateForm(Model model) {
        model.addAttribute("clazzes", clazzService.findAll());
        model.addAttribute("student", new Student());
        return "create-form";
    }

    @PostMapping("save-student")
    public String save(Student student) {
        studentService.save(student);
        return "redirect:/";
    }
}
