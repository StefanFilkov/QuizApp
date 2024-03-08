package com.example.quizproject.converters.quizes;

import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.models.outputs.QuizOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuizToQuizOutput implements Converter<Quiz, QuizOutput> {

    @Override
    public QuizOutput convert(Quiz source) {
        return QuizOutput
                .builder()
                .id(source.getId())
                .user(source.getUser())
                .questions(source.getQuestions())
                .build();
    }
}
