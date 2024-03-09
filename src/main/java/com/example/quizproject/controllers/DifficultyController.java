package com.example.quizproject.controllers;

import com.example.quizproject.models.inputs.DifficultyInput;
import com.example.quizproject.models.outputs.DifficultyOutput;
import com.example.quizproject.services.services.DifficultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/getById")
    public ResponseEntity<DifficultyOutput> getDifficultyById(@RequestParam String id){
        return new ResponseEntity<>(difficultyService.getDifficultyById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DifficultyOutput>> getAllDifficulty(){
        return new ResponseEntity<>(difficultyService.getAllDifficulty(), HttpStatus.OK);
    }
}
