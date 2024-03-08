package com.example.quizproject.services.services;

import com.example.quizproject.models.inputs.QuizInput;
import com.example.quizproject.models.outputs.QuizOutput;


public interface QuizService {
    QuizOutput createQuiz(QuizInput input);
}
