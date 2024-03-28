package com.example.quizproject.services.services;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.models.inputs.QuestionInput;
import com.example.quizproject.db.models.outputs.QuestionOutput;

import java.util.List;

public interface QuestionService {
    QuestionOutput getQuestionById(String id);
    QuestionOutput updateQuestion(String questionId);
    QuestionOutput createQuestion(QuestionInput input);
    List<QuestionOutput> getQuestionsFromQuizById(String quizId);
    List<Question> createMultipleQuestions();

}
