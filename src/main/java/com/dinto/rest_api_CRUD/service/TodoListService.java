package com.dinto.rest_api_CRUD.service;

import com.dinto.rest_api_CRUD.dto.TodoListDTO;
import com.dinto.rest_api_CRUD.dto.TodoListRequest;
import com.dinto.rest_api_CRUD.model.TodoList;

import java.util.List;

public interface TodoListService {
    List<TodoListDTO> getAll();
    List<TodoListDTO> getByCompleted(Boolean completed);
    List<TodoListDTO> getByStatus(TodoList.Status status);
    TodoListDTO getById(Long id);
    TodoListDTO create(TodoListRequest request);
    TodoListDTO update(Long id, TodoListRequest request);
    TodoListDTO markCompleted(Long id);
    void delete(Long id);
}
