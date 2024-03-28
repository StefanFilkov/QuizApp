package com.example.quizproject.db.models.inputs;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryInput {
    private String categoryName;
}
