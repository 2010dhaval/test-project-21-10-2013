package com.cv.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.codehaus.jackson.map.annotate.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.model.ConditionLink;
import com.cv.service.ConditionLinkService;
import com.cv.service.RecognitionService;
import com.cv.vo.ConditionLinkVO;
import com.cv.vo.JqGridData;
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
		RecognitionVO recognitionVO = new RecognitionVO();
		recognitionVO.setRecId(recId);
		this.recognitionService.addRecognition(recognitionVO);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "addRecognition";

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
			@ModelAttribute("conditionLinkVO") ConditionLinkVO conditionLinkVO,ModelMap modelMap) {
		this.conditionLinkService.addConditionLink(conditionLinkVO);
		modelMap.addAttribute("recId", conditionLinkVO.getRecognition().getRecId());
		return "success";
	}
}
