package com.cv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cv.dao.EmployeeDao;
import com.cv.model.Employee;
import com.cv.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployeeList() {
		return this.employeeDao.getEmployeeList();
	}

}
