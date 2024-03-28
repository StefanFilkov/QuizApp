package com.example.quizproject.exceptions;

public class InputCanNotBeNull extends RuntimeException{
    public InputCanNotBeNull(){
        super(String.format("Input can not be null"));
    }

}
