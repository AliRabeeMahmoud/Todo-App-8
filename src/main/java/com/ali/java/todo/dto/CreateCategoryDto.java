package com.ali.java.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateCategoryDto {

    private String name;

    private String description;

    private Long userId;
}
