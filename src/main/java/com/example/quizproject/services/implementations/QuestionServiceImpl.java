package com.example.quizproject.services.implementations;

import com.example.quizproject.db.entities.Answer;
import com.example.quizproject.db.entities.Question;
import com.example.quizproject.db.repositories.*;
import com.example.quizproject.models.inputs.QuestionInput;
import com.example.quizproject.models.outputs.QuestionOutput;
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

        //setQuestionByAnswersId(question, input.getAnswersIds());
        setQuestionByCategoryId(question, input.getCategoryId());
        setQuestionByDifficultyId(question, input.getDifficultyId());
        setQuestionByQuizId(question, input.getQuizId());

        Question savedQuestion = questionRepository.save(question);
        return conversionService.convert(savedQuestion, QuestionOutput.class);
    }

    @Override
    public List<QuestionOutput> getQuestionsFromQuizById(String quizId) {
        //TODO
        return null;
    }

    private void setQuestionByDifficultyId(Question source, String id){
        //TODO Exception if "id" is invalid
        source.setDifficulty((difficultyRepository.findById(id)).get());
    }


    private void setQuestionByCategoryId(Question source, String id){
        //TODO Exception if "id" is invalid
        source.setCategory((categoryRepository.findById(id)).get());
    }


    private void setQuestionByQuizId(Question source, String id){
        //TODO Exception if "id" is invalid
        source.setQuiz((quizRepository.findById(id)).get());
    }


    private void setQuestionByAnswersId(Question source, List<String> ids){
        //TODO Exception if ids is null
        List<Answer> result = new ArrayList<>();

        for(String s: ids)
            result.add(answerRepository.findById(s).get());

        source.setAnswers(result);
    }
}
