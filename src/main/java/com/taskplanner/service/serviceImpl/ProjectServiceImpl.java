package com.taskplanner.service.serviceImpl;

import com.taskplanner.dto.ProjectRequestDTO;
import com.taskplanner.dto.ProjectResponseDTO;
import com.taskplanner.entity.Project;
import com.taskplanner.entity.Users;
import com.taskplanner.mapper.ProjectMapper;
import com.taskplanner.repository.ProjectRepository;
import com.taskplanner.repository.UserRepository;
import com.taskplanner.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              UserRepository userRepository,
                              ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO requestDTO) {
        Users creator = userRepository.findById(requestDTO.getCreatedById())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Project project = projectMapper.toEntity(requestDTO, creator);
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Override
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }
}

