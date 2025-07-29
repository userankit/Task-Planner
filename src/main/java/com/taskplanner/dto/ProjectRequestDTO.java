package com.taskplanner.dto;

import lombok.Data;

@Data
public class ProjectRequestDTO {
    private String name;
    private String description;
    private Long createdById;// userId who is creating the project
}