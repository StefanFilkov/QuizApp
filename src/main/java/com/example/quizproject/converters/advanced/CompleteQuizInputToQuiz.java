package com.example.quizproject.converters.advanced;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.entities.User;
import com.example.quizproject.db.models.advancedInputs.CompleteQuizInput;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompleteQuizInputToQuiz implements Converter<CompleteQuizInput, Quiz> {
    private final ConversionService conversionService;
    @Lazy
    public CompleteQuizInputToQuiz(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public Quiz convert(CompleteQuizInput source) {
        return Quiz
                .builder()
                .name(source.getQuizName())
                .questions(source
                        .getQuestions()
                        .stream()
                        .map(questionInput -> conversionService.convert(questionInput, Question.class))
                        .toList())
                .user(User.builder().build())   //TODO
                .build();
    }
}
