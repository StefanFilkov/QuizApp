package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Category;
import com.example.quizproject.db.entities.Difficulty;
import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.entities.Quiz;
import com.example.quizproject.db.models.advancedInputs.CompleteQuizInput;
import com.example.quizproject.db.models.inputs.QuizInput;
import com.example.quizproject.db.models.outputs.QuizOutput;
import com.example.quizproject.db.repositories.*;
import com.example.quizproject.services.services.AnswerService;
import com.example.quizproject.services.services.CategoryService;
import com.example.quizproject.services.services.QuestionService;
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
    private final CategoryRepository categoryRepository;

    private final DifficultyRepository difficultyRepository;

    public QuizServiceImpl(QuizRepository quizRepository, ConversionService conversionService,
                           UserRepository userRepository,
                           QuestionRepository questionRepository,
                           CategoryRepository categoryRepository,
                           DifficultyRepository difficultyRepository) {
        this.quizRepository = quizRepository;
        this.conversionService = conversionService;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
        this.difficultyRepository = difficultyRepository;
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
        Quiz quiz = quizRepository.findById(id).get();
        return conversionService.convert(quiz, QuizOutput.class);
    }

    @Override
    public List<QuizOutput> listAllQuiz() {
        return null;
    }

    @Override
    public List<Question> listAllQuestions() {
        return null;
    }

    @Override
    public QuizOutput createCompleteQuiz(CompleteQuizInput input) {
        Quiz quiz = conversionService.convert(input, Quiz.class);

        quiz.getQuestions().forEach(question -> {

            if (question.getCategory().getId() == null)
                if (categoryRepository.findByCategoryName(question.getCategory().getCategoryName()).isEmpty())
                    question.setCategory(categoryRepository.save(question.getCategory()));
                else
                    question.setCategory(categoryRepository.findByCategoryName(question.getCategory().getCategoryName()).get());


            if (question.getDifficulty().getId() == null)
                if (difficultyRepository.findByDifficultyValue(question.getDifficulty().getDifficultyValue()).isEmpty())
                    question.setDifficulty(difficultyRepository.save(question.getDifficulty()));
                else
                    question.setDifficulty(difficultyRepository.findByDifficultyValue(question.getDifficulty().getDifficultyValue()).get());


            for (int j = 0; j < question.getAnswers().size(); j++)
                question.getAnswers().get(j).setQuestion(question);
        });

        quiz.setUser(null); //TODO

        questionRepository.saveAll(quiz.getQuestions());
        Quiz save = quizRepository.save(quiz);
        return conversionService.convert(save, QuizOutput.class);

    }


    private void setQuizUserById(Quiz quiz, String userId) {
        //TODO Exception if id doesn't exist
        quiz.setUser(userRepository.findById(userId).orElse(null));
    }

    private void setQuizQuestionsById(Quiz quiz, List<String> list) {
        //TODO Exception if id doesn't exist
        List<Question> result = new ArrayList<>();
        for (String s : list)
            result.add(questionRepository.findById(s).orElse(null));

        quiz.setQuestions(result);
    }
}
