package com.example.quizproject.db.models.outputs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DifficultyOutput {
    private String id;
    private String difficulty;
}
