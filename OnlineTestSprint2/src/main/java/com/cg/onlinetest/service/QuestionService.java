package com.cg.onlinetest.service;

import java.util.List;

import com.cg.onlinetest.entity.Question;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.exception.OnlineTestException;


public interface QuestionService {
	
	public Question updateQuestionById(int testId,int questionId,Question question)throws OnlineTestException;
	public List<Question> getAllQuestion();
	public Question addQuestionByTestId(int testId,Question question)throws OnlineTestException;
	public Question deleteQuestionById(int questionId)throws OnlineTestException;
	public Question getQuestionByQuestionId(int questionId)throws OnlineTestException;
	//public boolean existsByTestId(int testId)throws OnlineTestException;
	
	public List<Question> getAllQuestionsByTestId(int testId)throws OnlineTestException;
	public List<Exam> getAllTests();
	

}
