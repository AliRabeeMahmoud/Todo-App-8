package com.ali.java.todo.service;

import com.ali.java.todo.dto.CreateTodoDto;
import com.ali.java.todo.model.Todo;

import java.util.List;

public interface TodoService {

    Todo save(CreateTodoDto todoDto);
    Todo update(CreateTodoDto todoDto);

    List<Todo> findAll();

    Todo findById(Long id);


    String  delete(Long id);

}
