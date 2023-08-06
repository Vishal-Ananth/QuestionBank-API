package dev.vishal.questionbank.controller;

import dev.vishal.questionbank.model.Question;
import dev.vishal.questionbank.model.QuestionBank;
import dev.vishal.questionbank.service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questionbank")
public class QuestionBankController {
    @Autowired
    QuestionBankService questionBankService;

    @PostMapping("create")
    public String createQuestionBank(@RequestParam String name, @RequestParam String topic, @RequestParam Integer noOfQuestions) {
        return questionBankService.createQuestionBank(name, topic, noOfQuestions);
    }

    @GetMapping("get/{id}")
    public List<Question> getQuestionBank(@PathVariable Integer id){
        return questionBankService.getQuestionBank(id);
    }
}


