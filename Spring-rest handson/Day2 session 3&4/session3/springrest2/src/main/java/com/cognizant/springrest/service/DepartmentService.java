package com.cognizant.springrest.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.Department;
import com.cognizant.springrest.dao.DepartmentDao;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;
	public List<Department> getAllDepartments() {
		
		return departmentDao.getAllDepartments();
	}

	
}