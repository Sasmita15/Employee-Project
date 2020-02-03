
package com.project.employee.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.employee.modal.Employee;
import com.project.employee.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public void setEmployerService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity createEmployeeRecord(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		return new ResponseEntity("Employee record saved successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retriveEmployee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> listOfAllEmployee()
	{
		List<Employee> employeeRecord = employeeService.listOfEmployee();
		if (employeeRecord.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employeeRecord, HttpStatus.OK);
	}
}