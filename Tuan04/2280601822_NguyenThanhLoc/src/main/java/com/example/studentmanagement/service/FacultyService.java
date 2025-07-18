package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Faculty;
import com.example.studentmanagement.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(String id) {
        return facultyRepository.findById(id);
    }

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(String id) {
        facultyRepository.deleteById(id);
    }
} 