package com.example.quizproject.models.output;

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
