package com.example.quizproject.db.models.advancedInputs;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteQuizInput {
    private String quizName;
    private List<MultipleQuestionInput> questions;
    //TODO add users
//    List<List<String>> answerBodies;
//    List<String> categoryIds;
//    List<String> difficultyIds;
//    List <String> questionBodies;
}
