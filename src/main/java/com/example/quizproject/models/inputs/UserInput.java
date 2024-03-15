package com.example.quizproject.models.inputs;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput {
    private String username;
    private String email;
    private String password;
    private List<String> permissionIds;
    private List<String> quizIds;
}
