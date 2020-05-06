package com.cg.onlinetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinetest.entity.Question;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.exception.OnlineTestException;
import com.cg.onlinetest.service.QuestionService;

@RestController
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	Exam test;
	
	@PutMapping("question/test/{testid}/question/{questionid}")
	public ResponseEntity<Question> updateQuestionByTestId(@PathVariable("testid")int testId, @PathVariable("questionid")int questionId,@RequestBody  Question question)throws OnlineTestException
	{
		//boolean temp=onlineTestService.existsByTestId(testId);
		Exam exam=new Exam();
		exam.setTestId(testId);
		question.setTest(exam);
		//Question question1 =onlineTestService.getQuestionById(question.getQuestionId());
		ResponseEntity rt=null;
		//if((question1!=null))
		//{
			Question question1= questionService.updateQuestionById(testId,questionId,question);
			rt=new ResponseEntity<Question>(question1, HttpStatus.OK);
		//}
		//else
		//{
		//	rt=new ResponseEntity<Question>(question1, HttpStatus.NOT_FOUND);
		//}
		
		return rt;
	}
	@GetMapping("question/test/{id}")
	public ResponseEntity<List<Question>> getAllQuestionsByTestId(@PathVariable("id")int testId)throws OnlineTestException
	{
		//boolean temp=onlineTestService.existsByTestId(testId);
		List<Question> questionlist=questionService.getAllQuestionsByTestId(testId);
		ResponseEntity rt=null;
		if(questionlist!=null)
		{
		rt=new ResponseEntity<List<Question>>(questionlist,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<List<Question>>(HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	@PostMapping("question/{id}")
	public ResponseEntity<Question> addQuestionByTestId( @RequestBody Question question, @PathVariable("id")int testId)throws OnlineTestException
	{
		Exam exam=new Exam();
		exam.setTestId(testId);
		question.setTest(exam);
		List<Question> questionlist=questionService.getAllQuestionsByTestId(testId);
		//boolean temp=onlineTestService.existsByTestId(testId);
		Question tempQuestion=questionService.addQuestionByTestId(testId,question);
		ResponseEntity rt=null;
		if(questionlist!=null)
		{
			rt=new ResponseEntity<Question>(tempQuestion, HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Question>(tempQuestion, HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	@GetMapping("question")
	public List<Question> getAllQuestion()
	{
		List<Question> questionList=questionService.getAllQuestion();
		return questionList;
	}
	@GetMapping("test")
	public List<Exam> getAllTest()
	{
		List<Exam> testList=questionService.getAllTests();
		return testList;
	}
	@GetMapping("question/{id}")
	public ResponseEntity<Question> getQuestionByQuestionId(@PathVariable ("id")int questionId)throws OnlineTestException
	{
		Question question;
		ResponseEntity rt=null;
		question=questionService.getQuestionByQuestionId(questionId);
		if(question!=null) {
			rt=new ResponseEntity<Question>(question,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Question>(question,HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	@DeleteMapping("question/{id}")
	public ResponseEntity<Question> deleteQuestionById(@PathVariable ("id")int questionId)throws OnlineTestException
	{
		ResponseEntity rt=null;
		Question question;
		question=questionService.getQuestionByQuestionId(questionId);
		if(question!=null)
		{
			questionService.deleteQuestionById(questionId);
			rt=new ResponseEntity<Question>(question,HttpStatus.OK);
		}
		else
		{
			rt=new ResponseEntity<Question>(question,HttpStatus.NOT_FOUND);
		}
		return rt;
	}
	
	
}
	
	


