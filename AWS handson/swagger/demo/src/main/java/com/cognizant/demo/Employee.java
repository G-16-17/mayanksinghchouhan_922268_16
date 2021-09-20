package com.cognizant.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Employee class which is acting as the DTO")
public class Employee {
	@Id
	private int id;
	@ApiModelProperty(notes = "names should contain only alphabets")
	private String name;
	private String gender;
	@ApiModelProperty(notes = "ages should be between 18 and 60")
	private int age;
	private double salary;
}
