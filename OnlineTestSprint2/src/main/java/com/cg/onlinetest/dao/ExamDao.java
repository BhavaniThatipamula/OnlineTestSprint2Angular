package com.cg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinetest.entity.Exam;
import com.cg.onlinetest.entity.Question;

public interface ExamDao  extends JpaRepository<Exam,Integer>{

}
