package com.dinto.rest_api_CRUD.controller;


import com.dinto.rest_api_CRUD.dto.TodoListDTO;
import com.dinto.rest_api_CRUD.dto.TodoListRequest;
import com.dinto.rest_api_CRUD.model.TodoList;
import com.dinto.rest_api_CRUD.service.TodoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoListController {
    private final TodoListService service;

    @GetMapping
    public ResponseEntity<List<TodoListDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(params = "completed")
    public ResponseEntity<List<TodoListDTO>>getByCompleted(@RequestParam Boolean completed){
        return ResponseEntity.ok(service.getByCompleted(completed));
    }

    @GetMapping(params = "status")
    public ResponseEntity<List<TodoListDTO>> getByStatus(@RequestParam TodoList.Status status){
        return ResponseEntity.ok(service.getByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoListDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<TodoListDTO> create(@Valid @RequestBody TodoListRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoListDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody TodoListRequest request){
        return ResponseEntity.ok(service.update(id, request));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<TodoListDTO> markCompleted(@PathVariable Long id){
        return ResponseEntity.ok(service.markCompleted(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
