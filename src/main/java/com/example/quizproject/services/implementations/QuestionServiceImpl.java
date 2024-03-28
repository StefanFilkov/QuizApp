package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.*;
import com.example.quizproject.db.repositories.*;
import com.example.quizproject.exceptions.*;
import com.example.quizproject.db.models.inputs.QuestionInput;
import com.example.quizproject.db.models.outputs.QuestionOutput;
import com.example.quizproject.services.services.QuestionService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final ConversionService conversionService;
    private final AnswerRepository answerRepository;
    private final CategoryRepository categoryRepository;
    private final DifficultyRepository difficultyRepository;
    private final QuizRepository quizRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, ConversionService conversionService, AnswerRepository answerRepository, CategoryRepository categoryRepository, DifficultyRepository difficultyRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.conversionService = conversionService;
        this.answerRepository = answerRepository;
        this.categoryRepository = categoryRepository;
        this.difficultyRepository = difficultyRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public QuestionOutput getQuestionById(String id) {
        Optional<Question> optionalEntity = questionRepository.findById(id);
        QuestionOutput questionOutput = conversionService.convert(optionalEntity.get(), QuestionOutput.class);
        return questionOutput;
    }

    @Override
    public QuestionOutput updateQuestion(String questionId) {
        //TODO
        return null;
    }


    @Override
    public QuestionOutput createQuestion(QuestionInput input) {

        Question question = conversionService.convert(input, Question.class);
        if (question == null)
            throw new InputCanNotBeNull();

        question.setDifficulty(getQuestionDifficulty(input.getDifficultyId()));
        question.setCategory(getQuestionCategory(input.getCategoryId()));
        question.setQuiz(getQuestionQuiz(input.getQuizId()));

        //question.setAnswers(getQuestionAnswers(input.getAnswerIds));
        //setQuestionByAnswersId(question, input.getAnswersIds());

        Question savedQuestion = questionRepository.save(question);
        return conversionService.convert(savedQuestion, QuestionOutput.class);
    }

    @Override
    public List<QuestionOutput> getQuestionsFromQuizById(String quizId) {
        //TODO
        return null;
    }

    @Override
    public List<Question> createMultipleQuestions() {
        return null;
    }


    private Difficulty getQuestionDifficulty(String id) {
        return difficultyRepository.findById(id).orElseThrow(() -> new DifficultyIdDoesNotExist(id));
    }


    private Category getQuestionCategory(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryIdDoesNotExist(id));
    }


    private Quiz getQuestionQuiz(String id) {
        return quizRepository.findById(id).orElseThrow(() -> new QuizIdDoesNotExist(id));
    }


    private List<Answer> getQuestionAnswers(List<String> ids) {
        List<Answer> result = new ArrayList<>();
        ids.forEach(id -> result.add(answerRepository.findById(id).orElseThrow(() -> new AnswerIdDoesNotExist(id))));
        return result;
    }
}
