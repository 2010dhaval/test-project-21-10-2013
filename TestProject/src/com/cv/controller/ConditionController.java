package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cv.service.ConditionService;
import com.cv.vo.ConditionVO;
import com.cv.vo.RecognitionVO;

@Controller
public class ConditionController {

	@Autowired
	private ConditionService conditionService;

	@RequestMapping(value = "addCondition", method = RequestMethod.GET)
	public String getConditionPage(ModelMap modelMap) {
		ConditionVO conditionVO = new ConditionVO();
		this.conditionService.addCondition(conditionVO);
		modelMap.addAttribute("conditionVo", conditionVO);
		return "addCondition";

	}

	@RequestMapping(value = "addCondition", method = RequestMethod.POST)
	public String postConditionPage(
			@ModelAttribute("conditionVO") ConditionVO conditionVO) {
		this.conditionService.addCondition(conditionVO);
		return "redirect:conditionList.html?msg=Condition added successfully";

	}

	@RequestMapping(value = "conditionList", method = RequestMethod.GET)
	public String getConditionListPage(ModelMap modelMap) {
		modelMap.addAttribute("conditionList",
				this.conditionService.listCondition());
		return "conditionList";

	}
}
