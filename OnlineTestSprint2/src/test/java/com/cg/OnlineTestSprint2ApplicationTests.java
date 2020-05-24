package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinetest.dao.ExamDao;
import com.cg.onlinetest.dao.QuestionDao;
import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.Question;
import com.cg.onlinetest.exception.OnlineTestException;
import com.cg.onlinetest.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineTestSprint2ApplicationTests {
	
	@Autowired
	private QuestionService questionService;
	
	@MockBean
	private ExamDao examDao;
	
	@MockBean
	private QuestionDao questionDao;
	
	@Test
	void contextLoads() {
		
	}

	@Test
	public void getAllTests() {
		when(examDao.findAll()).thenReturn(Stream.of(new Exam(10,"Eamcet",160)).collect(Collectors.toList()));
		assertEquals(1,questionService.getAllTests().size());
	}
	
    @Test
	public void getAllQuestion() {
		when(questionDao.findAll()).thenReturn(Stream.of(new Question(1,"what is java")).collect(Collectors.toList()));
		assertEquals(1,questionService.getAllQuestion().size());
	}
}
