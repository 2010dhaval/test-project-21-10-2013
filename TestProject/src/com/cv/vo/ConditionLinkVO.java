package com.cv.vo;

import java.io.Serializable;




public class ConditionLinkVO implements Serializable{

	private int conditionLinkId;

	private int rank;

	private RecognitionVO recognition;

	private ConditionVO condition;

	public int getConditionLinkId() {
		return conditionLinkId;
	}

	public void setConditionLinkId(int conditionLinkId) {
		this.conditionLinkId = conditionLinkId;
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

	public ConditionVO getCondition() {
		return condition;
	}

	public void setCondition(ConditionVO condition) {
		this.condition = condition;
	}

}
