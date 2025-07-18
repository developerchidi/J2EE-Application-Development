package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Subject;
import com.example.studentmanagement.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getSubjectsByFacultyId(String facultyId) {
        return subjectRepository.findByFacultyId(facultyId);
    }

    public Optional<Subject> getSubjectById(String id) {
        return subjectRepository.findById(id);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }
} 