package com.example.studentmanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "student_classes")
public class StudentClass {
    @Id
    private String id;
    private String name;
    private String subjectId; // Tham chiếu đến Subject
} 