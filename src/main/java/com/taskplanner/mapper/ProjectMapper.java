package com.taskplanner.mapper;

import com.taskplanner.dto.ProjectRequestDTO;
import com.taskplanner.dto.ProjectResponseDTO;
import com.taskplanner.entity.Project;
import com.taskplanner.entity.Users;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequestDTO dto, Users user) {
         Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setCreatedBy(user);
        project.setCreatedAt(java.time.LocalDateTime.now());
        return project;
    }

    public ProjectResponseDTO toDto(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setCreatedByName(project.getCreatedBy().getName());
        dto.setCreatedByEmail(project.getCreatedBy().getEmail());
        dto.setCreatedAt(project.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        return dto;
    }
}