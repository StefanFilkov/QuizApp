package com.example.quizproject.converters.basic.categories;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.models.inputs.CategoryInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryInputToCategory implements Converter<CategoryInput, Category> {
    @Override
    public Category convert(CategoryInput source) {
        return Category
                .builder()
                .categoryName(source.getCategoryName())
                .build();
    }
}
