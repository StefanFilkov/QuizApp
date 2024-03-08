package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.repositories.QuizRepository;
import com.example.quizproject.models.inputs.QuizInput;
import com.example.quizproject.models.outputs.QuizOutput;
import com.example.quizproject.services.services.QuizService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final ConversionService conversionService;

    public QuizServiceImpl(QuizRepository quizRepository, ConversionService conversionService) {
        this.quizRepository = quizRepository;
        this.conversionService = conversionService;
    }

    @Override
    public QuizOutput createQuiz(QuizInput input) {
        Quiz quiz = conversionService.convert(input, Quiz.class);
        Quiz savedQuiz = quizRepository.save(quiz);
        return conversionService.convert(savedQuiz, QuizOutput.class);
    }
}
