package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Participants;
import com.bean.Questions;
import com.bean.Quiz;
import com.bean.UserQuiz;

@Repository
public class QuizDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	public int partipantSignUp(Participants pt) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
				manager.persist(pt);						
			tran.commit();
			return 1;
		} catch (Exception e) {
		System.out.println(e);
		return 0;
		}
	}
	
	public List<Participants> partipantLoginIn() {
		EntityManager manag = emf.createEntityManager();
		Query qry = manag.createQuery("select pt from Participants pt");  			// JPQL 
		List<Participants> listOfParticipants = qry.getResultList();
		return listOfParticipants;
	}
	
	public int addQuestion(Questions q) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
				manager.persist(q);						
			tran.commit();
			return 1;
		} catch (Exception e) {
		System.out.println(e);
		return 0;
		}
	}

	public Questions findQuestions(int qid){
		EntityManager manager = emf.createEntityManager();					// Session in Hibernate 
		Questions q = manager.find(Questions.class, qid);					// session.get(Employee.class,id)
		return q;
	}
	
	
	public int createQuiz(Quiz qu) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
				manager.persist(qu);						
			tran.commit();
			return 1;
		} catch (Exception e) {
		System.out.println(e);
		return 0;
		}
	}
	
	public int takeQuiz(UserQuiz uq) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
				manager.persist(uq);						
			tran.commit();
			return 1;
		} catch (Exception e) {
		System.out.println(e);
		return 0;
		}
	}
	
	
	public String checkResult() {
		EntityManager manag = emf.createEntityManager();
		Query qry = manag.createQuery("select count(uq.userid) from Questions q,UserQuiz uq where q.correctanswer = uq.correctuseranswer");  			
		List result1 = qry.getResultList();
		Query qry1 = manag.createQuery("select uq.emailid from Questions q,UserQuiz uq where q.correctanswer = uq.correctuseranswer");  			
		List result2 = qry1.getResultList();
		result2.addAll(result1);
		String s = "Emailid  : " + result2.get(0) + "Score : " + result2.get(1);
		return s;
	}
	
}
