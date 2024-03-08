package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.repositories.CategoryRepository;
import com.example.quizproject.models.inputs.CategoryInput;
import com.example.quizproject.models.outputs.CategoryOutput;
import com.example.quizproject.services.services.CategoryService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return conversionService.convert(savedCategory, CategoryOutput.class);

    }

    @Override
    public CategoryOutput getCategoryById(String id) {
        //TODO
        return null;
    }

    @Override
    public CategoryOutput updateCategory(CategoryInput input) {
        //TODO
        return null;
    }

    @Override
    public List<CategoryOutput> listAllCategories() {
        List<CategoryOutput> result= new ArrayList<>();
        List<Category> list = categoryRepository.findAll();
        for(Category c : list){
            result.add(conversionService.convert(c, CategoryOutput.class));

        }
        return result;
    }
}
