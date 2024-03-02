package com.example.quizproject.service.service;

import com.example.quizproject.models.input.CategoryInput;
import com.example.quizproject.models.output.CategoryOutput;

public interface CategoryService  {
    CategoryOutput createCategory(CategoryInput input);
    CategoryOutput getCategoryById(String id);
    CategoryOutput updateCategory(CategoryInput input);

}
