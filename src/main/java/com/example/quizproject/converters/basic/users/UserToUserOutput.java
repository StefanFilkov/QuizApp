package com.example.quizproject.converters.basic.users;

import com.example.quizproject.db.entities.User;
import com.example.quizproject.db.models.outputs.UsersOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserOutput implements Converter<User, UsersOutput>{
    @Override
    public UsersOutput convert(User source){

        return UsersOutput.builder()
                .id(source.getId())
                .username(source.getUsername())
                .email(source.getEmail())
                .password(source.getPassword())
                .quizzes(source.getQuizzes())
                .permissions(source.getPermissions())
                .build();
    }
}
