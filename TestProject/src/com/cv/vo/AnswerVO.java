package com.cv.vo;

import java.io.Serializable;



public class AnswerVO implements Serializable{
	
	
	private int answerId;
	
	
	private String answer;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
