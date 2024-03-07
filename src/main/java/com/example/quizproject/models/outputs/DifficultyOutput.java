package com.example.quizproject.models.outputs;

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
