package com.example.quizproject.models.outputs;

import com.example.quizproject.db.entities.Question;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerOutput {
    private String id;
    private String answer;
    private Boolean isRight;
    private Question question;
}
