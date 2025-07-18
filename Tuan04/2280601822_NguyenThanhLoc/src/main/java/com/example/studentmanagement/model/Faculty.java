package com.example.studentmanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "faculties")
public class Faculty {
    @Id
    private String id;
    private String name;
} 