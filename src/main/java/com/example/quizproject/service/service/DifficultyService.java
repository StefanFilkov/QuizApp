package com.example.quizproject.service.service;

import com.example.quizproject.models.input.DifficultyInput;
import com.example.quizproject.models.output.DifficultyOutput;

import java.util.List;

public interface DifficultyService {
    DifficultyOutput createDifficulty(DifficultyInput input);
    DifficultyOutput getDifficultyById(String id);
    List<DifficultyOutput> getAllDifficulties();
}
