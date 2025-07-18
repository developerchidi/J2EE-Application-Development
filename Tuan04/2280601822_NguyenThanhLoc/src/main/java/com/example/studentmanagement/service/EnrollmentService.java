package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Enrollment;
import com.example.studentmanagement.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsByStudentId(String studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getEnrollmentsByClassId(String classId) {
        return enrollmentRepository.findByClassId(classId);
    }

    public Optional<Enrollment> getEnrollmentById(String id) {
        return enrollmentRepository.findById(id);
    }

    public Enrollment saveEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(String id) {
        enrollmentRepository.deleteById(id);
    }

    public void deleteByStudentIdAndClassId(String studentId, String classId) {
        enrollmentRepository.deleteByStudentIdAndClassId(studentId, classId);
    }
} 