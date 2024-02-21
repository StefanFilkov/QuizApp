package com.example.quizproject.service;
import com.example.quizproject.Question;
import com.example.quizproject.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService {

   // @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){


        return questionDao.findAll();
    }
}
