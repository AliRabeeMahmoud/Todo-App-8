package com.ali.java.todo.service.impl;

import com.ali.java.todo.dto.CreateTodoDto;
import com.ali.java.todo.exception.NotFoundException;
import com.ali.java.todo.model.Category;
import com.ali.java.todo.model.Todo;
import com.ali.java.todo.model.User;
import com.ali.java.todo.repository.CategoryRepository;
import com.ali.java.todo.repository.TodoRepository;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;


    private final CategoryRepository categoryRepository;

    @Override
    public Todo save(CreateTodoDto todo) {

        return todoRepository.save(toTodo(todo));
    }

    @Override
    public Todo update(CreateTodoDto todoDto) {
        Todo todo= toTodo(todoDto);
        Todo oldTodo = todoRepository.findById(todo.getId()).orElse(null);
        oldTodo.setCategory(todo.getCategory());
        oldTodo.setTitle(todo.getTitle());
        oldTodo.setDescription(todo.getDescription());
        oldTodo.setDone(todo.getDone());
        oldTodo.setFavorite(todo.getFavorite());
        return oldTodo;

    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(Long id) throws NotFoundException {

        Todo todo= todoRepository.findById(id).orElse(null);

        if(todo!=null){
            return todo ;
        }

        throw new NotFoundException("the requested user does not exist");

    }


    @Override
    public String delete(Long id) {

        todoRepository.deleteById(id);
        return "Deleted";
    }

    private Todo toTodo(CreateTodoDto createDto){

       // return mapper.map(createUserDto, Todo.class);
        User user= new User();
        user.setId(createDto.getUserId());
        Category category = new Category();
        category.setId(createDto.getCategoryId());
        Todo todo = new Todo();
        todo.setUser(user);
        todo.setDone(createDto.getDone());
        todo.setTitle(createDto.getTitle());
        todo.setFavorite(createDto.getFavorite());
        todo.setCategory(category);
        todo.setDescription(createDto.getDescription());
        return todo;
    }
}
