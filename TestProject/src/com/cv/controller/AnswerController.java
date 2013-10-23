package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cv.service.AnswerService;
import com.cv.vo.AnswerVO;
import com.cv.vo.ConditionVO;

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
		System.out.println("ssssss");
		modelMap.addAttribute("answerList",
				this.answerService.getAnswerVoList());
		return "answerList";

	}
}
