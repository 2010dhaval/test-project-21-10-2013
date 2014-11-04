package com.cv.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.service.ConditionLinkService;
import com.cv.service.RecognitionService;
import com.cv.vo.ConditionLinkVO;
import com.cv.vo.RecognitionVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class RecognitionController {

	@Autowired
	private RecognitionService recognitionService;
	@Autowired
	private ConditionLinkService conditionLinkService;

	@RequestMapping(value = "addRecognition", method = RequestMethod.GET)
	public String getRecognitionPage(ModelMap modelMap) {
		RecognitionVO recognitionVO = new RecognitionVO();
		this.recognitionService.addRecognition(recognitionVO);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "addRecognition";

	}

	@RequestMapping(value = "editRecognition", method = RequestMethod.GET)
	public String getEditRecognitionPage(@RequestParam("recId") Integer recId,
			ModelMap modelMap) {
		RecognitionVO recognitionVO = this.recognitionService
				.getRecVoByRecId(recId);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "editRecognition";

	}

	@RequestMapping(value = "editRecognition", method = RequestMethod.POST)
	public String postEditRecognitionPage(
			@ModelAttribute("recognitionVO") RecognitionVO recognitionVO) {
		this.recognitionService.addRecognition(recognitionVO);
		return "redirect:recognitionList.html?msg=Recocondition added successfully";

	}

	@RequestMapping(value = "addRecognition", method = RequestMethod.POST)
	public String postRecognitionPage(
			@ModelAttribute("recognitionVO") RecognitionVO recognitionVO) {

		// 1st five field ok
		recognitionVO.setLocalVersionLastImport(1);
		recognitionVO.setRecognitionCd("recTest");
		recognitionVO.setProjectId(1);
		recognitionVO.setRecognitionExternalId(1);
		recognitionVO.setDtreeExternalId(1);
		// 2nd 10 field ok
		recognitionVO.setStaticTargetId(1);
		recognitionVO.setMatchVarNm("test match");
		recognitionVO.setMatchTarget("test tar");
		recognitionVO.setMatchTargetId(1);
		recognitionVO.setStaticVarNm("varman");
		recognitionVO.setStaticVarVal("re");
		recognitionVO.setStaticTarget("tedr");
		recognitionVO.setRecognitionGroup("sssss");
		recognitionVO.setRecgGroupId(1);
		recognitionVO.setExportGroup("gruop");

		// 3rd 10 field
		recognitionVO.setExportGroupId(1);
		recognitionVO.setPromptExp("promy");
		recognitionVO.setDescription("rere");
		recognitionVO.setFreeTextDisableIn('s');
		recognitionVO.setNotes("nnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		recognitionVO.setIsValid('n');
		recognitionVO.setIsBlocked('n');
		recognitionVO.setExtraData("exxxxxxxxxxxxxxxxxxxxxxxxx");
		recognitionVO.setReferenceId("ref");
		recognitionVO.setIsDtreeNode('y');

		// 4th 14 field

		recognitionVO.setDtree("dtree");
		recognitionVO.setIsErrorRecognition('y');
		recognitionVO.setMaxInvldRspnsAllwbl((short) 1);
		recognitionVO.setContentApprStateCd('b');
		recognitionVO.setNlpApprStateCd('n');
		recognitionVO.setCustomStatus("abc");
		recognitionVO.setCustomStatusId(1);
		recognitionVO.setGlobalId("glob id");
		recognitionVO.setSourceId("src id");
		recognitionVO.setExportGroupId(1);
		recognitionVO.setRecognitionType("rec type");
		recognitionVO.setRecognitionTypeId(1);
		recognitionVO.setAccuracyMethod("accu mreht");
		recognitionVO.setAccuracyMethodId(1);

		// 5th 16 field

		recognitionVO.setRecognitionDataMaps("rec date map");
		recognitionVO.setRecgNotesAttachments("notes");
		recognitionVO.setRecognitionAlternates("absdc");
		recognitionVO.setRecognitionScripts("agsgsdhsd");
		recognitionVO.setAnswerLinks("sssss");
		recognitionVO.setConditionLinks("ccc");
		recognitionVO.setRecognitionAttrPrompts("prompt");
		recognitionVO.setReExportFlag('y');
		recognitionVO.setProjectInternalId(1);
		;
		recognitionVO.setDisambiguationPrompt("dis");
		recognitionVO.setIsPubWithContentAppr('n');
		recognitionVO.setIsPubWithNlpAppr('b');
		recognitionVO.setIsPubWithCusStatus('s');
		recognitionVO.setIsPubWithCondPattReqd('p');
		recognitionVO.setIsPubWithAnsReqd('l');
		recognitionVO.setIsPubWithPromptTxtToRevsd('t');

		this.recognitionService.addRecognition(recognitionVO);
		return "redirect:recognitionList.html?msg=Recocondition added successfully";

	}

	@RequestMapping(value = "recognitionList", method = RequestMethod.GET)
	public String getRecognitionListPage(ModelMap modelMap) {
		// modelMap.addAttribute("recognitionVOList",
		// this.recognitionService.listRecognition());
		return "recognitionList";
	}

	@RequestMapping(value = "getRecognitionListForGrid.html", method = RequestMethod.GET)
	public @ResponseBody
	String getRecognitionListForGrid() {
		List<RecognitionVO> recognitionVOs = this.recognitionService
				.listRecognition();
		Type listType = new TypeToken<List<RecognitionVO>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(recognitionVOs, listType);
		return json;
	}

	@RequestMapping(value = "getConditionLinkListForGrid.html", method = RequestMethod.GET)
	public @ResponseBody
	String getConditionLinkListForGrid(@RequestParam("recId") Integer recId) {
		List<ConditionLinkVO> conditionLinks = this.conditionLinkService
				.getConditionLinkList(recId);
		Type listType = new TypeToken<List<ConditionLinkVO>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(conditionLinks, listType);
		return json;
	}

	@RequestMapping(value = "addConditionLink", method = RequestMethod.GET)
	public String getAddConditionLink(@RequestParam("recId") Integer recId,
			ModelMap modelMap) {
		ConditionLinkVO conditionLinkVO = new ConditionLinkVO();
		RecognitionVO recognitionVO = new RecognitionVO();
		recognitionVO.setRecId(recId);
		conditionLinkVO.setRecognition(recognitionVO);
		this.conditionLinkService.addConditionLink(conditionLinkVO);
		modelMap.addAttribute("conditionLinkVO", conditionLinkVO);
		return "addConditionLink";
	}

	@RequestMapping(value = "addConditionLink", method = RequestMethod.POST)
	public String postAddConditionLinkVO(
			@ModelAttribute("conditionLinkVO") ConditionLinkVO conditionLinkVO,
			ModelMap modelMap) {
		this.conditionLinkService.addConditionLink(conditionLinkVO);
		modelMap.addAttribute("recId", conditionLinkVO.getRecognition()
				.getRecId());
		return "success";
	}

	@RequestMapping(value = "editConditionLink", method = RequestMethod.GET)
	public String getEditConditionLink(
			@RequestParam("conditionLinkId") Integer conditionLinkId,
			ModelMap modelMap) {
		ConditionLinkVO conditionLinkVO = this.conditionLinkService
				.getConditionLinkById(conditionLinkId);
		modelMap.addAttribute("conditionLinkVO", conditionLinkVO);
		return "addConditionLink";
	}

	@RequestMapping(value = "editConditionLink", method = RequestMethod.POST)
	public String postEditConditionLink(
			@ModelAttribute("conditionLinkVO") ConditionLinkVO conditionLinkVO,
			ModelMap modelMap) {
		this.conditionLinkService.addConditionLink(conditionLinkVO);
		return "redirect:editRecognition.html?recId="+conditionLinkVO.getRecognition().getRecId()+"&msg=AnserLink added successfully";
	}
}
