package dev.vishal.questionbank.dao;

import dev.vishal.questionbank.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByTopic(String topic);
    List<Question> findByDifficulty(String difficulty);

    @Query(value = "SELECT * FROM QUESTION q WHERE q.topic=:topic AND q.difficulty=:difficulty",nativeQuery = true)
    List<Question> findByTopicByDifficulty(String topic, String difficulty);
}
