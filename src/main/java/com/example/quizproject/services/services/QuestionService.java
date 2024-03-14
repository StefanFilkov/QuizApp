package com.example.quizproject.services.services;

import com.example.quizproject.models.inputs.QuestionInput;
import com.example.quizproject.models.outputs.QuestionOutput;

import java.util.List;

public interface QuestionService {
    QuestionOutput getQuestionById(String id);
    QuestionOutput updateQuestion(String questionId);
    QuestionOutput createQuestion(QuestionInput input);
    List<QuestionOutput> getQuestionsFromQuizById(String quizId);

}
