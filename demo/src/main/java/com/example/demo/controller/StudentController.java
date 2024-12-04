package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.Clazz.IClazzService;
import com.example.demo.service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClazzService clazzService;

    @GetMapping
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

    @GetMapping("/{id}/show-edit-form")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("clazzes", clazzService.findAll());
        model.addAttribute("student", studentService.findById(id));
        return "edit-form";
    }

    @GetMapping("/{id}/show-view")
    public String showView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "view";
    }

    @PostMapping("/save-student")
    public String save(Student student, RedirectAttributes redirectAttributes) {
        studentService.save(student);
        redirectAttributes.addFlashAttribute("msg", "Them moi thanh cong");
        return "redirect:/";
    }

    @PostMapping("/edit-student")
    public String edit(Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete-student")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        studentService.delete(studentService.findById(id));
        redirectAttributes.addFlashAttribute("msg", "Da xoa thanh cong!");
        return "redirect:/";
    }
}
