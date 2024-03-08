package com.example.quizproject.services.services;

import com.example.quizproject.models.outputs.QuestionOutput;

public interface QuestionService {
    QuestionOutput getQuestionById(String id);

}
