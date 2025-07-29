package com.taskplanner.service.serviceImpl;

import com.taskplanner.dto.TaskRequestDTO;
import com.taskplanner.dto.TaskResponseDTO;
import com.taskplanner.entity.Project;
import com.taskplanner.entity.Task;
import com.taskplanner.entity.Users;
import com.taskplanner.mapper.TaskMapper;
import com.taskplanner.repository.ProjectRepository;
import com.taskplanner.repository.TaskRepository;
import com.taskplanner.repository.UserRepository;
import com.taskplanner.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           ProjectRepository projectRepository,
                           UserRepository userRepository,
                           TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {
        Project project = projectRepository.findById(requestDTO.getProjectId())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Users assignee = userRepository.findById(requestDTO.getAssigneeId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskMapper.toEntity(requestDTO, project, assignee);
        return taskMapper.toDto(taskRepository.save(task));
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }
}