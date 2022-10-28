package com.ibs.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.ibs.department.Department;
import com.ibs.dto.EmployeeRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Long salary;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name = "department_id")
	public Department department;
	
	public Employee(EmployeeRequest employeeRequest){
		this.name=employeeRequest.getName();
	}
}
