package com.example.quizproject.db.models.advancedInputs;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultipleQuestionInput {
    private String body;
    private String category; // check if such category exists if not add it
    private List<String> answers;
    private String difficulty;
    private String rightAnswer;
}
