package com.example.quizproject.converters.questions;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.models.inputs.QuestionInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class QuestionInputToQuestion implements Converter<QuestionInput, Question> {
    @Override
    public Question convert(QuestionInput source) {
        return Question
                .builder()
                .questionBody(source.getQuestionBody())
                .answers(source.getAnswers())
                .category(source.getCategory())
                .quiz(source.getQuiz())
                .difficulty(source.getDifficulty())
                .build();
    }
}
