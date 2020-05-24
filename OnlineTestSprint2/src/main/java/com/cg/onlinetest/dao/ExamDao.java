package com.cg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlinetest.entity.Exam;


public interface ExamDao  extends JpaRepository<Exam,Integer>{

}
