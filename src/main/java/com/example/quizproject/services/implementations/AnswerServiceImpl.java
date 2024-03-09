package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.repositories.AnswerRepository;
import com.example.quizproject.models.inputs.AnswerInput;
import com.example.quizproject.models.outputs.AnswerOutput;
import com.example.quizproject.services.services.AnswerService;
import org.springframework.core.convert.ConversionService;

import java.util.List;
import java.util.Optional;

public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final ConversionService conversionService;

    public AnswerServiceImpl(AnswerRepository answerRepository, ConversionService answerService) {
        this.answerRepository = answerRepository;
        this.conversionService = answerService;
    }

    @Override
    public AnswerOutput createAnswer(AnswerInput input) {
        Answer answer = conversionService.convert(input, Answer.class);
        Answer savedAnswer = answerRepository.save(answer);
        return conversionService.convert(savedAnswer, AnswerOutput.class);
    }

    @Override
    public AnswerOutput getAnswerById(String id) {
        Optional<Answer> optional = answerRepository.findById(id);
        AnswerOutput answerOutput = conversionService.convert(optional.get(), AnswerOutput.class);
        return answerOutput;
    }

    @Override
    public AnswerOutput updateAnswer(String id) {
       //TODO
        return null;
    }

    @Override
    public List<AnswerOutput> getAllAnswersForQuestion(String QuestionId) {
        //TODO
        return null;
    }
}
