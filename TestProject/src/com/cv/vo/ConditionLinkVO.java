package com.cv.vo;

import java.io.Serializable;




public class ConditionLinkVO implements Serializable{

	private Integer conditionLinkId;

	private Integer rank;

	private RecognitionVO recognition;

	private ConditionVO condition;

	public Integer getConditionLinkId() {
		return conditionLinkId;
	}

	public void setConditionLinkId(Integer conditionLinkId) {
		this.conditionLinkId = conditionLinkId;
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

	public ConditionVO getCondition() {
		return condition;
	}

	public void setCondition(ConditionVO condition) {
		this.condition = condition;
	}

}
