package com.example.quizproject.db.repositories;

import com.example.quizproject.db.entities.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, String> {
    Optional<Difficulty> findByDifficultyValue(String difficultyValue);

}
