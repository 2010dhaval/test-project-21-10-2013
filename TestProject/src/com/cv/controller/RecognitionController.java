package com.cv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecognitionController {

	@RequestMapping(value = "addRecognition", method = RequestMethod.GET)
	public String getRecognitionPage() {
		return "addRecognition";

	}

	@RequestMapping(value = "recognitionList", method = RequestMethod.GET)
	public String getRecognitionListPage() {
		return "recognitionList";

	}
}
