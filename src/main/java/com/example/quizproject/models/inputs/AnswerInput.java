package com.example.quizproject.models.inputs;

import com.example.quizproject.db.entities.Question;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerInput {
    private String answer;
    private Boolean isRight;
    private Question question;
}
