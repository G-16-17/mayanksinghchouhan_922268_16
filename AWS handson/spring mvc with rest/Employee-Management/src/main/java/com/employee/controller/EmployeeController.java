package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;
import com.employee.service.EmplyeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmplyeeService employeeService;
	
	
	
	@GetMapping("/employee")
	public String homePage(Model model) {
		List<Employee> employeeList=employeeService.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "home";
		
	}
	
	@GetMapping("/employee/new")
	public String createStudentForm(Model model) {
		
		// create employee object to hold student form data
		Employee employee=new  Employee();
		model.addAttribute("employee", employee);
		return "empform";
		
	}
	
	@PostMapping("/employee")
	public String saveStudent(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}
	

	@GetMapping("/employee/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employee/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("employee") Employee employee,
			Model model) {
		
		
		Employee existingEmployee=employeeService.getEmployeeById(id);
		existingEmployee.setAge(employee.getAge());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setName(employee.getName());
		existingEmployee.setSalary(employee.getSalary());
		
		
		
		employeeService.saveEmployee(existingEmployee);
		return "redirect:/employee";		
	}
	
	
	
	@GetMapping("/employee/{id}")
	public String deleteStudent(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employee";
	}
	

}
