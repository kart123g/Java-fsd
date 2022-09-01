package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AdminLogin;
import com.bean.Participants;
import com.bean.Questions;
import com.bean.Quiz;
import com.bean.UserQuiz;
import com.service.QuizService;

@RestController
public class QuizController {

	
	@Autowired
	QuizService quizService;
	
	
	// http://localhost:8080/checkAdmin/
	
	@RequestMapping(value = "checkAdmin/{emailid}/{password}",method=RequestMethod.POST)
	public String checkAdminLogin(@PathVariable("emailid") String emailid,@PathVariable("password") String password) {
		//List<AdminLogin> listAdmin = quizservice.checkadminDetails();
		if(emailid.equals("admin@quiz.in") && password.equals("123")) {
			return "Admin logged in successfully";
		}
		else {
			return "Admin Not Found";
		}
	}
	
	
	// http://localhost:8080/signUp/
	
		@RequestMapping(value = "signUp",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String signUp(@RequestBody Participants pt) {
			return quizService.storeParticipant(pt);
		}
	
		
		// http://localhost:8080/checkParticipants/
		
		@RequestMapping(value = "checkParticipants/{emailid}/{password}",method=RequestMethod.POST)
		public String checkParticipantsLogin(@PathVariable("emailid") String emailid,@PathVariable("password") String password) {
			List<Participants> listOfParticipants = quizService.getAllParticipants();
			Participants s = listOfParticipants.get(0);
			if(s.equals(emailid) && s.equals(password)) {
				return "Paticipant logged in successfully";
			}
			else {
				return "Paticipant Not Found";
			}
		}
		
		//http://localhost:8080/getAllParticipants/
		@RequestMapping(value = "getAllParticipants",method=RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<Participants> getAllParticipants() {
			return quizService.getAllParticipants();
		}
		
		
		//http://localhost:8080/addQuestion/
		@RequestMapping(value = "addQuestion",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String addQuestion(@RequestBody Questions q) {
			return quizService.storeQuestion(q);
		}
		
		
		// http://localhost:8080/findQuestionsById/1		
		@RequestMapping(value = "findQuestionsById/{qid}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public Questions findQuestionsByIdUsingPathParam(@PathVariable("qid") int id) {
			return quizService.findQuestions(id);
		}
				
		
		//http://localhost:8080/createQuiz/
		@RequestMapping(value = "createQuiz",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String createQuiz(@RequestBody Quiz qu) {
			return quizService.createQuiz(qu);
		}
		
		//http://localhost:8080/takeQuiz/
		@RequestMapping(value = "takeQuiz",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String takeQuizQuiz(@RequestBody UserQuiz uq) {
			return quizService.takeQuiz(uq);
		}
		
		//http://localhost:8080/checkResult/
		@RequestMapping(value = "checkResult",method=RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String checkResult() {
			return quizService.checkResult();
		}
		
		
		
	
}
