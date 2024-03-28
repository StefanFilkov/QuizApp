package com.example.quizproject.exceptions;

public class QuizIdDoesNotExist extends RuntimeException{
    public QuizIdDoesNotExist(String id){
        super(String.format("Quiz with id %s does not exist", id));
    }
}
