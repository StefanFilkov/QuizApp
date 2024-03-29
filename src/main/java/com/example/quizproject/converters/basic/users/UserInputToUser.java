package com.example.quizproject.converters.basic.users;

import com.example.quizproject.db.entities.User;
import com.example.quizproject.db.models.inputs.UserInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserInputToUser implements Converter<UserInput, User> {
    @Override
    public User convert(UserInput source){
        return User.builder()
                .username(source.getUsername())
                .email(source.getEmail())
                .password(source.getPassword())
                .build();
    }
}
