package com.example.quizproject.services.services;

import com.example.quizproject.db.models.inputs.AnswerInput;
import com.example.quizproject.db.models.outputs.AnswerOutput;

import java.util.List;

public interface AnswerService {
    AnswerOutput createAnswer(AnswerInput input);
    AnswerOutput getAnswerById(String id);
    void deleteAnswer(String id);
    AnswerOutput updateAnswer(String id);
    List<AnswerOutput> getAllAnswersForQuestion(String QuestionId);
    List<AnswerOutput> createMultipleAnswers(List<String> list, String questionId);
}
