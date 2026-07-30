package com.example.thymeleaf_demo.controller;

import com.example.thymeleaf_demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("title", "Spring Boot Thymeleaf Demo");
        model.addAttribute("student", new Student());

        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {

        students.add(student);

        return "redirect:/students";
    }

    @GetMapping("/students")
    public String students(Model model) {

        model.addAttribute("students", students);
        model.addAttribute("count", students.size());

        return "students";
    }
}