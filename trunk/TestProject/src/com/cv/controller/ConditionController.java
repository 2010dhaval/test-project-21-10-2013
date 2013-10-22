package com.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConditionController {

	
	@RequestMapping(value = "addCondition", method = RequestMethod.GET)
	public String getConditionPage() {
		return "addCondition";

	}

	@RequestMapping(value = "conditionList", method = RequestMethod.GET)
	public String getConditionListPage() {
		return "conditionList";

	}
}
