package dev.vishal.questionbank.service;

import dev.vishal.questionbank.dao.QuestionDao;
import dev.vishal.questionbank.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public String createQuestion(Question question) {
        questionDao.save(question);
        return "Question "+question.getId()+" was created successfully!";
    }

    public List<Question> viewQuestions() {
        return questionDao.findAll();
    }

    public List<Question> viewByTopic(String topic) {
        return questionDao.findByTopic(topic);
    }

    public List<Question> viewByDifficulty(String difficulty) {
        return questionDao.findByDifficulty(difficulty);
    }
}
