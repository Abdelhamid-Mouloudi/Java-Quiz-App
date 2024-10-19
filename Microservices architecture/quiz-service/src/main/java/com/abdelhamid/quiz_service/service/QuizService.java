package com.abdelhamid.quiz_service.service;

import java.util.ArrayList;
import java.util.List;
import com.abdelhamid.quiz_service.dao.QuizDao;
import com.abdelhamid.quiz_service.feign.QuizInterface;
import com.abdelhamid.quiz_service.model.QuestionWrapper;
import com.abdelhamid.quiz_service.model.Quiz;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class QuizService {
	@Autowired
	QuizDao quizDao ;
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success", HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
	//	Optional<Quiz> quiz = quizDao.findById(id);
		//	List<Question> questionsFromDb = quiz.get().getQuestions() ;
	List<QuestionWrapper> questionsForUser = new ArrayList<>() ;
//		for (Question q : questionsFromDb) {
//			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//			questionsForUser.add(qw);
		//	}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
//		Quiz quiz = quizDao.findById(id).get();
//		List<Question> questions = quiz.getQuestions();
		int right = 0 ;
//		int i = 0 ;
//		for (Response response : responses ) {
//			if(response.getResponse().equals(questions.get(i).getRightAnswer())) ;
//			i++ ;
//		}
		return new ResponseEntity<>(right, HttpStatus.OK) ;
	}

	
	

}
