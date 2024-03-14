package com.example.quizproject.converters.answers;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.repositories.AnswerRepository;
import com.example.quizproject.models.inputs.AnswerInput;
import com.example.quizproject.models.outputs.CategoryOutput;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnswerInputToAnswer implements Converter<AnswerInput, Answer> {

    @Override
    public Answer convert(AnswerInput source) {
        return Answer.builder()
                .answer(source.getAnswer())
                .build();
    }
}
