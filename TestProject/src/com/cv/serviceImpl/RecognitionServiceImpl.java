package com.cv.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.RecognitionDao;
import com.cv.model.Recognition;
import com.cv.service.RecognitionService;
import com.cv.utils.DozerHelper;
import com.cv.utils.DozerUtil;
import com.cv.vo.RecognitionVO;

@Service
public class RecognitionServiceImpl implements RecognitionService {

	@Autowired
	private RecognitionDao recognitionDao;
	File file = new File("H:/CV_Documents/DozerTime.txt");

	@Override
	public void addRecognition(RecognitionVO recognitionVO) {
		try {

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			// bw.write(content);

			// TODO Auto-generated method stub
			long startTime = 0;
			long endTime = 0;
			long total = 0;
			// // ----------------------- Object-1-loop-1--------------------//
			//
			// // ----------------- dozer convertio------------------//
			// startTime = new Date().getTime();
			// Recognition recognition =
			// DozerUtil.xmlConfig().map(recognitionVO,
			// Recognition.class, "recognition");
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("1. Object-1 loop-1 dozer convertio = " + (int) total
			// + " ----");
			//
			// // ------------- custom convert-----------------//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			// startTime = new Date().getTime();
			// Recognition r11 = prepareRecognitionVO(recognitionVO);
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("2. Object-1 loop-1 custom convertio = " + (int) total
			// + " ----");
			//
			// // -----------------------------
			// // Object-1-loop-10----------------------------//
			//
			// // -------------------- dozer
			// convertio--------------------------//
			//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 10; i++) {
			// Recognition recognition2 = DozerUtil.xmlConfig().map(
			// recognitionVO, Recognition.class, "recognition");
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("3. Object-1 loop-10 dozer convertio = " + (int) total
			// + " ----");
			//
			// // -----------------custom convert-----------------------------//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 10; i++) {
			// Recognition r110 = prepareRecognitionVO(recognitionVO);
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("4. Object-1 loop-10 custom convertio = " + (int) total
			// + " ----");
			//
			// // -----------------------------
			// // Object-1-loop-100----------------------------//
			//
			// // -------------------- dozer
			// convertio--------------------------//
			//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 100; i++) {
			// Recognition recognition2 = DozerUtil.xmlConfig().map(
			// recognitionVO, Recognition.class, "recognition");
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("5. Object-1 loop-100 dozer convertio = " + (int) total
			// + " ----");
			//
			// // -----------------custom convert-----------------------------//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 100; i++) {
			// Recognition r1100 = prepareRecognitionVO(recognitionVO);
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("6. Object-1 loop-100 custom convertio = " + (int) total
			// + " ----");
			//
			// // -----------------------------
			// // Object-1-loop-1000----------------------------//
			//
			// // -------------------- dozer
			// convertio--------------------------//
			//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 1000; i++) {
			// Recognition recognition2 = DozerUtil.xmlConfig().map(
			// recognitionVO, Recognition.class, "recognition");
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("7. Object-1 loop-1000 dozer convertio = " + (int) total
			// + " ----");
			//
			// // -----------------custom convert-----------------------------//
			// startTime = 0;
			// endTime = 0;
			// total = 0;
			//
			// startTime = new Date().getTime();
			// for (int i = 0; i < 1000; i++) {
			// Recognition r11000 = prepareRecognitionVO(recognitionVO);
			// }
			// endTime = new Date().getTime();
			// total = endTime - startTime;
			//
			// bw.write("8. Object-1 loop-1000 custom convertio = " + (int)
			// total
			// + " ----");
			//
			// // -----------------------------
			// Object-1-loop-10000----------------------------//

			// -------------------- dozer convertio--------------------------//

			startTime = 0;
			endTime = 0;
			total = 0;
			Recognition recognition = null;
			startTime = new Date().getTime();
			for (int i = 0; i < 10000; i++) {
				recognition = DozerUtil.xmlConfig().map(recognitionVO,
						Recognition.class, "recognition");
			}
			endTime = new Date().getTime();
			total = endTime - startTime;

			bw.write("9. Object-1 loop-10000 dozer convertio = " + (int) total
					+ " ----");

			// -----------------custom convert-----------------------------//
			startTime = 0;
			endTime = 0;
			total = 0;

			startTime = new Date().getTime();
			for (int i = 0; i < 10000; i++) {
				Recognition r110000 = prepareRecognitionVO(recognitionVO);
			}
			endTime = new Date().getTime();
			total = endTime - startTime;

			bw.write("10. Object-1 loop-10000 custom convertio = "
					+ (int) total + " ----");

			// database hit
			this.recognitionDao.addRecognition(recognition);

			// custom convert
			System.out.println("before rec add  reverse custom convert= "
					+ new Date().getTime());
			prepareRecognitionVO(recognition);
			System.out.println("after rec add  reverse custom convert= "
					+ new Date().getTime());
			// dozer convertio
			System.out.println("before rec add reverse dozer convertion = "
					+ new Date().getTime());
			DozerUtil.xmlConfig()
					.map(recognition, recognitionVO, "recognition");
			System.out.println("after rec add reverse dozer convertion = "
					+ new Date().getTime());

			bw.close();
		} catch (Exception e) {

		}
	}

	File file2 = new File("H:/CV_Documents/DozerTimeList.txt");

	@Override
	public List<RecognitionVO> listRecognition() {
		System.out.println("reached");

		try {
			if (!file2.exists()) {
				file2.createNewFile();
			}
			FileWriter fw1 = new FileWriter(file2.getAbsoluteFile());

			BufferedWriter bw1 = new BufferedWriter(fw1);

			List<Recognition> recognitions = this.recognitionDao
					.listRecognition();
			long startTime = 0;
			long endTime = 0;
			long total = 0;

			// --------------------- List-10 Loop-1--------------------//
			// ----------- dozer convertion-------------//
			startTime = 0;
			endTime = 0;
			total = 0;

			startTime = new Date().getTime();
			List<RecognitionVO> recognitionVOList = null;
			for (int i = 0; i < 10; i++) {
				recognitionVOList = DozerHelper.map(DozerUtil.xmlConfig(),
						recognitions, RecognitionVO.class, "recognition");
			}
			endTime = new Date().getTime();
			total = endTime - startTime;

			bw1.write("1. List-10000 loop-10 dozer convertio = " + (int) total
					+ " ----");

			// ------------- custom convert-------------//
			startTime = 0;
			endTime = 0;
			total = 0;

			startTime = new Date().getTime();
			for (int i = 0; i < 10; i++) {
				List<RecognitionVO> list = prepareListofVO(recognitions);
			}
			endTime = new Date().getTime();
			total = endTime - startTime;

			bw1.write("2. List-10000 loop-10 custom convertio = " + (int) total
					+ " ----");

			bw1.close();
			return recognitionVOList;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RecognitionVO getRecVoByRecId(Integer recId) {
		RecognitionVO recognitionVO = DozerUtil.xmlConfig().map(
				this.recognitionDao.getRecVoByRecId(recId),
				RecognitionVO.class, "recognition");

		return recognitionVO;
	}

	private Recognition prepareRecognitionVO(RecognitionVO recognitionVO) {
		Recognition recognition = new Recognition();
		// 1st five field ok
		recognition.setRecId(recognitionVO.getRecId());
		recognition.setDesc(recognitionVO.getDesc());
		recognition.setStartDate(this.stringToDateConv(recognitionVO
				.getStartDate()));
		recognition
				.setEndDate(this.stringToDateConv(recognitionVO.getEndDate()));
		recognition.setQuestion(recognitionVO.getQuestion());
		recognition.setLocalVersionLastImport(recognitionVO
				.getLocalVersionLastImport());
		recognition.setRecognitionCd(recognitionVO.getRecognitionCd());
		recognition.setProjectId(recognitionVO.getProjectId());
		recognition.setRecognitionExternalId(recognitionVO
				.getRecognitionExternalId());
		recognition.setDtreeExternalId(recognitionVO.getDtreeExternalId());
		// 2nd 10 field ok
		recognition.setStaticTargetId(recognitionVO.getStaticTargetId());
		recognition.setMatchVarNm(recognitionVO.getMatchVarNm());
		recognition.setMatchTarget(recognitionVO.getMatchTarget());
		recognition.setMatchTargetId(recognitionVO.getMatchTargetId());
		recognition.setStaticVarNm(recognitionVO.getStaticVarNm());
		recognition.setStaticVarVal(recognitionVO.getStaticVarVal());
		recognition.setStaticTarget(recognitionVO.getStaticTarget());
		recognition.setRecognitionGroup(recognitionVO.getRecognitionGroup());
		recognition.setRecgGroupId(recognitionVO.getRecgGroupId());
		recognition.setExportGroup(recognitionVO.getExportGroup());
		// 3rd 10 field
		recognition.setExportGroupId(recognitionVO.getExportGroupId());
		recognition.setPromptExp(recognitionVO.getPromptExp());
		recognition.setDescription(recognitionVO.getDescription());
		recognition.setFreeTextDisableIn(recognitionVO.getFreeTextDisableIn());
		recognition.setNotes(recognitionVO.getNotes());
		recognition.setIsValid(recognitionVO.getIsValid());
		recognition.setIsBlocked(recognitionVO.getIsBlocked());
		recognition.setExtraData(recognitionVO.getExtraData());
		recognition.setReferenceId(recognitionVO.getReferenceId());
		recognition.setIsDtreeNode(recognitionVO.getIsDtreeNode());
		// 4th 14 field
		recognition.setDtree(recognitionVO.getDtree());
		recognition
				.setIsErrorRecognition(recognitionVO.getIsErrorRecognition());
		recognition.setMaxInvldRspnsAllwbl(recognitionVO
				.getMaxInvldRspnsAllwbl());
		recognition
				.setContentApprStateCd(recognitionVO.getContentApprStateCd());
		recognition.setNlpApprStateCd(recognitionVO.getNlpApprStateCd());
		recognition.setCustomStatus(recognitionVO.getCustomStatus());
		recognition.setCustomStatusId(recognitionVO.getCustomStatusId());
		recognition.setGlobalId(recognitionVO.getGlobalId());
		recognition.setSourceId(recognitionVO.getSourceId());
		recognition.setExportGroupId(recognitionVO.getExportGroupId());
		recognition.setRecognitionType(recognitionVO.getRecognitionType());
		recognition.setRecognitionTypeId(recognitionVO.getRecognitionTypeId());
		recognition.setAccuracyMethod(recognitionVO.getAccuracyMethod());
		recognition.setAccuracyMethodId(recognitionVO.getAccuracyMethodId());
		// 5th 16 field
		recognition.setRecognitionDataMaps(recognitionVO
				.getRecognitionDataMaps());
		recognition.setRecgNotesAttachments(recognitionVO
				.getRecgNotesAttachments());
		recognition.setRecognitionAlternates(recognitionVO
				.getRecognitionAlternates());
		recognition
				.setRecognitionScripts(recognitionVO.getRecognitionScripts());
		recognition.setAnswerLinks(recognitionVO.getAnswerLinks());
		recognition.setConditionLinks(recognitionVO.getConditionLinks());
		recognition.setRecognitionAttrPrompts(recognitionVO
				.getRecognitionAttrPrompts());
		recognition.setReExportFlag(recognitionVO.getReExportFlag());
		recognition.setProjectInternalId(recognitionVO.getProjectInternalId());
		;
		recognition.setDisambiguationPrompt(recognitionVO
				.getDisambiguationPrompt());
		recognition.setIsPubWithContentAppr(recognitionVO
				.getIsPubWithContentAppr());
		recognition.setIsPubWithNlpAppr(recognitionVO.getIsPubWithNlpAppr());
		recognition
				.setIsPubWithCusStatus(recognitionVO.getIsPubWithCusStatus());
		recognition.setIsPubWithCondPattReqd(recognitionVO
				.getIsPubWithCondPattReqd());
		recognition.setIsPubWithAnsReqd(recognitionVO
				.getIsPubWithCondPattReqd());
		recognition.setIsPubWithPromptTxtToRevsd(recognitionVO
				.getIsPubWithPromptTxtToRevsd());
		return recognition;
	}

	private List<RecognitionVO> prepareListofVO(List<Recognition> recognitions) {
		List<RecognitionVO> recognitionVOs = null;
		if (recognitions != null && !recognitions.isEmpty()) {
			recognitionVOs = new ArrayList<RecognitionVO>();
			RecognitionVO recognitionVO = null;
			for (Recognition recognition : recognitions) {
				recognitionVO = new RecognitionVO();

				recognitionVO.setRecId(recognition.getRecId());
				recognitionVO.setDesc(recognition.getDesc());
				if (recognition.getStartDate() != null) {
					recognitionVO.setStartDate(this
							.dateTostringConv(recognition.getStartDate()));
				}

				if (recognition.getEndDate() != null) {
					recognitionVO.setEndDate(this.dateTostringConv(recognition
							.getEndDate()));
				}

				recognitionVO.setQuestion(recognition.getQuestion());
				// 1st five field ok
				recognitionVO.setLocalVersionLastImport(recognition
						.getLocalVersionLastImport());
				recognitionVO.setRecognitionCd(recognition.getRecognitionCd());
				recognitionVO.setProjectId(recognition.getProjectId());
				recognitionVO.setRecognitionExternalId(recognition
						.getRecognitionExternalId());
				recognitionVO.setDtreeExternalId(recognition
						.getDtreeExternalId());
				// 2nd 10 field ok
				recognitionVO
						.setStaticTargetId(recognition.getStaticTargetId());
				recognitionVO.setMatchVarNm(recognition.getMatchVarNm());
				recognitionVO.setMatchTarget(recognition.getMatchTarget());
				recognitionVO.setMatchTargetId(recognition.getMatchTargetId());
				recognitionVO.setStaticVarNm(recognition.getStaticVarNm());
				recognitionVO.setStaticVarVal(recognition.getStaticVarVal());
				recognitionVO.setStaticTarget(recognition.getStaticTarget());
				recognitionVO.setRecognitionGroup(recognition
						.getRecognitionGroup());
				recognitionVO.setRecgGroupId(recognition.getRecgGroupId());
				recognitionVO.setExportGroup(recognition.getExportGroup());
				// 3rd 10 field
				recognitionVO.setExportGroupId(recognition.getExportGroupId());
				recognitionVO.setPromptExp(recognition.getPromptExp());
				recognitionVO.setDescription(recognition.getDescription());
				recognitionVO.setFreeTextDisableIn(recognition
						.getFreeTextDisableIn());
				recognitionVO.setNotes(recognition.getNotes());
				recognitionVO.setIsValid(recognition.getIsValid());
				recognitionVO.setIsBlocked(recognition.getIsBlocked());
				recognitionVO.setExtraData(recognition.getExtraData());
				recognitionVO.setReferenceId(recognition.getReferenceId());
				recognitionVO.setIsDtreeNode(recognition.getIsDtreeNode());
				// 4th 14 field
				recognitionVO.setDtree(recognition.getDtree());
				recognitionVO.setIsErrorRecognition(recognition
						.getIsErrorRecognition());
				recognitionVO.setMaxInvldRspnsAllwbl(recognition
						.getMaxInvldRspnsAllwbl());
				recognitionVO.setContentApprStateCd(recognition
						.getContentApprStateCd());
				recognitionVO
						.setNlpApprStateCd(recognition.getNlpApprStateCd());
				recognitionVO.setCustomStatus(recognition.getCustomStatus());
				recognitionVO
						.setCustomStatusId(recognition.getCustomStatusId());
				recognitionVO.setGlobalId(recognition.getGlobalId());
				recognitionVO.setSourceId(recognition.getSourceId());
				recognitionVO.setExportGroupId(recognition.getExportGroupId());
				recognitionVO.setRecognitionType(recognition
						.getRecognitionType());
				recognitionVO.setRecognitionTypeId(recognition
						.getRecognitionTypeId());
				recognitionVO
						.setAccuracyMethod(recognition.getAccuracyMethod());
				recognitionVO.setAccuracyMethodId(recognition
						.getAccuracyMethodId());
				// 5th 16 field
				recognitionVO.setRecognitionDataMaps(recognition
						.getRecognitionDataMaps());
				recognitionVO.setRecgNotesAttachments(recognition
						.getRecgNotesAttachments());
				recognitionVO.setRecognitionAlternates(recognition
						.getRecognitionAlternates());
				recognitionVO.setRecognitionScripts(recognition
						.getRecognitionScripts());
				recognitionVO.setAnswerLinks(recognition.getAnswerLinks());
				recognitionVO
						.setConditionLinks(recognition.getConditionLinks());
				recognitionVO.setRecognitionAttrPrompts(recognition
						.getRecognitionAttrPrompts());
				recognitionVO.setReExportFlag(recognition.getReExportFlag());
				recognitionVO.setProjectInternalId(recognition
						.getProjectInternalId());
				;
				recognitionVO.setDisambiguationPrompt(recognition
						.getDisambiguationPrompt());
				recognitionVO.setIsPubWithContentAppr(recognition
						.getIsPubWithContentAppr());
				recognitionVO.setIsPubWithNlpAppr(recognition
						.getIsPubWithNlpAppr());
				recognitionVO.setIsPubWithCusStatus(recognition
						.getIsPubWithCusStatus());
				recognitionVO.setIsPubWithCondPattReqd(recognition
						.getIsPubWithCondPattReqd());
				recognitionVO.setIsPubWithAnsReqd(recognition
						.getIsPubWithCondPattReqd());
				recognitionVO.setIsPubWithPromptTxtToRevsd(recognition
						.getIsPubWithPromptTxtToRevsd());

				recognitionVOs.add(recognitionVO);
			}
		}
		return recognitionVOs;
	}

	private RecognitionVO prepareRecognitionVO(Recognition recognition) {

		RecognitionVO recognitionVO = new RecognitionVO();
		recognitionVO.setRecId(recognition.getRecId());
		recognitionVO.setDesc(recognition.getDesc());

		recognitionVO.setStartDate(this.dateTostringConv(recognition
				.getStartDate()));

		recognitionVO
				.setEndDate(this.dateTostringConv(recognition.getEndDate()));
		recognitionVO.setQuestion(recognition.getQuestion());
		// 1st five field ok
		recognitionVO.setLocalVersionLastImport(recognition
				.getLocalVersionLastImport());
		recognitionVO.setRecognitionCd(recognition.getRecognitionCd());
		recognitionVO.setProjectId(recognition.getProjectId());
		recognitionVO.setRecognitionExternalId(recognition
				.getRecognitionExternalId());
		recognitionVO.setDtreeExternalId(recognition.getDtreeExternalId());
		// 2nd 10 field ok
		recognitionVO.setStaticTargetId(recognition.getStaticTargetId());
		recognitionVO.setMatchVarNm(recognition.getMatchVarNm());
		recognitionVO.setMatchTarget(recognition.getMatchTarget());
		recognitionVO.setMatchTargetId(recognition.getMatchTargetId());
		recognitionVO.setStaticVarNm(recognition.getStaticVarNm());
		recognitionVO.setStaticVarVal(recognition.getStaticVarVal());
		recognitionVO.setStaticTarget(recognition.getStaticTarget());
		recognitionVO.setRecognitionGroup(recognition.getRecognitionGroup());
		recognitionVO.setRecgGroupId(recognition.getRecgGroupId());
		recognitionVO.setExportGroup(recognition.getExportGroup());
		// 3rd 10 field
		recognitionVO.setExportGroupId(recognition.getExportGroupId());
		recognitionVO.setPromptExp(recognition.getPromptExp());
		recognitionVO.setDescription(recognition.getDescription());
		recognitionVO.setFreeTextDisableIn(recognition.getFreeTextDisableIn());
		recognitionVO.setNotes(recognition.getNotes());
		recognitionVO.setIsValid(recognition.getIsValid());
		recognitionVO.setIsBlocked(recognition.getIsBlocked());
		recognitionVO.setExtraData(recognition.getExtraData());
		recognitionVO.setReferenceId(recognition.getReferenceId());
		recognitionVO.setIsDtreeNode(recognition.getIsDtreeNode());
		// 4th 14 field
		recognitionVO.setDtree(recognition.getDtree());
		recognitionVO
				.setIsErrorRecognition(recognition.getIsErrorRecognition());
		recognitionVO.setMaxInvldRspnsAllwbl(recognition
				.getMaxInvldRspnsAllwbl());
		recognitionVO
				.setContentApprStateCd(recognition.getContentApprStateCd());
		recognitionVO.setNlpApprStateCd(recognition.getNlpApprStateCd());
		recognitionVO.setCustomStatus(recognition.getCustomStatus());
		recognitionVO.setCustomStatusId(recognition.getCustomStatusId());
		recognitionVO.setGlobalId(recognition.getGlobalId());
		recognitionVO.setSourceId(recognition.getSourceId());
		recognitionVO.setExportGroupId(recognition.getExportGroupId());
		recognitionVO.setRecognitionType(recognition.getRecognitionType());
		recognitionVO.setRecognitionTypeId(recognition.getRecognitionTypeId());
		recognitionVO.setAccuracyMethod(recognition.getAccuracyMethod());
		recognitionVO.setAccuracyMethodId(recognition.getAccuracyMethodId());
		// 5th 16 field
		recognitionVO.setRecognitionDataMaps(recognition
				.getRecognitionDataMaps());
		recognitionVO.setRecgNotesAttachments(recognition
				.getRecgNotesAttachments());
		recognitionVO.setRecognitionAlternates(recognition
				.getRecognitionAlternates());
		recognitionVO
				.setRecognitionScripts(recognition.getRecognitionScripts());
		recognitionVO.setAnswerLinks(recognition.getAnswerLinks());
		recognitionVO.setConditionLinks(recognition.getConditionLinks());
		recognitionVO.setRecognitionAttrPrompts(recognition
				.getRecognitionAttrPrompts());
		recognitionVO.setReExportFlag(recognition.getReExportFlag());
		recognitionVO.setProjectInternalId(recognition.getProjectInternalId());
		;
		recognitionVO.setDisambiguationPrompt(recognition
				.getDisambiguationPrompt());
		recognitionVO.setIsPubWithContentAppr(recognition
				.getIsPubWithContentAppr());
		recognitionVO.setIsPubWithNlpAppr(recognition.getIsPubWithNlpAppr());
		recognitionVO
				.setIsPubWithCusStatus(recognition.getIsPubWithCusStatus());
		recognitionVO.setIsPubWithCondPattReqd(recognition
				.getIsPubWithCondPattReqd());
		recognitionVO.setIsPubWithAnsReqd(recognition
				.getIsPubWithCondPattReqd());
		recognitionVO.setIsPubWithPromptTxtToRevsd(recognition
				.getIsPubWithPromptTxtToRevsd());
		return recognitionVO;
	}

	private RecognitionVO prepareRecognitionVOFromRecognition(
			Recognition recognition, RecognitionVO recognitionVO) {

		recognitionVO.setRecId(recognition.getRecId());
		recognitionVO.setDesc(recognition.getDesc());

		recognitionVO.setStartDate(this.dateTostringConv(recognition
				.getStartDate()));

		recognitionVO
				.setEndDate(this.dateTostringConv(recognition.getEndDate()));
		recognitionVO.setQuestion(recognition.getQuestion());
		// 1st five field ok
		recognitionVO.setLocalVersionLastImport(recognition
				.getLocalVersionLastImport());
		recognitionVO.setRecognitionCd(recognition.getRecognitionCd());
		recognitionVO.setProjectId(recognition.getProjectId());
		recognitionVO.setRecognitionExternalId(recognition
				.getRecognitionExternalId());
		recognitionVO.setDtreeExternalId(recognition.getDtreeExternalId());
		// 2nd 10 field ok
		recognitionVO.setStaticTargetId(recognition.getStaticTargetId());
		recognitionVO.setMatchVarNm(recognition.getMatchVarNm());
		recognitionVO.setMatchTarget(recognition.getMatchTarget());
		recognitionVO.setMatchTargetId(recognition.getMatchTargetId());
		recognitionVO.setStaticVarNm(recognition.getStaticVarNm());
		recognitionVO.setStaticVarVal(recognition.getStaticVarVal());
		recognitionVO.setStaticTarget(recognition.getStaticTarget());
		recognitionVO.setRecognitionGroup(recognition.getRecognitionGroup());
		recognitionVO.setRecgGroupId(recognition.getRecgGroupId());
		recognitionVO.setExportGroup(recognition.getExportGroup());
		// 3rd 10 field
		recognitionVO.setExportGroupId(recognition.getExportGroupId());
		recognitionVO.setPromptExp(recognition.getPromptExp());
		recognitionVO.setDescription(recognition.getDescription());
		recognitionVO.setFreeTextDisableIn(recognition.getFreeTextDisableIn());
		recognitionVO.setNotes(recognition.getNotes());
		recognitionVO.setIsValid(recognition.getIsValid());
		recognitionVO.setIsBlocked(recognition.getIsBlocked());
		recognitionVO.setExtraData(recognition.getExtraData());
		recognitionVO.setReferenceId(recognition.getReferenceId());
		recognitionVO.setIsDtreeNode(recognition.getIsDtreeNode());
		// 4th 14 field
		recognitionVO.setDtree(recognition.getDtree());
		recognitionVO
				.setIsErrorRecognition(recognition.getIsErrorRecognition());
		recognitionVO.setMaxInvldRspnsAllwbl(recognition
				.getMaxInvldRspnsAllwbl());
		recognitionVO
				.setContentApprStateCd(recognition.getContentApprStateCd());
		recognitionVO.setNlpApprStateCd(recognition.getNlpApprStateCd());
		recognitionVO.setCustomStatus(recognition.getCustomStatus());
		recognitionVO.setCustomStatusId(recognition.getCustomStatusId());
		recognitionVO.setGlobalId(recognition.getGlobalId());
		recognitionVO.setSourceId(recognition.getSourceId());
		recognitionVO.setExportGroupId(recognition.getExportGroupId());
		recognitionVO.setRecognitionType(recognition.getRecognitionType());
		recognitionVO.setRecognitionTypeId(recognition.getRecognitionTypeId());
		recognitionVO.setAccuracyMethod(recognition.getAccuracyMethod());
		recognitionVO.setAccuracyMethodId(recognition.getAccuracyMethodId());
		// 5th 16 field
		recognitionVO.setRecognitionDataMaps(recognition
				.getRecognitionDataMaps());
		recognitionVO.setRecgNotesAttachments(recognition
				.getRecgNotesAttachments());
		recognitionVO.setRecognitionAlternates(recognition
				.getRecognitionAlternates());
		recognitionVO
				.setRecognitionScripts(recognition.getRecognitionScripts());
		recognitionVO.setAnswerLinks(recognition.getAnswerLinks());
		recognitionVO.setConditionLinks(recognition.getConditionLinks());
		recognitionVO.setRecognitionAttrPrompts(recognition
				.getRecognitionAttrPrompts());
		recognitionVO.setReExportFlag(recognition.getReExportFlag());
		recognitionVO.setProjectInternalId(recognition.getProjectInternalId());
		;
		recognitionVO.setDisambiguationPrompt(recognition
				.getDisambiguationPrompt());
		recognitionVO.setIsPubWithContentAppr(recognition
				.getIsPubWithContentAppr());
		recognitionVO.setIsPubWithNlpAppr(recognition.getIsPubWithNlpAppr());
		recognitionVO
				.setIsPubWithCusStatus(recognition.getIsPubWithCusStatus());
		recognitionVO.setIsPubWithCondPattReqd(recognition
				.getIsPubWithCondPattReqd());
		recognitionVO.setIsPubWithAnsReqd(recognition
				.getIsPubWithCondPattReqd());
		recognitionVO.setIsPubWithPromptTxtToRevsd(recognition
				.getIsPubWithPromptTxtToRevsd());
		return recognitionVO;
	}

	@Override
	public void addRecognationByDozer(RecognitionVO recognitionVO) {
		Recognition recognition = DozerUtil.xmlConfig().map(recognitionVO,
				Recognition.class, "recognition");
		this.recognitionDao.addRecognationByDozer(recognition);
		DozerUtil.xmlConfig().map(recognition, recognitionVO, "recognition");
	}

	@Override
	public List<RecognitionVO> listRecognitionByDozer() {
		List<Recognition> recognitions = this.recognitionDao
				.listRecognitionByDozer();
		List<RecognitionVO> recognitionVOList = DozerHelper.map(
				DozerUtil.xmlConfig(), recognitions, RecognitionVO.class,
				"recognition");
		return recognitionVOList;
	}

	@Override
	public List<RecognitionVO> listRecognitionByManual() {
		List<Recognition> recognitions = this.recognitionDao
				.listRecognitionByManual();
		List<RecognitionVO> list = prepareListofVO(recognitions);
		return list;

	}

	public String dateTostringConv(Date date) {
		if (date != null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(date);
		}
		return null;

	}

	public Date stringToDateConv(String date) {
		if (date != null) {

			try {

				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date dateType = (Date) formatter.parse(date);
				return dateType;
			} catch (ParseException e) {
				return new Date("yyyy-MM-dd");
			}
		}
		return new Date();
	}

	@Override
	public void addRecognationByManual(RecognitionVO recognitionVO) {
		Recognition recognition = prepareRecognitionVO(recognitionVO);
		this.recognitionDao.addRecognationByManual(recognition);
		recognitionVO = prepareRecognitionVOFromRecognition(recognition,
				recognitionVO);

	}

	@Override
	public RecognitionVO getRecVoByRecIdByManual(Integer recId) {

		Recognition recognition = this.recognitionDao
				.getRecVoByRecIdByManual(recId);
		RecognitionVO recognitionVO = prepareRecognitionVO(recognition);

		return recognitionVO;

	}

	@Override
	public RecognitionVO getRecVoByRecIdByDozer(Integer recId) {
		RecognitionVO recognitionVO = DozerUtil.xmlConfig().map(
				this.recognitionDao.getRecVoByRecId(recId),
				RecognitionVO.class, "recognition");

		return recognitionVO;
	}

}
