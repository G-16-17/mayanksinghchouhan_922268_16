package com.cognizant.ormlearn.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Department;

@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
