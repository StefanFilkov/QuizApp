package com.example.quizproject.converters.quizes;

import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.models.inputs.QuizInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuizInputToQuiz implements Converter<QuizInput, Quiz> {

    @Override
    public Quiz convert(QuizInput source) {
        return Quiz
                .builder()
                .user(source.getUser())
                .questions(source.getQuestions())
                .build();
    }
}
