package com.cv.vo;

import java.io.Serializable;



public class AnswerVO implements Serializable{
	
	
	private Integer answerId;
	
	
	private String answer;

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	

}
