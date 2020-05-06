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

//@Entity
@Table(name="examassign_table")
public class AssignExam {
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="examuser_sequence",allocationSize=1)
	@Column(name="examuserid")
	private int examUserId;
	
	@Column(name="marksscored")
	private int marksScored;
	
	
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="userid")
	private User user;
	@ManyToOne
	@JoinColumn(name="testid", referencedColumnName="testid")
	private Exam test;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Exam getTest() {
		return test;
	}
	public void setTest(Exam test) {
		this.test = test;
	}
	public int getExamUserId() {
		return examUserId;
	}
	public void setExamUserId(int examUserId) {
		this.examUserId = examUserId;
	}
	public int getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}
	
	

}
