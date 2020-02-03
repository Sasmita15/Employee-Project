package com.project.employee.services;

import java.util.List;

import com.project.employee.modal.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> listOfEmployee();

}
