package com.abdelhamid.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdelhamid.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
