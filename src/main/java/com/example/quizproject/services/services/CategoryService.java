package com.example.quizproject.services.services;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.models.inputs.CategoryInput;
import com.example.quizproject.db.models.outputs.CategoryOutput;

import java.util.List;
import java.util.Optional;

public interface CategoryService  {
    CategoryOutput createCategory(CategoryInput input);
    CategoryOutput getCategoryById(String id);
    CategoryOutput updateCategory(CategoryInput input);
    List<CategoryOutput> listAllCategories();


}
