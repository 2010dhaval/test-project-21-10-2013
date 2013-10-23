package com.cv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.service.RecognitionService;
import com.cv.vo.RecognitionVO;
import com.google.gson.Gson;

@Controller
public class RecognitionController {

	@Autowired
	private RecognitionService recognitionService;

	@RequestMapping(value = "addRecognition", method = RequestMethod.GET)
	public String getRecognitionPage(ModelMap modelMap) {
		RecognitionVO recognitionVO = new RecognitionVO();
		this.recognitionService.addRecognition(recognitionVO);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "addRecognition";

	}

	@RequestMapping(value = "addRecognition", method = RequestMethod.POST)
	public String postRecognitionPage(
			@ModelAttribute("recognitionVO") RecognitionVO recognitionVO) {
		this.recognitionService.addRecognition(recognitionVO);
		return "redirect:recognitionList.html?msg=Recocondition added successfully";

	}

	@RequestMapping(value = "recognitionList", method = RequestMethod.GET)
	public String getRecognitionListPage(ModelMap modelMap) {
		modelMap.addAttribute("recognitionVOList",
				this.recognitionService.listRecognition());
		return "recognitionList";
	}
	
	@RequestMapping(value = "getRecognitionListForGrid.html", method = RequestMethod.GET)
	public @ResponseBody String getRecognitionListForGrid() {
		
		//List<RecognitionVO> recognitionVOs = recognitionService.listRecognition();
		
		//Gson gson = new Gson();
		//String json = 
		return	new Gson().toJson(recognitionService.listRecognition());
		
		//return json;
	}
}
