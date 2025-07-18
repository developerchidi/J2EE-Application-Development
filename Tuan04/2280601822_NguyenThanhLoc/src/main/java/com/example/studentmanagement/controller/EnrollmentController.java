package com.example.studentmanagement.controller;

import com.example.studentmanagement.model.Enrollment;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.model.StudentClass;
import com.example.studentmanagement.service.EnrollmentService;
import com.example.studentmanagement.service.StudentService;
import com.example.studentmanagement.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentClassService studentClassService;

    @GetMapping("")
    public String showEnrollmentPage(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("classes", studentClassService.getAllClasses());
        return "enrollments/manage";
    }

    @GetMapping("/manage/{studentId}")
    public String manageStudentEnrollment(@PathVariable String studentId, Model model) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        List<String> enrolledClassIds = enrollments.stream().map(Enrollment::getClassId).collect(Collectors.toList());
        List<StudentClass> allClasses = studentClassService.getAllClasses();
        List<StudentClass> enrolledClasses = allClasses.stream().filter(c -> enrolledClassIds.contains(c.getId())).collect(Collectors.toList());
        List<StudentClass> availableClasses = allClasses.stream().filter(c -> !enrolledClassIds.contains(c.getId())).collect(Collectors.toList());
        model.addAttribute("student", studentService.getStudentById(studentId).orElse(null));
        model.addAttribute("enrolledClasses", enrolledClasses);
        model.addAttribute("availableClasses", availableClasses);
        return "enrollments/manage";
    }

    @PostMapping("/update")
    public String updateEnrollment(@RequestParam String studentId, @RequestParam(required = false) List<String> classIds) {
        // Xóa tất cả đăng ký cũ
        List<Enrollment> oldEnrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        for (Enrollment e : oldEnrollments) {
            enrollmentService.deleteEnrollment(e.getId());
        }
        // Thêm đăng ký mới
        if (classIds != null) {
            for (String classId : classIds) {
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(studentId);
                enrollment.setClassId(classId);
                enrollmentService.saveEnrollment(enrollment);
            }
        }
        return "redirect:/enrollments";
    }
} 