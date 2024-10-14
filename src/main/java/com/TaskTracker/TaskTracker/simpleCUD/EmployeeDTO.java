package com.TaskTracker.TaskTracker.simpleCUD;

import com.TaskTracker.TaskTracker.core.StatusEmployee;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("description")
    private String description;
    @Enumerated
    private StatusEmployee status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
