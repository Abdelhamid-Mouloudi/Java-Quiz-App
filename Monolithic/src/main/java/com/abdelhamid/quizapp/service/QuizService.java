package com.abdelhamid.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abdelhamid.quizapp.dao.QuestionDao;
import com.abdelhamid.quizapp.dao.QuizDao;
import com.abdelhamid.quizapp.model.Question;
import com.abdelhamid.quizapp.model.QuestionWrapper;
import com.abdelhamid.quizapp.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao ;
	@Autowired
	QuestionDao questionDao ;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED) ;
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDb = quiz.get().getQuestions() ;
		List<QuestionWrapper> questionsForUser = new ArrayList<>() ;
		for (Question q : questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0 ;
		int i = 0 ;
		for (Response response : responses ) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) ;
			i++ ;
		}
		return new ResponseEntity<>(right, HttpStatus.OK) ;
	}

	
	

}
