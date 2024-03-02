package com.example.quizproject.controller;

import com.example.quizproject.models.input.CategoryInput;
import com.example.quizproject.models.output.CategoryOutput;
import com.example.quizproject.service.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryOutput> createCategory(@RequestBody CategoryInput input) {
        return new ResponseEntity<>(categoryService.createCategory(input), HttpStatus.CREATED);

    }
}
