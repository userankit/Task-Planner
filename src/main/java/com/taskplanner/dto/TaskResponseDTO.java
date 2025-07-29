package com.taskplanner.dto;

import com.taskplanner.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private String assigneeName;
    private String projectName;
    private String createdAt;
}
