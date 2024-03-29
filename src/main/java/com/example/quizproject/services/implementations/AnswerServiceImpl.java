package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.repositories.AnswerRepository;
import com.example.quizproject.db.repositories.QuestionRepository;
import com.example.quizproject.db.models.inputs.AnswerInput;
import com.example.quizproject.db.models.outputs.AnswerOutput;
import com.example.quizproject.services.services.AnswerService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final ConversionService conversionService;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, ConversionService conversionService, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.conversionService = conversionService;
        this.questionRepository = questionRepository;
    }


    @Override
    public AnswerOutput createAnswer(AnswerInput input) {
        Answer answer = conversionService.convert(input, Answer.class);
        setAnswerByQuestionId(answer, input.getQuestionId());
        Answer savedAnswer = answerRepository.save(answer);
        return conversionService.convert(savedAnswer, AnswerOutput.class);
    }

    @Override
    public AnswerOutput getAnswerById(String id) {
        //TODO Exception if id doesn't exist
        Optional<Answer> optional = answerRepository.findById(id);
        AnswerOutput answerOutput = conversionService.convert(optional.get(), AnswerOutput.class);
        return answerOutput;
    }



    @Override
    public void deleteAnswer(String id) {
        answerRepository.deleteById(id);
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

    @Override
    public List<AnswerOutput> createMultipleAnswers(List<String> listAnswerBodies, String questionId) {
        List<AnswerOutput> result = new ArrayList<>();
        for (String s : listAnswerBodies){
            AnswerInput answerInput = new AnswerInput(s,questionId);
            result.add(createAnswer(answerInput));
        }
        return result;
    }

    private void setAnswerByQuestionId(Answer source, String id){
        //TODO Exception if "id" is invalid
        source.setQuestion(questionRepository.findById(id).get());
    }
}
