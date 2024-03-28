package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.repositories.DifficultyRepository;
import com.example.quizproject.db.models.inputs.DifficultyInput;
import com.example.quizproject.db.models.outputs.DifficultyOutput;
import com.example.quizproject.services.services.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Difficulty> optionalEntity = difficultyRepository.findById(id);
        DifficultyOutput difficultyOutput = conversionService.convert(optionalEntity.get(), DifficultyOutput.class);
        return difficultyOutput;
    }

    @Override
    public List<DifficultyOutput> getAllDifficulty() {
        List<DifficultyOutput> result = new ArrayList<>();
        List<Difficulty> list = difficultyRepository.findAll();
        for(Difficulty d : list){
            result.add(conversionService.convert(d,DifficultyOutput.class));
        }
        return result;
    }

}
