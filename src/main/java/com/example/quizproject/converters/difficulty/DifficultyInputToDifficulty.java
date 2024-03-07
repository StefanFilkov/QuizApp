package com.example.quizproject.converters.difficulty;

import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.models.inputs.DifficultyInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DifficultyInputToDifficulty implements Converter<DifficultyInput, Difficulty> {
    @Override
    public Difficulty convert(DifficultyInput source) {
        return Difficulty
                .builder()
                .difficulty(source.getDifficulty())
                .build();
    }
}
