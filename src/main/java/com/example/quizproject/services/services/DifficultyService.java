package com.example.quizproject.services.services;

import com.example.quizproject.db.models.inputs.DifficultyInput;
import com.example.quizproject.db.models.outputs.DifficultyOutput;

import java.util.List;

public interface DifficultyService {
    DifficultyOutput createDifficulty(DifficultyInput input);
    DifficultyOutput getDifficultyById(String id);
    List<DifficultyOutput> getAllDifficulty();

}
