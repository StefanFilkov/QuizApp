package com.example.quizproject.services.services;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.models.advancedInputs.CompleteQuizInput;
import com.example.quizproject.db.models.inputs.QuizInput;
import com.example.quizproject.db.models.outputs.QuizOutput;

import java.util.List;


public interface QuizService {
    QuizOutput createQuiz(QuizInput input);
    QuizOutput getQuizById(String id);
    QuizOutput createCompleteQuiz(CompleteQuizInput input);
    List<QuizOutput> listAllQuiz();
    List<Question> listAllQuestions();
}
