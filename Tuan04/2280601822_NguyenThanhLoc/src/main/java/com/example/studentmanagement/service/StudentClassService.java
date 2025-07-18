package com.example.studentmanagement.service;

import com.example.studentmanagement.model.StudentClass;
import com.example.studentmanagement.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;

    public List<StudentClass> getAllClasses() {
        return studentClassRepository.findAll();
    }

    public List<StudentClass> getClassesBySubjectId(String subjectId) {
        return studentClassRepository.findBySubjectId(subjectId);
    }

    public Optional<StudentClass> getClassById(String id) {
        return studentClassRepository.findById(id);
    }

    public StudentClass saveClass(StudentClass studentClass) {
        return studentClassRepository.save(studentClass);
    }

    public void deleteClass(String id) {
        studentClassRepository.deleteById(id);
    }
} 