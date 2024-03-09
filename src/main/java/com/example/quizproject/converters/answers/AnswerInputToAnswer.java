package com.example.quizproject.converters.answers;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.models.inputs.AnswerInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnswerInputToAnswer implements Converter<AnswerInput, Answer> {
    @Override
    public Answer convert(AnswerInput source) {
        return Answer.builder()
                .answer(source.getAnswer())
                .isRight(source.getIsRight())
                .question(source.getQuestion())
                .build();
    }
}
