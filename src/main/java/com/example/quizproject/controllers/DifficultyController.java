package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.DifficultyInput;
import com.example.quizproject.models.outputs.DifficultyOutput;
import com.example.quizproject.services.services.DifficultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/difficulty")
public class DifficultyController {
    private final DifficultyService difficultyService;

    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @PostMapping
    public ResponseEntity<DifficultyOutput> createDifficulty(@RequestBody DifficultyInput input) {
        return new ResponseEntity<>(difficultyService.createDifficulty(input), HttpStatus.CREATED);
    }
}
