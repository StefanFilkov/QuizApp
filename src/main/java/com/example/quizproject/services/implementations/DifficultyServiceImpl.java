package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.repositories.DifficultyRepository;
import com.example.quizproject.models.inputs.DifficultyInput;
import com.example.quizproject.models.outputs.DifficultyOutput;
import com.example.quizproject.services.services.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DifficultyServiceImpl implements DifficultyService {
    private final DifficultyRepository difficultyRepository;
    private final ConversionService conversionService;
    @Autowired
    public DifficultyServiceImpl(ConversionService conversionService, DifficultyRepository difficultyRepository) {
        this.conversionService = conversionService;
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public DifficultyOutput createDifficulty(DifficultyInput input) {
        Difficulty difficulty = conversionService.convert(input, Difficulty.class);
        Difficulty savedDifficulty = difficultyRepository.save(difficulty);
        return conversionService.convert(savedDifficulty, DifficultyOutput.class);
    }

    @Override
    public DifficultyOutput getDifficultyById(String id) {
        //TODO
        return null;
    }

}
