package com.example.quizproject.services.services;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.models.inputs.QuizInput;
import com.example.quizproject.models.outputs.QuizOutput;

import java.util.List;


public interface QuizService {
    QuizOutput createQuiz(QuizInput input);
    QuizOutput getQuizById(String id);
    List<QuizOutput> listAllQuiz();
    List<Question> listAllQuestions();
}
