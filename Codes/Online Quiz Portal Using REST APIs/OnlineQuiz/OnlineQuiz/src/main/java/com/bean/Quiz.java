package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Quiz {
	@Id
	private int quizid;
	private String title;
	//@OneToMany
	//@JoinColumn(name = "qid")
	private int qid;
	
	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "Quiz [quizid=" + quizid + ", title=" + title + ", qid=" + qid + "]";
	}
	
	
	
}
