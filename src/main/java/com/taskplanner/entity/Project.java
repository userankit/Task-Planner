package com.taskplanner.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private Users createdBy;

    private LocalDateTime createdAt;
}
