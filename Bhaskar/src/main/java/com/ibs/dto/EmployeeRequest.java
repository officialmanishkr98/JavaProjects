package com.ibs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	
	private String name;
	
	private Long salary;
	
	private String email;
	
	private String departmentName;
}
