package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.CategoryInput;
import com.example.quizproject.models.outputs.CategoryOutput;
import com.example.quizproject.services.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<CategoryOutput>> listAllCategories(){
        return new ResponseEntity<>(categoryService.listAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/getbyid")
    public ResponseEntity<CategoryOutput> getCategoryById(String id){
        return new ResponseEntity<>(categoryService.getCategoryById(id),HttpStatus.OK);
    }
}
