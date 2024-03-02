package com.example.quizproject.service.implementation;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.repositories.CategoryRepository;
import com.example.quizproject.models.input.CategoryInput;
import com.example.quizproject.models.output.CategoryOutput;
import com.example.quizproject.service.service.CategoryService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ConversionService conversionService) {
        this.categoryRepository = categoryRepository;
        this.conversionService = conversionService;
    }

    @Override
    public CategoryOutput createCategory(CategoryInput input) {
        Category category = conversionService.convert(input, Category.class);
        Category savedCategory = categoryRepository.save(category);
        CategoryOutput result = conversionService.convert(savedCategory, CategoryOutput.class);
        return result;

    }

    @Override
    public CategoryOutput getCategoryById(String id) {
        return null;
    }

    @Override
    public CategoryOutput updateCategory(CategoryInput input) {
        return null;
    }
}
