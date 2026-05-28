package com.dinto.rest_api_CRUD.dto;

import com.dinto.rest_api_CRUD.model.TodoList;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoListDTO {
    private Long id;
    private String title;
    private String description;
    private TodoList.Status status;
    private Boolean completed;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
