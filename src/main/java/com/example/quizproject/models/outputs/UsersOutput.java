package com.example.quizproject.models.outputs;

import com.example.quizproject.db.entities.Permission;
import com.example.quizproject.db.entities.Quiz;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersOutput {
    private String id;
    private String username;
    private String email;
    private String password;
    private List<Permission> permissions;
    private List<Quiz> quizzes;
}
