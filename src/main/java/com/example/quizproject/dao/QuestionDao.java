package com.example.quizproject.dao;

import com.example.quizproject.Question;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionDao extends JpaRepository<Question,Integer> {

}
