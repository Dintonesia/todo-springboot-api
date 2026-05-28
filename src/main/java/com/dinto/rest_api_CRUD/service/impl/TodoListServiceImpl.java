package com.dinto.rest_api_CRUD.service.impl;

import com.dinto.rest_api_CRUD.dto.TodoListDTO;
import com.dinto.rest_api_CRUD.dto.TodoListRequest;
import com.dinto.rest_api_CRUD.mapper.TodoListMapper;
import com.dinto.rest_api_CRUD.model.TodoList;
import com.dinto.rest_api_CRUD.repository.TodoListRepository;
import com.dinto.rest_api_CRUD.service.TodoListService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository repository;
    private final TodoListMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<TodoListDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoListDTO> getByCompleted(Boolean completed){
        return repository.findByCompleted(completed)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoListDTO> getByStatus(TodoList.Status status){
        return repository.findByStatus(status)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TodoListDTO getById(Long id){
        TodoList todo = findOrThrow(id);
        return mapper.toDTO(todo);
    }

    @Override
    public TodoListDTO create(TodoListRequest request) {
        TodoList todo = mapper.toEntity(request);
        return mapper.toDTO(repository.save(todo));
    }

    @Override
    public TodoListDTO update(Long id, TodoListRequest request){
        TodoList todo = findOrThrow(id);
        mapper.updateEntity(todo, request);
        return mapper.toDTO(repository.save(todo));
    }

    @Override
    public TodoListDTO markCompleted(Long id){
        TodoList todo = findOrThrow(id);
        todo.setCompleted(true);
        todo.setStatus(TodoList.Status.DONE);
        return mapper.toDTO(repository.save(todo));
    }

    @Override
    public void delete(Long id){
        findOrThrow(id);
        repository.deleteById(id);
    }

    private TodoList findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TodoList not found with id: " + id));
    }
}
