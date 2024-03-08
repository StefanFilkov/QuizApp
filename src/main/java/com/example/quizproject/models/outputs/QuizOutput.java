package com.example.quizproject.models.outputs;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.entities.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizOutput {
    private String id;
    private User user;
    private List<Question> questions;
}
