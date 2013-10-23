package com.cv.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class AnswerController {

	@RequestMapping(value = "addOrUpdateAnswer", method = RequestMethod.GET)
	public String getAnswerPage() {
		return "addOrUpdateAnswer";
	}

	@RequestMapping(value = "answerList", method = RequestMethod.GET)
	public String getAnswerListPage() {
		return "answerList";
	}
}
