package com.example.studentmanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "enrollments")
public class Enrollment {
    @Id
    private String id;
    private String studentId; // Tham chiếu đến Student
    private String classId;   // Tham chiếu đến StudentClass
} 