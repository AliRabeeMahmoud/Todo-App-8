package com.ali.java.todo.repository;


import com.ali.java.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
