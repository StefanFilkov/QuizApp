package com.example.quizproject.services.services;

import com.example.quizproject.models.inputs.CategoryInput;
import com.example.quizproject.models.outputs.CategoryOutput;

public interface CategoryService  {
    CategoryOutput createCategory(CategoryInput input);
    CategoryOutput getCategoryById(String id);
    CategoryOutput updateCategory(CategoryInput input);

}
