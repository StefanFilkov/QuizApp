package com.example.quizproject.db.repositories;

import com.example.quizproject.db.entities.Answer;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,String> {
}
