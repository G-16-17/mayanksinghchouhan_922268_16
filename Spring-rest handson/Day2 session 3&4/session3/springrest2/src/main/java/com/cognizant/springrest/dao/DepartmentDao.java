package com.cognizant.springrest.dao;
import java.util.ArrayList;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springrest.Department;
import com.cognizant.springrest.Employee;

@Component
public class DepartmentDao {

	static ArrayList<Department> DEPARTMENT_LIST;
	
	public DepartmentDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList");
	}

	public List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}