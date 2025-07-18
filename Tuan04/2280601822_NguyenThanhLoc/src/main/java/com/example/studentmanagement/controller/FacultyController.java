package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Faculty;
import com.example.studentmanagement.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("")
    public String listFaculties(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "faculties/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "faculties/add";
    }

    @PostMapping("/add")
    public String addFaculty(@ModelAttribute Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return "redirect:/faculties";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Faculty faculty = facultyService.getFacultyById(id).orElse(null);
        model.addAttribute("faculty", faculty);
        return "faculties/edit";
    }

    @PostMapping("/edit/{id}")
    public String editFaculty(@PathVariable String id, @ModelAttribute Faculty faculty) {
        faculty.setId(id);
        facultyService.saveFaculty(faculty);
        return "redirect:/faculties";
    }

    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable String id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculties";
    }
} 