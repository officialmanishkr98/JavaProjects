package com.ibs.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.department.Department;
import com.ibs.department.DepartmentRepository;
import com.ibs.dto.EmployeeRequest;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@PostMapping("")
	public Employee saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		Department department = new Department();
		
		employee.setName(employeeRequest.getName());
		employee.setSalary(employeeRequest.getSalary());
		employee.setEmail(employeeRequest.getEmail());
		
		department.setDepartmentName(employeeRequest.getDepartmentName());
		
		Department dep = departmentRepository.save(department);
		
		employee.setDepartment(dep);
		
		Employee emp = employeeRepo.save(employee);
		
		return emp;
	}
	
	@GetMapping("")
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}
}
