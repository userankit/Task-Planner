package com.taskplanner.entity;

import com.taskplanner.enums.TaskStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;
        private String description;

        @Enumerated(EnumType.STRING)
        private TaskStatus status;

        private LocalDate dueDate;

        @ManyToOne
        private Users assignee;

        @ManyToOne
        private Project project;

        private LocalDateTime createdAt;


}
