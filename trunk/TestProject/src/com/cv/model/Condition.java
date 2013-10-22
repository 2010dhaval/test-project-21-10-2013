package com.cv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condition")
public class Condition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3205424373218344191L;
	@Id
	@GeneratedValue
	@Column(name = "CONDITION_ID")
	private int conditionId;
	@Column(name = "CONDITION")
	private String condition;

	public int getConditionId() {
		return conditionId;
	}

	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
