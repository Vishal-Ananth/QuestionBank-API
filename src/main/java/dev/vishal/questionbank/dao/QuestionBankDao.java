package dev.vishal.questionbank.dao;

import dev.vishal.questionbank.model.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionBankDao extends JpaRepository<QuestionBank,Integer> {
}
