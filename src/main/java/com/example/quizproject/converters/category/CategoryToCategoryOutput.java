package com.example.quizproject.converters.category;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.models.outputs.CategoryOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryOutput implements Converter<Category, CategoryOutput> {
    @Override
    public CategoryOutput convert(Category source) {
        return CategoryOutput
                .builder()
                .id(source.getId())
                .categoryName(source.getCategoryName())
                .build();
    }
}
