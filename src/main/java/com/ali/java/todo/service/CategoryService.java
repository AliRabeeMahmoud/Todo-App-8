package com.ali.java.todo.service;

import com.ali.java.todo.dto.CreateCategoryDto;
import com.ali.java.todo.model.Category;

import java.util.List;

public interface CategoryService {

    Category save(CreateCategoryDto category);
    Category update(CreateCategoryDto category);

    List<Category> findAll();

    Category findById(Long id);


    String delete(Long id);


}
