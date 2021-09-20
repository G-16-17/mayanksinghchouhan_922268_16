package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmplyeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(long id);

}
