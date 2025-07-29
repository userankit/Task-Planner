package com.taskplanner.service;

import com.taskplanner.dto.ProjectRequestDTO;
import com.taskplanner.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {
    ProjectResponseDTO createProject(ProjectRequestDTO requestDTO);
    List<ProjectResponseDTO> getAllProjects();
}
