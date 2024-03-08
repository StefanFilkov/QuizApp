package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.QuizInput;
import com.example.quizproject.models.outputs.QuizOutput;
import com.example.quizproject.services.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizService quizService) {this.quizService = quizService;}

    @PostMapping
    public ResponseEntity<QuizOutput> createQuiz(@RequestBody QuizInput input){
        return new ResponseEntity<>(quizService.createQuiz(input), HttpStatus.CREATED);
    }
}
