package com.ali.java.todo.controller;

import com.ali.java.todo.dto.CreateTodoDto;
import com.ali.java.todo.exception.NotFoundException;
import com.ali.java.todo.model.Todo;
import com.ali.java.todo.service.CategoryService;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController  {


    private final TodoService todoService;


    private final CategoryService categoryService;


    @PostMapping
    public Todo createTodo(@RequestBody CreateTodoDto user) {
        return todoService.save(user);
    }


    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody CreateTodoDto todo) {
        return todoService.update(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

  @GetMapping("/{id}")
    public Todo getTodo(@PathVariable Long todoId) throws NotFoundException {
        return  todoService.findById(todoId);
    }


    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {

        return todoService.delete(id);
    }
}
