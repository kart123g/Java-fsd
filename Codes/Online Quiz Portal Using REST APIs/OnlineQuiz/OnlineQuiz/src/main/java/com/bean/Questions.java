package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int qid;
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String correctanswer;
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public void setCorrectanswer(String correctanswer) {
		this.correctanswer = correctanswer;
	}
	public int getQid() {
		return qid;
	}
	@Override
	public String toString() {
		return "Questions [qid=" + qid + ", question=" + question + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", correctanswer=" + correctanswer + "]";
	}
	
	
	
}
