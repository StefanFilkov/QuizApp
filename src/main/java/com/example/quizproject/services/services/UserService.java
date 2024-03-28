package com.example.quizproject.services.services;

import com.example.quizproject.db.models.inputs.UserInput;
import com.example.quizproject.db.models.outputs.UsersOutput;

public interface UserService {
    UsersOutput createUser(UserInput input);
    UsersOutput updateUser(String userId);
}
