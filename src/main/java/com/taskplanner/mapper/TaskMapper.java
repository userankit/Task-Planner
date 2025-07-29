package com.taskplanner.mapper;
import com.taskplanner.dto.TaskRequestDTO;
import com.taskplanner.dto.TaskResponseDTO;
import com.taskplanner.entity.Project;
import com.taskplanner.entity.Task;
import com.taskplanner.entity.Users;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;

@Component
public class TaskMapper {

        public Task toEntity(TaskRequestDTO dto, Project project, Users assignee) {
            return Task.builder()
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .status(dto.getStatus())
                    .dueDate(dto.getDueDate())
                    .createdAt(java.time.LocalDateTime.now())
                    .project(project)
                    .assignee(assignee)
                    .build();
        }

        public TaskResponseDTO toDto(Task task) {
            TaskResponseDTO dto = new TaskResponseDTO();
            dto.setId(task.getId());
            dto.setTitle(task.getTitle());
            dto.setDescription(task.getDescription());
            dto.setStatus(task.getStatus());
            dto.setDueDate(task.getDueDate());
            dto.setAssigneeName(task.getAssignee().getName());
            dto.setProjectName(task.getProject().getName());
            dto.setCreatedAt(task.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            return dto;
        }
}
