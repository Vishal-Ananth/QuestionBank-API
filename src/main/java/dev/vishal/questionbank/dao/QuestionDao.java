package dev.vishal.questionbank.dao;

import dev.vishal.questionbank.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    public List<Question> findByTopic(String topic);
    public List<Question> findByDifficulty(String difficulty);


}
