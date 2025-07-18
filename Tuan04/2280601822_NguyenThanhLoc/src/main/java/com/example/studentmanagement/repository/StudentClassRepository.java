package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.StudentClass;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentClassRepository extends MongoRepository<StudentClass, String> {
    List<StudentClass> findBySubjectId(String subjectId);
} 