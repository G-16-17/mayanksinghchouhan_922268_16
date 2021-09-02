package com.cognizant.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.Employee;
import com.cognizant.springrest.dao.EmployeeDao;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee(){
		return employeeDao.getAllEmployee();
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
