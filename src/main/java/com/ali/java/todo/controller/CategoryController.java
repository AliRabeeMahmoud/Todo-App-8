package com.ali.java.todo.controller;

import com.ali.java.todo.dto.CreateCategoryDto;
import com.ali.java.todo.exception.NotFoundException;
import com.ali.java.todo.model.Category;
import com.ali.java.todo.service.CategoryService;
import com.ali.java.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController  {


    private final TodoService todoService;


    private final CategoryService categoryService;


    @PostMapping
    public Category createCategory(@RequestBody CreateCategoryDto category) {
        return categoryService.save(category);
    }


    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody CreateCategoryDto category) {
        return categoryService.update(category);
    }


    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }




    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) throws NotFoundException {
        return categoryService.findById(id);
    }


    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoryService.delete(id);

    }



}
