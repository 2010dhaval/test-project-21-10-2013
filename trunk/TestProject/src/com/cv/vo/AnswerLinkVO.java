package com.cv.vo;

import java.io.Serializable;



public class AnswerLinkVO implements Serializable{
	

	private Integer answerLinkId;
	
	
	private Integer rank;
	
	
	private RecognitionVO recognition;
	

	private AnswerVO answer;

	public Integer getAnswerLinkId() {
		return answerLinkId;
	}

	public void setAnswerLinkId(Integer answerLinkId) {
		this.answerLinkId = answerLinkId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public RecognitionVO getRecognition() {
		return recognition;
	}

	public void setRecognition(RecognitionVO recognition) {
		this.recognition = recognition;
	}

	public AnswerVO getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerVO answer) {
		this.answer = answer;
	}
	
	

}
