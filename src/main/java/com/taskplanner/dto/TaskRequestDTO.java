package com.taskplanner.dto;

import com.taskplanner.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDTO {
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private Long projectId;
    private Long assigneeId;

}
