package com.example.quizproject.services.services;

import com.example.quizproject.models.inputs.AnswerInput;
import com.example.quizproject.models.outputs.AnswerOutput;

import java.util.List;

public interface AnswerService {
    AnswerOutput createAnswer(AnswerInput input);
    AnswerOutput getAnswerById(String id);
    AnswerOutput updateAnswer(String id);
    List<AnswerOutput> getAllAnswersForQuestion(String QuestionId);
}
