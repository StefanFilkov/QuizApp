package com.example.quizproject.converters.questions;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.models.outputs.QuestionOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionToQuestionOutput implements Converter<Question, QuestionOutput> {
    @Override
    public QuestionOutput convert(Question source) {
        return QuestionOutput
                .builder()
                .id(source.getId())
                .questionBody(source.getQuestionBody())
                .difficulty(source.getDifficulty())
                .category(source.getCategory())
                .quiz(source.getQuiz())
                .answers(source.getAnswers())
                .build();
    }

}
