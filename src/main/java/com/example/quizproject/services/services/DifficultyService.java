package com.example.quizproject.services.services;

import com.example.quizproject.models.inputs.DifficultyInput;
import com.example.quizproject.models.outputs.DifficultyOutput;

import java.util.List;

public interface DifficultyService {
    DifficultyOutput createDifficulty(DifficultyInput input);
    DifficultyOutput getDifficultyById(String id);
    List<DifficultyOutput> getAllDifficulty();

}
