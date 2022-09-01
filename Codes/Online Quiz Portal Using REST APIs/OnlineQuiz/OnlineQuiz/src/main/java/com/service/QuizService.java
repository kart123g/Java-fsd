package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Participants;
import com.bean.Questions;
import com.bean.Quiz;
import com.bean.UserQuiz;
import com.dao.QuizDao;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	public String storeParticipant(Participants pt) {
		if(quizDao.partipantSignUp(pt) > 0) {
			return "Participant data Stored Successfully";
		}
		else {
			return "Data didn't store";
		}
	}
	
	public List<Participants> getAllParticipants() {
		return quizDao.partipantLoginIn();
		}
	
	
	public String storeQuestion(Questions q) {
		if(quizDao.addQuestion(q) > 0) {
			return "Question added Successfully";
		}
		else {
			return "Question didn't add";
		}
	}
	
	public Questions findQuestions(int qid) {
		return quizDao.findQuestions(qid);
	}
	
	
	public String createQuiz(Quiz qu) {
		if(quizDao.createQuiz(qu) > 0) {
			return "Quiz created Successfully";
		}
		else {
			return "Quiz didn't created";
		}
	}
	
	
	public String takeQuiz(UserQuiz uq) {
		if(quizDao.takeQuiz(uq) > 0) {
			return "UserQuiz created Successfully";
		}
		else {
			return "UserQuiz didn't created";
		}
	}
	
	
	public String checkResult() {
		return quizDao.checkResult();
		}
	
	
	
}
