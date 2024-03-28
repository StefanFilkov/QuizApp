package com.example.quizproject.converters.basic.difficulties;

import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.models.inputs.DifficultyInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DifficultyInputToDifficulty implements Converter<DifficultyInput, Difficulty> {
    @Override
    public Difficulty convert(DifficultyInput source) {
        return Difficulty
                .builder()
                .difficultyValue(source.getDifficulty())
                .build();
    }
}
