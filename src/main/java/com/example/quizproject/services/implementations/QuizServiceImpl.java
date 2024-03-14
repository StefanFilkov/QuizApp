package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.repositories.QuestionRepository;
import com.example.quizproject.db.repositories.QuizRepository;
import com.example.quizproject.db.repositories.UserRepository;
import com.example.quizproject.models.inputs.QuizInput;
import com.example.quizproject.models.outputs.QuizOutput;
import com.example.quizproject.services.services.QuizService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final ConversionService conversionService;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, ConversionService conversionService,
                           UserRepository userRepository,
                           QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.conversionService = conversionService;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public QuizOutput createQuiz(QuizInput input) {
        Quiz quiz = conversionService.convert(input, Quiz.class);
        //TODO Exception quiz might be null
        Quiz savedQuiz = quizRepository.save(quiz);

        setQuizQuestionsById(quiz, input.getQuestionIds());
        setQuizUserById(quiz, input.getUserId());

        return conversionService.convert(savedQuiz, QuizOutput.class);
    }

    @Override
    public QuizOutput getQuizById(String id) {
        return null;
    }

    @Override
    public List<QuizOutput> listAllQuiz() {
        return null;
    }

    @Override
    public List<Question> listAllQuestions() {
        return null;
    }

    private void setQuizUserById(Quiz quiz, String userId){
        //TODO Exception if id doesn't exist
        quiz.setUser(userRepository.findById(userId).get());
    }

    private void setQuizQuestionsById(Quiz quiz, List<String> list){
        //TODO Exception if id doesn't exist
        List<Question> result= new ArrayList<>();
        for (String s : list)
            result.add(questionRepository.findById(s).get());

        quiz.setQuestions(result);
    }
}
