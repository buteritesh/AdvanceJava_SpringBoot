package com.jbk.Employee_Application.DAO;

import java.util.List;

import com.jbk.Employee_Application.Entity.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	

	public List<Employee> getAllEmployee();


	void deleteById(Integer id);


	public Object updateEmployee(Employee emp);

}
