package com.example.quizproject.controllers;

import com.example.quizproject.db.models.inputs.QuestionInput;
import com.example.quizproject.db.models.outputs.QuestionOutput;
import com.example.quizproject.services.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
