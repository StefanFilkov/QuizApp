package com.example.quizproject.converters.basic.difficulties;

import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.models.outputs.DifficultyOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DifficultyToDifficultyOutput implements Converter<Difficulty, DifficultyOutput> {

    @Override
    public DifficultyOutput convert(Difficulty source) {
        return DifficultyOutput
                .builder()
                .id(source.getId())
                .difficulty(source.getDifficultyValue())
                .build();
    }
}
