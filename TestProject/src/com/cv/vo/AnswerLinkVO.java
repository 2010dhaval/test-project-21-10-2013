package com.cv.vo;

import java.io.Serializable;



public class AnswerLinkVO implements Serializable{
	

	private int answerLinkId;
	
	
	private int rank;
	
	
	private RecognitionVO recognition;
	

	private AnswerVO answer;

	public int getAnswerLinkId() {
		return answerLinkId;
	}

	public void setAnswerLinkId(int answerLinkId) {
		this.answerLinkId = answerLinkId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
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
