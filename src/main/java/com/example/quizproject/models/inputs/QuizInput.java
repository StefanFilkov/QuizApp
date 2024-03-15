package com.example.quizproject.models.inputs;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.entities.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizInput {
    private String userId;
    private String name;
    private List<String> questionIds;
}
