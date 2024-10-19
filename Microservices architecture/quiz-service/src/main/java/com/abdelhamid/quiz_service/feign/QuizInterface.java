package com.abdelhamid.quiz_service.feign;

import com.abdelhamid.quiz_service.model.QuestionWrapper;
import com.abdelhamid.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) ;
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) ;
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(List<Response> responses) ;


}



