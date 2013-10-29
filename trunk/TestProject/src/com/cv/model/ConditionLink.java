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
@Table(name = "condition_link")
public class ConditionLink implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5933880963078045875L;
	@Id
	@GeneratedValue
	@Column(name = "CONDITION_LINK_ID")
	private Integer conditionLinkId;
	@Column(name = "RANK")
	private Integer rank;
	@ManyToOne
	@JoinColumn(name = "RECOGNITION_ID", referencedColumnName = "RECOGNITION_ID")
	private Recognition recognition;
	@ManyToOne
	@JoinColumn(name = "CONDITION_OBJECT_ID", referencedColumnName = "CONDITION_OBJECT_ID")
	private Condition condition;

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

	public Recognition getRecognition() {
		return recognition;
	}

	public void setRecognition(Recognition recognition) {
		this.recognition = recognition;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
