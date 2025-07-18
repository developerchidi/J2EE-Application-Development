package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
    List<Enrollment> findByClassId(String classId);
    List<Enrollment> findByStudentId(String studentId);
    void deleteByStudentIdAndClassId(String studentId, String classId);
} 