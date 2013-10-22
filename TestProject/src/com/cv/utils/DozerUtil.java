package com.cv.utils;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;



public class DozerUtil {
	
	
	public static Mapper xmlConfig(){
		List<String> list = new ArrayList<String>();
		list.add("dozerMappingAnswer.xml");
		list.add("dozerMappingAnswerLink.xml");
		list.add("dozerMappingCondition.xml");
		list.add("dozerMappingConditionLink.xml");
		list.add("dozerMappingRecognition.xml");
		return new DozerBeanMapper(list);
	}
	
}