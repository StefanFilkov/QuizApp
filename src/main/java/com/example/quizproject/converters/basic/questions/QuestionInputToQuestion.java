package com.example.quizproject.converters.basic.questions;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.models.inputs.QuestionInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionInputToQuestion implements Converter<QuestionInput, Question> {
    @Override
    public Question convert(QuestionInput source) {
        return Question.builder()
                .questionBody(source.getQuestionBody())
                .rightAnswer(source.getRightAnswer())
                .build();
    }
}
