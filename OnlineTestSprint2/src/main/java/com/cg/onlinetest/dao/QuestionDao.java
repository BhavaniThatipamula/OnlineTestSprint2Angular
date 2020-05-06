package com.cg.onlinetest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinetest.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

	@Query("select e from Question e where test.testId =:testId")
	public List<Question> existsByTestId(@Param("testId") int testId);
	
	
	
}
