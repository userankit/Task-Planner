package com.taskplanner.dto;

import lombok.Data;

@Data
public class ProjectResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String createdByName;
    private String createdByEmail;
    private String createdAt;
}