package dev.vishal.questionbank.controller;

import dev.vishal.questionbank.model.Question;
import dev.vishal.questionbank.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("all")
    public List<Question> viewQuestions(){
        return questionService.viewQuestions();
    }

    @GetMapping(path = "topic/{topic}")
    public List<Question> viewByTopic(@PathVariable String topic){
        return questionService.viewByTopic(topic);
    }

    @GetMapping(path = "difficulty/{difficulty}")
    public List<Question> viewByDifficulty(@PathVariable String difficulty){
        return questionService.viewByDifficulty(difficulty);
    }

    @GetMapping(path = "filter")
    public List<Question> viewByTopicByDifficulty(@RequestParam String topic,@RequestParam String difficulty){
        return questionService.viewByTopicByDifficulty(topic,difficulty);
    }

    @PostMapping("add")
    public String createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @DeleteMapping(path = "delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return  questionService.deleteQuestion(id);
    }
}
