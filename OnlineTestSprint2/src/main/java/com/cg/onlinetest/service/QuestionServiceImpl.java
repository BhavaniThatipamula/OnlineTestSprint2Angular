package com.cg.onlinetest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinetest.dao.ExamDao;
import com.cg.onlinetest.dao.QuestionDao;
import com.cg.onlinetest.entity.Question;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.exception.OnlineTestException;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	QuestionDao questionDao;
	@Autowired
	ExamDao examDao;

	@Override
	public Question updateQuestionById(int testId,int questionId,Question question) throws OnlineTestException {
	 
		int id=question.getQuestionId();
		Question question1=null;
		//List<Question> list=onlineTestDao.existsByTestId(testId);
	
		//if((onlineTestDao.existsById(id))&&(list!=null))
		if(question.getTest().getTestId()==testId)
		{
				if(questionDao.existsById(questionId))
				{
					question = questionDao.saveAndFlush(question);
				}
				else
				{
					throw new OnlineTestException("Question ID "+id+" not found");
				}
		}
		else
		{
			throw new OnlineTestException("Test ID not found");
		}
		return question;
	}

	@Override
	public List<Question> getAllQuestionsByTestId(int testId) throws OnlineTestException
	{
		List<Question> list;
		list=questionDao.existsByTestId(testId);
		if(list==null)
		{
			throw new OnlineTestException("TestId not found");
		}else
		{
		return list;
		}
	}
	@Override
	public Question deleteQuestionById(int questionId) throws OnlineTestException {
		Question question=null;
		if(questionDao.existsById(questionId))
		{
			question=questionDao.findById(questionId).get();
			questionDao.deleteById(questionId);
		}
		else
		{
			throw new OnlineTestException("Id not found");
		}
		return question;
	}
	@Override
	public Question addQuestionByTestId(int testId, Question question)throws OnlineTestException
	{
		Question tempQuestion=null;
		List<Question> list=questionDao.existsByTestId(testId);
		if(list!=null)
		{
			tempQuestion=questionDao.saveAndFlush(question);
		}
		else
		{
			throw new OnlineTestException("TestId not found");
	}
		return tempQuestion;
	}

	@Override
	public List<Question> getAllQuestion() {
		List<Question> questionList=questionDao.findAll();
		return questionList;
	}
	@Override
	public Question getQuestionByQuestionId(int questionId) throws OnlineTestException {
		
		Question question=questionDao.findById(questionId).get();
		return question;
	}

	@Override
	public List<Exam> getAllTests() {
		List<Exam> examList=examDao.findAll();
		return examList;
	}
	

//	@Override
//	public boolean existsByTestId(int testId) throws OnlineTestException {
//	
//		boolean temp=onlineTestDao.existsById(testId);
//		if(!temp)
//		{
//			throw new OnlineTestException("TestId not found");
//		}
//		return temp;
//	}
		
	

	}