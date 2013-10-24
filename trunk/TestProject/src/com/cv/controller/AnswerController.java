package com.cv.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.service.AnswerService;
import com.cv.vo.AnswerVO;
import com.cv.vo.ConditionVO;
import com.cv.vo.RecognitionVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "addAnswer", method = RequestMethod.GET)
	public String getAnswerPage(ModelMap modelMap) {
		AnswerVO answerVO = new AnswerVO();
		this.answerService.addOrEditAnswer(answerVO);
		modelMap.addAttribute("answerVo", answerVO);
		return "addAnswer";

	}

	@RequestMapping(value = "addAnswer", method = RequestMethod.POST)
	public String postAnswerPage(@ModelAttribute("answerVO") AnswerVO answerVO) {
		this.answerService.addOrEditAnswer(answerVO);
		return "redirect:answerList.html?msg=Answer added successfully";

	}

	@RequestMapping(value = "answerList", method = RequestMethod.GET)
	public String getAnswerListPage(ModelMap modelMap) {
		// modelMap.addAttribute("answerList",
		// this.answerService.getAnswerVoList());
		return "answerList";

	}

	@RequestMapping(value = "getAnswerListForGrid.html", method = RequestMethod.GET)
	public @ResponseBody
	String getAnswerListForGrid() {

		List<AnswerVO> answerVOs = this.answerService.getAnswerVoList();
		Type listType = new TypeToken<List<AnswerVO>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(answerVOs, listType);
		return json;
	}
}
