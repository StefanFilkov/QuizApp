package com.example.quizproject.converters.advanced;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.models.advancedInputs.MultipleQuestionInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MultipleQuestionInputToQuestion implements Converter<MultipleQuestionInput, Question> {
    @Override
    public Question convert(MultipleQuestionInput source) {
        return Question
                .builder()
                //TODO rightAnswer fix
                .questionBody(source.getBody())
                .answers(source.getAnswers().stream().map( answer -> Answer.builder().answer(answer).build()).toList())
                .category(Category.builder().categoryName(source.getCategory()).build())
                .difficulty(Difficulty.builder().difficultyValue(source.getDifficulty()).build())
                .build();
    }
}
