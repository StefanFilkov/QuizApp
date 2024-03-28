package com.example.quizproject.exceptions;

public class AnswerIdDoesNotExist extends RuntimeException{
    public AnswerIdDoesNotExist(String id){
            super(String.format("Answer with id: %s does not exist", id));
    }
}
