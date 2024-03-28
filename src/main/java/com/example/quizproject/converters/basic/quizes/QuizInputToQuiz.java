package com.example.quizproject.converters.basic.quizes;

import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.models.inputs.QuizInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuizInputToQuiz implements Converter<QuizInput, Quiz> {

    @Override
    public Quiz convert(QuizInput source) {
        return Quiz
                .builder()
                .name(source.getName())
                .build();
    }
}
