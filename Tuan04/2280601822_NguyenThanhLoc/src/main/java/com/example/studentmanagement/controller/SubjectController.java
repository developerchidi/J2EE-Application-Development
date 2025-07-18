package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.model.Faculty;
import com.example.studentmanagement.service.SubjectService;
import com.example.studentmanagement.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private FacultyService facultyService;

    @GetMapping("")
    public String listSubjects(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "subjects/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "subjects/add";
    }

    @PostMapping("/add")
    public String addSubject(@ModelAttribute Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Subject subject = subjectService.getSubjectById(id).orElse(null);
        model.addAttribute("subject", subject);
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "subjects/edit";
    }

    @PostMapping("/edit/{id}")
    public String editSubject(@PathVariable String id, @ModelAttribute Subject subject) {
        subject.setId(id);
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable String id) {
        subjectService.deleteSubject(id);
        return "redirect:/subjects";
    }
} 