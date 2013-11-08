package com.cv.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class RecognitionVO implements Serializable {

	private Integer recId;

	private String desc;

	private String question;

	private String startDate;

	private String endDate;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	// 1st five field ok
	private Integer localVersionLastImport;
	private String recognitionCd;
	private Integer projectId;
	private Integer recognitionExternalId;
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
	private Integer staticTargetId;
	private String matchVarNm;
	private String matchTarget;
	private Integer matchTargetId;
	private String staticVarNm;
	private String staticVarVal;
	private String staticTarget;
	private String recognitionGroup;
	private Integer recgGroupId;
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

	// 3rd 10 field

	private Integer exportGroupId;
	private String promptExp;
	private String description;
	private Character freeTextDisableIn;
	private String notes;
	private Character isValid;
	private Character isBlocked;
	private String extraData;
	private String referenceId;
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
	private String dtree;
	private Character isErrorRecognition;
	private Short maxInvldRspnsAllwbl;
	private Character contentApprStateCd;
	private Character nlpApprStateCd;
	private String customStatus;
	private Integer customStatusId;
	private String globalId;
	private String sourceId;
	private String extGlobalId;
	private String recognitionType;
	private Integer recognitionTypeId;
	private String accuracyMethod;
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
	
	private String recognitionDataMaps;
	private String recgNotesAttachments;
	private String recognitionAlternates;
	private String recognitionScripts;
	private String answerLinks;
	private String conditionLinks;
	private String recognitionAttrPrompts;
	private Character reExportFlag;
	private Integer projectInternalId;
	private String disambiguationPrompt;
	private Character isPubWithContentAppr;
	private Character isPubWithNlpAppr;
	private Character isPubWithCusStatus;
	private Character isPubWithCondPattReqd;
	private Character isPubWithAnsReqd;
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
