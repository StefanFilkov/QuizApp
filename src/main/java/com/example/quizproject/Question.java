package com.example.quizproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.ArrayList;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int difficulty;
    private int answer;
    private String questionBody;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String category;

}
