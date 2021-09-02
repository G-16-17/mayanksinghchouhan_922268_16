package com.cognizant.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springrest.Employee;
import com.cognizant.springrest.service.EmployeeService;
import com.cognizant.springrest.service.Exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}

	@RequestMapping(value="/employees/{id}",method = RequestMethod.PUT)
	public Employee updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
		
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
		employeeService.deleteEmployee(id);
	}

}
