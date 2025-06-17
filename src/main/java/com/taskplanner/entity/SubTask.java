package com.taskplanner.entity;

import com.taskplanner.enums.TaskStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDate dueDate;

    @ManyToOne
    private Task task;

    @ManyToOne
    private Users assignee;

    private LocalDateTime createdAt;
}
