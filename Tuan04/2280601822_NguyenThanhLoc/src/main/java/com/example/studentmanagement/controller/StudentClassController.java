package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.StudentClass;
import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.service.StudentClassService;
import com.example.studentmanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public String listClasses(Model model) {
        model.addAttribute("classes", studentClassService.getAllClasses());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "classes/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("studentClass", new StudentClass());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "classes/add";
    }

    @PostMapping("/add")
    public String addClass(@ModelAttribute StudentClass studentClass) {
        studentClassService.saveClass(studentClass);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        StudentClass studentClass = studentClassService.getClassById(id).orElse(null);
        model.addAttribute("studentClass", studentClass);
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "classes/edit";
    }

    @PostMapping("/edit/{id}")
    public String editClass(@PathVariable String id, @ModelAttribute StudentClass studentClass) {
        studentClass.setId(id);
        studentClassService.saveClass(studentClass);
        return "redirect:/classes";
    }

    @GetMapping("/delete/{id}")
    public String deleteClass(@PathVariable String id) {
        studentClassService.deleteClass(id);
        return "redirect:/classes";
    }
} 