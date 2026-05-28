package com.dinto.rest_api_CRUD.mapper;


import com.dinto.rest_api_CRUD.dto.TodoListDTO;
import com.dinto.rest_api_CRUD.dto.TodoListRequest;
import com.dinto.rest_api_CRUD.model.TodoList;
import org.springframework.stereotype.Component;

@Component
public class TodoListMapper {
    public TodoListDTO toDTO(TodoList entity){
        return TodoListDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .completed(entity.getCompleted())
                .dueDate(entity.getDueDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public TodoList toEntity(TodoListRequest request){
        return TodoList.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .status(request.getStatus() != null ? request.getStatus() : TodoList.Status.PENDING)
                .completed(request.getCompleted() != null ? request.getCompleted() : false)
                .dueDate(request.getDueDate())
                .build();
    }
    public void updateEntity(TodoList entity, TodoListRequest request){
        if (request.getTitle() != null) entity.setTitle(request.getTitle());
        if (request.getDescription() != null) entity.setDescription(request.getDescription());
        if (request.getStatus() != null) entity.setStatus(request.getStatus());
        if (request.getCompleted() != null) entity.setCompleted(request.getCompleted());
        if (request.getDueDate() != null) entity.setDueDate(request.getDueDate());
    }

}
