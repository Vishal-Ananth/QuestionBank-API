package dev.vishal.questionbank.service;

import dev.vishal.questionbank.dao.QuestionBankDao;
import dev.vishal.questionbank.dao.QuestionDao;
import dev.vishal.questionbank.model.Question;
import dev.vishal.questionbank.model.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.QuitEvent;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionBankService {
    @Autowired
    QuestionBankDao questionBankDao;
    @Autowired
    QuestionDao questionDao;

    public String createQuestionBank(String name, String topic, Integer noOfQuestions) {
        List<Question> questions = questionDao.findQuestionsByTopic(topic,noOfQuestions);

        QuestionBank questionBank = new QuestionBank();
        questionBank.setName(name);
        questionBank.setQuestions(questions);
        questionBankDao.save(questionBank);

        return "Successfully Created QuestionBank";
    }

    public List<Question> getQuestionBank(Integer id) {
        Optional<QuestionBank> questionBank = questionBankDao.findById(id);

        return questionBank.get().getQuestions();
    }
}
