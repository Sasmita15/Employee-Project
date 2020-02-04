package com.project.employee;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.employee.modal.Employee;
import com.project.employee.repository.EmployeeRepository;
import com.project.employee.services.EmployeeService;
 
@RunWith(MockitoJUnitRunner.class) 
public class EmployeeApplicationTests {
     
    @InjectMocks
    EmployeeService manager;
     
    @Mock
    EmployeeRepository dao;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
     
    @Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "John", "Engineer", "8745756768", "howtodoinjava@gmail.com"
        		, "Mumbai", "Dadra", "645678", "developer", "Type1", "45546");
        Employee empTwo = new Employee(2, "John", "Engineer", "8745756768", "howtodoinjava@gmail.com"
        		, "Mumbai", "Dadra", "645678", "developer", "Type1", "45546");
        Employee empThree = new Employee(3, "John", "Engineer", "8745756768", "howtodoinjava@gmail.com"
        		, "Mumbai", "Dadra", "645678", "developer", "Type1", "45546");
         
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
         
        when(dao.findAll()).thenReturn(list);
         
        //test
        List<Employee> empList = manager.listOfEmployee();
         
        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }
     
    
     
    @Test
    public void createEmployeeTest()
    {
        Employee emp = new Employee(1, "John", "Engineer", "8745756768", "howtodoinjava@gmail.com"
        		, "Mumbai", "Dadra", "645678", "developer", "Type1", "45546");
         
        manager.saveEmployee(emp);
         
        verify(dao, times(1)).save(emp);
    }
}
