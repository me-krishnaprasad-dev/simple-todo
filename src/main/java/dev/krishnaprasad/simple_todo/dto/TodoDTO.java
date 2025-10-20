package dev.krishnaprasad.simple_todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO representing a ToDo item")
public class TodoDTO {

    @Schema(description = "Unique identifier of the ToDo", example = "1")
    private Long id;

    @Schema(description = "Title of the ToDo", example = "Finish Spring Boot Project", required = true)
    private String title;

    @Schema(description = "Description of the ToDo", example = "Complete by Friday")
    private String description;

    @Schema(description = "Completion status", example = "false")
    private boolean completed;
}

