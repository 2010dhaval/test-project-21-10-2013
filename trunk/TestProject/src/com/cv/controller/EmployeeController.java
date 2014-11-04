package com.cv.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cv.model.Employee;
import com.cv.model.JqGridData;
import com.cv.model.JqGridHelper;
import com.cv.service.EmployeeService;
import com.cv.vo.AnswerVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="getEmployeeListPage", method = RequestMethod.GET)
	public String getEmployeeListPage(){
		return "getEmployeeListPage";
	}
	
	@RequestMapping(value="getEmployeeList.html")
	@ResponseBody 
	public String getEmployeeList(){
		JqGridData returnJqGridData = null;
		List<Employee> employeeList = this.employeeService.getEmployeeList();
		//returnJqGridData = JqGridHelper.createJqGridDataObject(employeeList);
		//return returnJqGridData;
		Type listType = new TypeToken<List<Employee>>() {
		}.getType();
		Gson gson = new Gson();
		String json = gson.toJson(employeeList, listType);
		return json;
	}
}
