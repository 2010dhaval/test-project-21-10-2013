package com.cv.controller;

import java.lang.reflect.Type;
import java.util.Date;
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
import com.cv.vo.RecognitionVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class RecControllerDozer {

	@Autowired
	private RecognitionService recognitionService;
	@Autowired
	private ConditionLinkService conditionLinkService;

	@RequestMapping(value = "addRecognationByDozer", method = RequestMethod.GET)
	public String addRecognationByDozer(ModelMap modelMap) {
		RecognitionVO recognitionVO = new RecognitionVO();
		long startTimeAddRecGet=new Date().getTime();
		this.recognitionService.addRecognationByDozer(recognitionVO);
		long endTimeAddRecGet=new Date().getTime();
		long totalGet=endTimeAddRecGet-startTimeAddRecGet;
		modelMap.addAttribute("totalGet", totalGet);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "addRecognationByDozer";
	}

	@RequestMapping(value = "addRecognationByDozer", method = RequestMethod.POST)
	public String postRecognitionPageByDozer(
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
		
		long startTimeAddRecPost=new Date().getTime();
		this.recognitionService.addRecognationByDozer(recognitionVO);
		long endTimeAddRecPost=new Date().getTime();
		long totalPost=endTimeAddRecPost-startTimeAddRecPost;

		return "redirect:recognitionListByDozer.html?timeDiff="+totalPost+"&msg=Recocondition added successfully";

	}

	
	
	@RequestMapping(value = "editRecognitionByDozer", method = RequestMethod.GET)
	public String getEditRecognitionPageByDozer(@RequestParam("recId") Integer recId,
			ModelMap modelMap) {
		long startTimeAddRecGet=new Date().getTime();
		RecognitionVO recognitionVO = this.recognitionService
				.getRecVoByRecIdByDozer(recId);
		long endTimeAddRecGet=new Date().getTime();
		long totalGet=endTimeAddRecGet-startTimeAddRecGet;
		modelMap.addAttribute("totalGet", totalGet);
		modelMap.addAttribute("recognitionVO", recognitionVO);
		return "editRecognitionByDozer";

	}

	@RequestMapping(value = "editRecognitionByDozer", method = RequestMethod.POST)
	public String postEditRecognitionPageByDozer(
			@ModelAttribute("recognitionVO") RecognitionVO recognitionVO) {
		long startTimeAddRecGet=new Date().getTime();
		this.recognitionService.addRecognationByDozer(recognitionVO);
		long endTimeAddRecGet=new Date().getTime();
		long totalGet=endTimeAddRecGet-startTimeAddRecGet;
		return "redirect:recognitionListByDozer.html?timeDiff="+totalGet+"&msg=Recocondition added successfully";

	}
	
	
	
	
	@RequestMapping(value = "recognitionListByDozer", method = RequestMethod.GET)
	public String getRecognitionListPageByDozer(ModelMap modelMap) {
		// this.recognitionService.listRecognition());
		return "recognitionListByDozer";
	}

	@RequestMapping(value = "getRecognitionListForGridByDozer.html", method = RequestMethod.GET)
	public @ResponseBody
	String getRecognitionListForGridByDozer() {
		long startTime=new Date().getTime();
		List<RecognitionVO> recognitionVOs = this.recognitionService
				.listRecognitionByDozer();
		long endtime=new Date().getTime();
		long totalDiff=endtime-startTime;
		
		System.out.println("Time Diff off List (Dozer)="+totalDiff);
		Type listType = new TypeToken<List<RecognitionVO>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(recognitionVOs, listType);
		
		return json;
	}
	


}
