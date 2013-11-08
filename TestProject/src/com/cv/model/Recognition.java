package com.cv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "recognition")
public class Recognition implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "RECOGNITION_ID")
	private Integer recId;
	@Column(name = "DESCRIPTION")
	private String desc;
	@Column(name = "QUESTION")
	private String question;
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	public Integer getRecId() {
		return recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// 1st five field ok
	@Column(name = "localVersionLastImport")
	private Integer localVersionLastImport;
	@Column(name = "recognitionCd")
	private String recognitionCd;
	@Column(name = "projectId")
	private Integer projectId;
	@Column(name = "recognitionExternalId")
	private Integer recognitionExternalId;
	@Column(name = "dtreeExternalId")
	private Integer dtreeExternalId;

	public Integer getLocalVersionLastImport() {
		return localVersionLastImport;
	}

	public void setLocalVersionLastImport(Integer localVersionLastImport) {
		this.localVersionLastImport = localVersionLastImport;
	}

	public String getRecognitionCd() {
		return recognitionCd;
	}

	public void setRecognitionCd(String recognitionCd) {
		this.recognitionCd = recognitionCd;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getRecognitionExternalId() {
		return recognitionExternalId;
	}

	public void setRecognitionExternalId(Integer recognitionExternalId) {
		this.recognitionExternalId = recognitionExternalId;
	}

	public Integer getDtreeExternalId() {
		return dtreeExternalId;
	}

	public void setDtreeExternalId(Integer dtreeExternalId) {
		this.dtreeExternalId = dtreeExternalId;
	}

	// 2nd 10 field
	@Column(name = "staticTargetId")
	private Integer staticTargetId;
	@Column(name = "matchVarNm")
	private String matchVarNm;
	@Column(name = "matchTarget")
	private String matchTarget;
	@Column(name = "matchTargetId")
	private Integer matchTargetId;
	@Column(name = "staticVarNm")
	private String staticVarNm;
	@Column(name = "staticVarVal")
	private String staticVarVal;
	@Column(name = "staticTarget")
	private String staticTarget;
	@Column(name = "recognitionGroup")
	private String recognitionGroup;
	@Column(name = "recgGroupId")
	private Integer recgGroupId;
	@Column(name = "exportGroup")
	private String exportGroup;

	public Integer getStaticTargetId() {
		return staticTargetId;
	}

	public void setStaticTargetId(Integer staticTargetId) {
		this.staticTargetId = staticTargetId;
	}

	public String getMatchVarNm() {
		return matchVarNm;
	}

	public void setMatchVarNm(String matchVarNm) {
		this.matchVarNm = matchVarNm;
	}

	public String getMatchTarget() {
		return matchTarget;
	}

	public void setMatchTarget(String matchTarget) {
		this.matchTarget = matchTarget;
	}

	public Integer getMatchTargetId() {
		return matchTargetId;
	}

	public void setMatchTargetId(Integer matchTargetId) {
		this.matchTargetId = matchTargetId;
	}

	public String getStaticVarNm() {
		return staticVarNm;
	}

	public void setStaticVarNm(String staticVarNm) {
		this.staticVarNm = staticVarNm;
	}

	public String getStaticVarVal() {
		return staticVarVal;
	}

	public void setStaticVarVal(String staticVarVal) {
		this.staticVarVal = staticVarVal;
	}

	public String getStaticTarget() {
		return staticTarget;
	}

	public void setStaticTarget(String staticTarget) {
		this.staticTarget = staticTarget;
	}

	public String getRecognitionGroup() {
		return recognitionGroup;
	}

	public void setRecognitionGroup(String recognitionGroup) {
		this.recognitionGroup = recognitionGroup;
	}

	public Integer getRecgGroupId() {
		return recgGroupId;
	}

	public void setRecgGroupId(Integer recgGroupId) {
		this.recgGroupId = recgGroupId;
	}

	public String getExportGroup() {
		return exportGroup;
	}

	public void setExportGroup(String exportGroup) {
		this.exportGroup = exportGroup;
	}

	// 3rd 10 field // 3rd 10 field
	@Column(name = "exportGroupId")
	private Integer exportGroupId;
	@Column(name = "promptExp")
	private String promptExp;
	@Column(name = "description2")
	private String description;
	@Column(name = "freeTextDisableIn")
	private Character freeTextDisableIn;
	@Column(name = "notes")
	private String notes;
	@Column(name = "isValid")
	private Character isValid;
	@Column(name = "isBlocked")
	private Character isBlocked;
	@Column(name = "extraData")
	private String extraData;
	@Column(name = "referenceId")
	private String referenceId;
	@Column(name = "isDtreeNode")
	private Character isDtreeNode;

	public Integer getExportGroupId() {
		return exportGroupId;
	}

	public void setExportGroupId(Integer exportGroupId) {
		this.exportGroupId = exportGroupId;
	}

	public String getPromptExp() {
		return promptExp;
	}

	public void setPromptExp(String promptExp) {
		this.promptExp = promptExp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getFreeTextDisableIn() {
		return freeTextDisableIn;
	}

	public void setFreeTextDisableIn(Character freeTextDisableIn) {
		this.freeTextDisableIn = freeTextDisableIn;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Character getIsValid() {
		return isValid;
	}

	public void setIsValid(Character isValid) {
		this.isValid = isValid;
	}

	public Character getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Character isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Character getIsDtreeNode() {
		return isDtreeNode;
	}

	public void setIsDtreeNode(Character isDtreeNode) {
		this.isDtreeNode = isDtreeNode;
	}

	// 4th 14 field
	@Column(name = "dtree")
	private String dtree;
	@Column(name = "isErrorRecognition")
	private Character isErrorRecognition;
	@Column(name = "maxInvldRspnsAllwbl")
	private Short maxInvldRspnsAllwbl;
	@Column(name = "contentApprStateCd")
	private Character contentApprStateCd;
	@Column(name = "nlpApprStateCd")
	private Character nlpApprStateCd;
	@Column(name = "customStatus")
	private String customStatus;
	@Column(name = "customStatusId")
	private Integer customStatusId;
	@Column(name = "globalId")
	private String globalId;
	@Column(name = "sourceId")
	private String sourceId;
	@Column(name = "extGlobalId")
	private String extGlobalId;
	@Column(name = "recognitionType")
	private String recognitionType;
	@Column(name = "recognitionTypeId")
	private Integer recognitionTypeId;
	@Column(name = "accuracyMethod")
	private String accuracyMethod;
	@Column(name = "accuracyMethodId")
	private Integer accuracyMethodId;

	public String getDtree() {
		return dtree;
	}

	public void setDtree(String dtree) {
		this.dtree = dtree;
	}

	public Character getIsErrorRecognition() {
		return isErrorRecognition;
	}

	public void setIsErrorRecognition(Character isErrorRecognition) {
		this.isErrorRecognition = isErrorRecognition;
	}

	public Short getMaxInvldRspnsAllwbl() {
		return maxInvldRspnsAllwbl;
	}

	public void setMaxInvldRspnsAllwbl(Short maxInvldRspnsAllwbl) {
		this.maxInvldRspnsAllwbl = maxInvldRspnsAllwbl;
	}

	public Character getContentApprStateCd() {
		return contentApprStateCd;
	}

	public void setContentApprStateCd(Character contentApprStateCd) {
		this.contentApprStateCd = contentApprStateCd;
	}

	public Character getNlpApprStateCd() {
		return nlpApprStateCd;
	}

	public void setNlpApprStateCd(Character nlpApprStateCd) {
		this.nlpApprStateCd = nlpApprStateCd;
	}

	public String getCustomStatus() {
		return customStatus;
	}

	public void setCustomStatus(String customStatus) {
		this.customStatus = customStatus;
	}

	public Integer getCustomStatusId() {
		return customStatusId;
	}

	public void setCustomStatusId(Integer customStatusId) {
		this.customStatusId = customStatusId;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getExtGlobalId() {
		return extGlobalId;
	}

	public void setExtGlobalId(String extGlobalId) {
		this.extGlobalId = extGlobalId;
	}

	public String getRecognitionType() {
		return recognitionType;
	}

	public void setRecognitionType(String recognitionType) {
		this.recognitionType = recognitionType;
	}

	public Integer getRecognitionTypeId() {
		return recognitionTypeId;
	}

	public void setRecognitionTypeId(Integer recognitionTypeId) {
		this.recognitionTypeId = recognitionTypeId;
	}

	public String getAccuracyMethod() {
		return accuracyMethod;
	}

	public void setAccuracyMethod(String accuracyMethod) {
		this.accuracyMethod = accuracyMethod;
	}

	public Integer getAccuracyMethodId() {
		return accuracyMethodId;
	}

	public void setAccuracyMethodId(Integer accuracyMethodId) {
		this.accuracyMethodId = accuracyMethodId;
	}

	// 5th 16 field
	@Column(name = "recognitionDataMaps")
	private String recognitionDataMaps;
	@Column(name = "recgNotesAttachments")
	private String recgNotesAttachments;
	@Column(name = "recognitionAlternates")
	private String recognitionAlternates;
	@Column(name = "recognitionScripts")
	private String recognitionScripts;
	@Column(name = "answerLinks")
	private String answerLinks;
	@Column(name = "conditionLinks")
	private String conditionLinks;
	@Column(name = "recognitionAttrPrompts")
	private String recognitionAttrPrompts;
	@Column(name = "reExportFlag")
	private Character reExportFlag;
	@Column(name = "projectInternalId")
	private Integer projectInternalId;
	@Column(name = "disambiguationPrompt")
	private String disambiguationPrompt;
	@Column(name = "isPubWithContentAppr")
	private Character isPubWithContentAppr;
	@Column(name = "isPubWithNlpAppr")
	private Character isPubWithNlpAppr;
	@Column(name = "isPubWithCusStatus")
	private Character isPubWithCusStatus;
	@Column(name = "isPubWithCondPattReqd")
	private Character isPubWithCondPattReqd;
	@Column(name = "isPubWithAnsReqd")
	private Character isPubWithAnsReqd;
	@Column(name = "isPubWithPromptTxtToRevsd")
	private Character isPubWithPromptTxtToRevsd;

	public String getRecognitionDataMaps() {
		return recognitionDataMaps;
	}

	public void setRecognitionDataMaps(String recognitionDataMaps) {
		this.recognitionDataMaps = recognitionDataMaps;
	}

	public String getRecgNotesAttachments() {
		return recgNotesAttachments;
	}

	public void setRecgNotesAttachments(String recgNotesAttachments) {
		this.recgNotesAttachments = recgNotesAttachments;
	}

	public String getRecognitionAlternates() {
		return recognitionAlternates;
	}

	public void setRecognitionAlternates(String recognitionAlternates) {
		this.recognitionAlternates = recognitionAlternates;
	}

	public String getRecognitionScripts() {
		return recognitionScripts;
	}

	public void setRecognitionScripts(String recognitionScripts) {
		this.recognitionScripts = recognitionScripts;
	}

	public String getAnswerLinks() {
		return answerLinks;
	}

	public void setAnswerLinks(String answerLinks) {
		this.answerLinks = answerLinks;
	}

	public String getConditionLinks() {
		return conditionLinks;
	}

	public void setConditionLinks(String conditionLinks) {
		this.conditionLinks = conditionLinks;
	}

	public String getRecognitionAttrPrompts() {
		return recognitionAttrPrompts;
	}

	public void setRecognitionAttrPrompts(String recognitionAttrPrompts) {
		this.recognitionAttrPrompts = recognitionAttrPrompts;
	}

	public Character getReExportFlag() {
		return reExportFlag;
	}

	public void setReExportFlag(Character reExportFlag) {
		this.reExportFlag = reExportFlag;
	}

	public Integer getProjectInternalId() {
		return projectInternalId;
	}

	public void setProjectInternalId(Integer projectInternalId) {
		this.projectInternalId = projectInternalId;
	}

	public String getDisambiguationPrompt() {
		return disambiguationPrompt;
	}

	public void setDisambiguationPrompt(String disambiguationPrompt) {
		this.disambiguationPrompt = disambiguationPrompt;
	}

	public Character getIsPubWithContentAppr() {
		return isPubWithContentAppr;
	}

	public void setIsPubWithContentAppr(Character isPubWithContentAppr) {
		this.isPubWithContentAppr = isPubWithContentAppr;
	}

	public Character getIsPubWithNlpAppr() {
		return isPubWithNlpAppr;
	}

	public void setIsPubWithNlpAppr(Character isPubWithNlpAppr) {
		this.isPubWithNlpAppr = isPubWithNlpAppr;
	}

	public Character getIsPubWithCusStatus() {
		return isPubWithCusStatus;
	}

	public void setIsPubWithCusStatus(Character isPubWithCusStatus) {
		this.isPubWithCusStatus = isPubWithCusStatus;
	}

	public Character getIsPubWithCondPattReqd() {
		return isPubWithCondPattReqd;
	}

	public void setIsPubWithCondPattReqd(Character isPubWithCondPattReqd) {
		this.isPubWithCondPattReqd = isPubWithCondPattReqd;
	}

	public Character getIsPubWithAnsReqd() {
		return isPubWithAnsReqd;
	}

	public void setIsPubWithAnsReqd(Character isPubWithAnsReqd) {
		this.isPubWithAnsReqd = isPubWithAnsReqd;
	}

	public Character getIsPubWithPromptTxtToRevsd() {
		return isPubWithPromptTxtToRevsd;
	}

	public void setIsPubWithPromptTxtToRevsd(Character isPubWithPromptTxtToRevsd) {
		this.isPubWithPromptTxtToRevsd = isPubWithPromptTxtToRevsd;
	}
	
	
	
	
}
