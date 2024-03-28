package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.repositories.CategoryRepository;
import com.example.quizproject.db.models.inputs.CategoryInput;
import com.example.quizproject.db.models.outputs.CategoryOutput;
import com.example.quizproject.services.services.CategoryService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Category> optionalEntity =  categoryRepository.findById(id);
        CategoryOutput categoryOutput = conversionService.convert(optionalEntity.get(),CategoryOutput.class);
        return categoryOutput;

    }

    @Override
    public CategoryOutput updateCategory(CategoryInput input) {
        //TODO
        return null;
    }

    @Override
    public List<CategoryOutput> listAllCategories() {
        //TODO da razgledam
        List<CategoryOutput> result = new ArrayList<>();
        List<CategoryOutput> list = categoryRepository
                .findAll()
                .stream()
                .map(category -> conversionService.convert(category, CategoryOutput.class))
                .toList();

        //        for(Category c : list){
        //            result.add(conversionService.convert(c, CategoryOutput.class));
        //        }
        return list;
    }
}
