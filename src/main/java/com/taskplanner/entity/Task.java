package com.taskplanner.entity;

import com.taskplanner.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
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
