package com.example.quizproject.db.models.inputs;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.entities.Quiz;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionInput {
    private String QuestionBody;
    private String difficultyId;
    private String categoryId;
    //private List<String> answersIds;
    private Answer rightAnswer;
    private String quizId;
}
