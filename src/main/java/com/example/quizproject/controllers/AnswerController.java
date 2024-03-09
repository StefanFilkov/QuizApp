package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.AnswerInput;
import com.example.quizproject.models.outputs.AnswerOutput;
import com.example.quizproject.services.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<AnswerOutput> createAnswer(@RequestBody AnswerInput input){
        return new ResponseEntity<>(answerService.createAnswer(input), HttpStatus.CREATED);
    }

    @PostMapping("/getById")
    public ResponseEntity<AnswerOutput> getAnswerById(@RequestParam String id){
        return new ResponseEntity<>(answerService.getAnswerById(id), HttpStatus.OK);
    }
}
