package com.cg.onlinetest.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="test_table")
public class Exam {
	
	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="test_sequence",allocationSize=1)
	@Column(name="testid")
	private int testId;
	
	@Column(name="testname",length=15)
    private String testTitle;
	
	@Column(name="testmarks")
    private double testMarks;
	
	 @Column(name="starttime",columnDefinition="TIMESTAMP")
	    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="hh:mm:ss")
	    private Date startTime;
	 
	 @Column(name="endtime",columnDefinition="TIMESTAMP")
	    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="hh:mm:ss")
	    private Date endTime;
	 
	 @Column(name="duration")
	    private int testDuration; 
		
	    
	
	
	@OneToMany(mappedBy="test")
    @JsonIgnore
	List<Question> listOfQuestion=new ArrayList<>();




	public int getTestId() {
		return testId;
	}




	public void setTestId(int testId) {
		this.testId = testId;
	}




	public String getTestTitle() {
		return testTitle;
	}




	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}




	public double getTestMarks() {
		return testMarks;
	}




	public void setTestMarks(double testMarks) {
		this.testMarks = testMarks;
	}




	public Date getStartTime() {
		return startTime;
	}




	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}




	public Date getEndTime() {
		return endTime;
	}




	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}




	public int getTestDuration() {
		return testDuration;
	}




	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}




	public List<Question> getListOfQuestion() {
		return listOfQuestion;
	}




	public void setListOfQuestion(List<Question> listOfQuestion) {
		this.listOfQuestion = listOfQuestion;
	}
    
	 

}
