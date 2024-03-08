package com.example.quizproject.models.inputs;

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
    private Answer answer;
    private Difficulty difficulty;
    private Category category;
    private String questionBody;
    private Quiz quiz;
    private List<Answer> answers;
}
