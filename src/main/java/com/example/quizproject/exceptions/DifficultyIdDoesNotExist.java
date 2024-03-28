package com.example.quizproject.exceptions;

public class DifficultyIdDoesNotExist extends RuntimeException{
    public DifficultyIdDoesNotExist(String id){
        super(String.format("Difficulty with id %s does not exist", id));
    }
}
