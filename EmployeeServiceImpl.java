package com.project.employee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.modal.Employee;
import com.project.employee.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		logger.debug("saveEmployer called");
        return employeeRepository.save(employee);	
	}

	@Override
	public List<Employee> listOfEmployee() {
		logger.debug("listAllEmployers called");
        return (List<Employee>) employeeRepository.findAll();
	}

}
