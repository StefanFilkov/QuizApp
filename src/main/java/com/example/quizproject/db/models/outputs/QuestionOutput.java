package com.example.quizproject.db.models.outputs;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.entities.Quiz;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionOutput {
    private String id;
    private String questionBody;
    private Difficulty difficulty;
    private Category category;
    private Quiz quiz;
    private List<Answer> answers;
}
