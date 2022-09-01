package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userquiz")
public class UserQuiz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String emailid;
	private int quizid;
	private int qid;
	private String correctuseranswer;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getCorrectuseranswer() {
		return correctuseranswer;
	}
	public void setCorrectuseranswer(String correctuseranswer) {
		this.correctuseranswer = correctuseranswer;
	}
	public int getUserid() {
		return userid;
	}
	@Override
	public String toString() {
		return "UserQuiz [userid=" + userid + ", emailid=" + emailid + ", quizid=" + quizid + ", qid=" + qid
				+ ", correctuseranswer=" + correctuseranswer + "]";
	}
	public UserQuiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
