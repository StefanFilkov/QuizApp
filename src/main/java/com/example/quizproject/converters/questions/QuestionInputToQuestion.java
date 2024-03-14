package com.example.quizproject.converters.questions;

import com.example.quizproject.converters.answers.AnswerInputToAnswer;
import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.repositories.*;
import com.example.quizproject.models.inputs.QuestionInput;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionInputToQuestion implements Converter<QuestionInput, Question> {
    @Override
    public Question convert(QuestionInput source) {
        return Question.builder()
                .questionBody(source.getQuestionBody())
                .rightAnswerId(source.getRightAnswerId())
                .build();
    }
}
