package com.example.quizproject.exceptions;

public class CategoryIdDoesNotExist extends RuntimeException{
    public CategoryIdDoesNotExist(String id){
            super(String.format("Category with id: %s does not exist", id));
    }
}
