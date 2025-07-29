package com.taskplanner.service;

import com.taskplanner.dto.TaskRequestDTO;
import com.taskplanner.dto.TaskResponseDTO;
import java.util.List;

public interface TaskService {
    TaskResponseDTO createTask(TaskRequestDTO requestDTO);
    List<TaskResponseDTO> getAllTasks();
}
