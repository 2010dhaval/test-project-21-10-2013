package com.cv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "condition_Object")
public class Condition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3205424373218344191L;
	@Id
	@GeneratedValue
	@Column(name = "CONDITION_OBJECT_ID")
	private Integer conditionId;
	@Column(name = "CONDITION_DESC")
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
