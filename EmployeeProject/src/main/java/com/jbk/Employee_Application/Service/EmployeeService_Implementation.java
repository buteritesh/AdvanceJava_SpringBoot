package com.jbk.Employee_Application.Service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Employee_Application.DAO.EmployeeDAO;
import com.jbk.Employee_Application.Entity.Employee;

@Service
public class EmployeeService_Implementation implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public String addEmployee(Employee employee) {

		employeeDAO.addEmployee(employee);

		return "Record Saved...";

	}

	@Override
	public Employee retrieveEmployee(Integer id) {

		List<Employee> l = employeeDAO.getAllEmployee();

		for (Employee e : l) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;

	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeDAO.getAllEmployee();

	}

	@Override
	public void deleteById(Integer id) {

		employeeDAO.deleteById(id);
	}

	@Override
	public Object updateEmployee(Employee emp) {

		return employeeDAO.updateEmployee(emp);
	}

	@Override
	public List<Employee> sortOnEid() {
		List<Employee> list = employeeDAO.getAllEmployee();

		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {

				return e1.getId().compareTo(e2.getId());
			}
		});
		return list;
	}

	@Override
	public List<Employee> sortOnName() {
		List<Employee> list = employeeDAO.getAllEmployee();

		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		return list;

	}

	@Override
	public List<Employee> sortOnSalary() {

		List<Employee> list = employeeDAO.getAllEmployee();

		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getSalary().compareTo(e2.getSalary());
			}
		});
		return list;
	}

}
