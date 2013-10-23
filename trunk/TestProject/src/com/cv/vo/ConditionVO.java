package com.cv.vo;

import java.io.Serializable;


public class ConditionVO implements Serializable{


	private Integer conditionId;

	private String condition;

	public Integer getConditionId() {
		return conditionId;
	}

	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
