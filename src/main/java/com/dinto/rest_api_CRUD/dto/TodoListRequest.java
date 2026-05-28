package com.dinto.rest_api_CRUD.dto;


import com.dinto.rest_api_CRUD.model.TodoList;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListRequest {
    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private TodoList.Status status;
    private Boolean completed;
    private LocalDateTime dueDate;
}
