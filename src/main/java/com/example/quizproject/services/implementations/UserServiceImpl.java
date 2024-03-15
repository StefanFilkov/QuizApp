package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Permission;
import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.entities.User;
import com.example.quizproject.db.repositories.PermissionRepository;
import com.example.quizproject.db.repositories.QuizRepository;
import com.example.quizproject.db.repositories.UserRepository;
import com.example.quizproject.models.inputs.UserInput;
import com.example.quizproject.models.outputs.UsersOutput;
import com.example.quizproject.services.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final PermissionRepository permissionRepository;
    private final QuizRepository quizRepository;
    private final ConversionService conversionService;
    private final UserRepository userRepository;

    public UserServiceImpl(PermissionRepository permissionRepository, QuizRepository quizRepository, ConversionService conversionService,
                           UserRepository userRepository) {
        this.permissionRepository = permissionRepository;
        this.quizRepository = quizRepository;
        this.conversionService = conversionService;
        this.userRepository = userRepository;
    }

    @Override
    public UsersOutput createUser(UserInput input) {
        User user= conversionService.convert(input,User.class);

        setQuizzesById(user, input.getQuizIds());
        setUserPermissionsById(user, input.getPermissionIds());

        User savedUser=userRepository.save(user);
        return conversionService.convert(savedUser, UsersOutput.class);
    }

    @Override
    public UsersOutput updateUser(String userId) {
        return null;
    }

    private void setUserPermissionsById(User user, List<String> list){
        //TODO Exception if "id" is invalid
        List<Permission> permissions = new ArrayList<>();
        for(String s : list)
            permissions.add(permissionRepository.findById(s).get());
        user.setPermissions(permissions);

    }
    private void setQuizzesById(User user, List<String> list){
        //TODO Exception if "ids" in the list are invalid
        List<Quiz> quizzes= new ArrayList<>();

        for(String s:list)
            quizzes.add(quizRepository.findById(s).get());
        user.setQuizzes(quizzes);
    }
}
