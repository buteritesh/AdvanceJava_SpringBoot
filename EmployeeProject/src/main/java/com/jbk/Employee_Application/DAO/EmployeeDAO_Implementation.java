package com.jbk.Employee_Application.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import com.jbk.Employee_Application.Entity.Employee;

@Repository
public class EmployeeDAO_Implementation implements EmployeeDAO {
	
	List<Employee> l=new ArrayList<>();

	
	@Override
	public void addEmployee(Employee employee) {
		
		l.add(employee);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return l;
	}
	
	@Override
	public void deleteById(Integer id)
	{
		Iterator<Employee> itr=l.iterator();
		
		while(itr.hasNext())
		{
			Employee e=itr.next();
			if(e.getId()==id)
			{
				itr.remove();
			}
		}
	}


	@Override
	public Object updateEmployee(Employee emp) {

		ListIterator<Employee> ltr=l.listIterator();
		
		while(ltr.hasNext())
		{
			Employee e=ltr.next();
			
			if(e.getId()==emp.getId())
			{
				ltr.set(emp);
				return e;
			}
		}
		return "Employee not found";
		
	}

}
