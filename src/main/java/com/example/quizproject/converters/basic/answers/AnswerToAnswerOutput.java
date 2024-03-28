package com.example.quizproject.converters.basic.answers;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.models.outputs.AnswerOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnswerToAnswerOutput implements Converter<Answer, AnswerOutput> {
    @Override
    public AnswerOutput convert(Answer source) {
        return AnswerOutput.builder()
                .id(source.getId())
                .answer(source.getAnswer())
                .question(source.getQuestion())
                .build();
    }
}
