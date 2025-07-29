package com.taskplanner.controller;

import com.taskplanner.service.ProjectService;
import com.taskplanner.dto.ProjectRequestDTO;
import com.taskplanner.dto.ProjectResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody @  Valid ProjectRequestDTO requestDTO) {
        return new ResponseEntity<>(projectService.createProject(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
