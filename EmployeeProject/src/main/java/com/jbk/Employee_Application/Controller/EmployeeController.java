package com.jbk.Employee_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Employee_Application.Entity.Employee;
import com.jbk.Employee_Application.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value="/addEmployee")
	public String addEmployee(@RequestBody Employee employee)
	{
		
		return employeeService.addEmployee(employee);
		
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Integer id)
	{
		return employeeService.retrieveEmployee(id);
	}
	
	@GetMapping(value="/getAllEmployee")
	public List<Employee> getAllEmployee()
	{
		List<Employee> l=employeeService.getAllEmployee();
		return l;
		
	}
	
	@DeleteMapping(value="deleteEmployee/{id}")
	public String deleteByID(@PathVariable Integer id)
	{
		employeeService.deleteById(id);
		return "Record Deleted...";
		
	}
	
	@PutMapping(value="updateEmployee")
	public Object updateEmployee(@RequestBody Employee emp)
	{
		Employee employee=(Employee)employeeService.updateEmployee(emp);
		
		if(employee!=null)
		{
			return employee;
		}
		else
		{
			return "Record Updated...";
		}
		
	}
	
	@GetMapping(value="getSortedOnEid")
	public List<Employee> sortOnEid()
	{
		return employeeService.sortOnEid();
		
	}
	
	@GetMapping(value="getSortedOnName")
	public List<Employee> sortOnName()
	{
		return employeeService.sortOnName();
	}
	
	@GetMapping(value="getSortedOnSalary")
	public List<Employee> sortOnSalary()
	{
		return employeeService.sortOnSalary();
	}
	
	

}
