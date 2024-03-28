package com.example.quizproject.db.models.outputs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryOutput {
    private String id;
    private String categoryName;
}
