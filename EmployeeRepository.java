
package com.project.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.employee.modal.Employee;
@RepositoryRestResource
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
}