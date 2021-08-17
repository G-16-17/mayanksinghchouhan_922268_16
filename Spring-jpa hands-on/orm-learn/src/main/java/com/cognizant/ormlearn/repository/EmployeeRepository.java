package com.cognizant.ormlearn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Employee;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
