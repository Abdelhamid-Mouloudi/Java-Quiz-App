package com.abdelhamid.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.abdelhamid.quizapp.model.Question;
import com.abdelhamid.quizapp.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService ;
	
	
	 @GetMapping("allQuestions")
	    public ResponseEntity<List<Question>> getAllQuestions(){
	        return questionService.getAllQuestions();
	    }
	
	 @GetMapping("category/{category}")
	    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
	        return questionService.getQuestionsByCategory(category);
	    }
	  
	 @PostMapping("add")
	    public ResponseEntity<String> addQuestion(@RequestBody Question question){
	        return  questionService.addQuestion(question);
	    }

}
