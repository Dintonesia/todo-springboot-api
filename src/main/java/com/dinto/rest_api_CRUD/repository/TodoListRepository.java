package com.dinto.rest_api_CRUD.repository;

import com.dinto.rest_api_CRUD.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findByCompleted(Boolean completed);
    List<TodoList> findByStatus(TodoList.Status status);
}
