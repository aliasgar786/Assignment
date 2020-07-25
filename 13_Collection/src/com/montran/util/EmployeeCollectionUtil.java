package com.montran.util;

import java.util.ArrayList;
import java.util.List;
import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {
	private List<Employee> employeeList=new ArrayList<>();
	
	public EmployeeCollectionUtil() {

	}
	
	public boolean addNewEmployee(Employee employee) {
		if(employeeList.add(employee))
			return true;
		else
			return false;
	}
	
	public boolean addAllEmployees(Employee[] employee) {
		for (Employee employee2 : employee) {
			addNewEmployee(employee2);
		}
		return true;
	}
	
	public boolean updateEmployeeSalary(int employeeId ,  double newSalary) {
		for (Employee employee : employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employee.setSalary(newSalary);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteEmployee(int employeeId) {
		for (Employee employee:employeeList) {
			if (employee.getEmployeeId() == employeeId) {
				employeeList.remove(employee);
				return true;
			}
		}
		return false;
	}
	
	public Employee getEmployeeByEmployeeId(int employeeId) {
		for (Employee employee : employeeList) {
			if (employee != null) {
				if (employee.getEmployeeId() == employeeId)
					return employee;
			}
		}
		return null;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeList;
	}
}
