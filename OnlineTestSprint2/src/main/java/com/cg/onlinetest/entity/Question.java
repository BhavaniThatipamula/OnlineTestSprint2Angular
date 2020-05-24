package com.cg.onlinetest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class Question {
	
	
	public Question() {
		super();
	}
	public Question(int questionId, String questionTitle) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
	}
	@ManyToOne
	@JoinColumn(name="testid")
	private Exam test;
	
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="question_seq",allocationSize=1)
	@Column(name="questionid")
	private int questionId ;
	
	@Column(name="questiontitle",length=150)
	private String questionTitle ;
	
	@Column(name="questionoption1",length=15)
    private String questionoption1;
	
	@Column(name="questionoption2",length=15)
    private String questionoption2;
	
	@Column(name="questionoption3",length=15)
    private String questionoption3;
	@Column(name="questionoption4",length=15)
    private String questionoption4;
	
	@Column(name="questionanswer")
	private int questionAnswer ;
	
	@Column(name="questionmarks")
	private double questionMarks ;
	

	
	
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public Exam getTest() {
		return test;
	}
	public void setTest(Exam test) {
		this.test = test;
	}
	public String getQuestionoption1() {
		return questionoption1;
	}
	public void setQuestionoption1(String questionoption1) {
		this.questionoption1 = questionoption1;
	}
	public String getQuestionoption2() {
		return questionoption2;
	}
	public void setQuestionoption2(String questionoption2) {
		this.questionoption2 = questionoption2;
	}
	public String getQuestionoption3() {
		return questionoption3;
	}
	public void setQuestionoption3(String questionoption3) {
		this.questionoption3 = questionoption3;
	}
	public String getQuestionoption4() {
		return questionoption4;
	}
	public void setQuestionoption4(String questionoption4) {
		this.questionoption4 = questionoption4;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}
	
	
	
}
