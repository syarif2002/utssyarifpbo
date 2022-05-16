package com.najib.lupapw.controller;

import com.najib.lupapw.entity.Student;
import com.najib.lupapw.service.framework.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StudentWebController {
    private StudentService studentService;

    @GetMapping("/student")
    public String index(Model model) {

        model.addAttribute("student", studentService.getAllStudents());
        return "student";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("student", new Student());
        return "formStudent";
    }

    @PostMapping(value = "/create")
    public String tambahStudent(Model model, Student student) {
        model.addAttribute("student", studentService.save(student));
        return "redirect:student";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "student";
    }
}
