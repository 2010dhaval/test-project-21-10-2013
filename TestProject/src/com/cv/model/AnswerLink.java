package com.cv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_link")
public class AnswerLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ANSWER_LINK_ID")
	private int answerLinkId;

	@Column(name = "RANK")
	private int rank;

	@ManyToOne
	@JoinColumn(name = "RECOGNITION_ID", referencedColumnName = "RECOGNITION_ID")
	private Recognition recognition;

	@ManyToOne
	@JoinColumn(name = "ANSWER_ID", referencedColumnName = "ANSWER_ID")
	private Answer answer;

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

	public Recognition getRecognition() {
		return recognition;
	}

	public void setRecognition(Recognition recognition) {
		this.recognition = recognition;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
