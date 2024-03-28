package com.example.quizproject.controllers;

import com.example.quizproject.db.models.advancedInputs.CompleteQuizInput;
import com.example.quizproject.db.models.inputs.QuizInput;
import com.example.quizproject.db.models.outputs.QuizOutput;
import com.example.quizproject.services.services.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizService quizService) {this.quizService = quizService;}

    @PostMapping
    public ResponseEntity<QuizOutput> createQuiz(@RequestBody QuizInput input){
        return new ResponseEntity<>(quizService.createQuiz(input), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<QuizOutput> getQuiz(@RequestParam String id){
        return new ResponseEntity<>(quizService.getQuizById(id), HttpStatus.OK);
    }

    @PostMapping("/newQuiz")
    public ResponseEntity<QuizOutput> createCompleteQuiz(@RequestBody CompleteQuizInput input){
        return new ResponseEntity<>(quizService.createCompleteQuiz(input), HttpStatus.CREATED);
    }
}
