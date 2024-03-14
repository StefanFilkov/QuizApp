package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.QuestionInput;
import com.example.quizproject.models.outputs.QuestionOutput;
import com.example.quizproject.services.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionOutput> createQuestion(@RequestBody QuestionInput input){
        return new ResponseEntity<>(questionService.createQuestion(input), HttpStatus.CREATED);
    }



}
