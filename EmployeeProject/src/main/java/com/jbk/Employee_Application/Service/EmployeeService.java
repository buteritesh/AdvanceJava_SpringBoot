package com.jbk.Employee_Application.Service;

import java.util.List;

import com.jbk.Employee_Application.Entity.Employee;

public interface EmployeeService {
	//ArrayList
	
	public String addEmployee(Employee employee);
	
	public Employee retrieveEmployee(Integer id);

	public List<Employee> getAllEmployee();

	public void deleteById(Integer id);

	public Object updateEmployee(Employee emp);

	public List<Employee> sortOnEid();

	List<Employee> sortOnName();

	public List<Employee> sortOnSalary();

}
