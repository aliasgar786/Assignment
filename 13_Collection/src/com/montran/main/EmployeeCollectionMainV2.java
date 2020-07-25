package com.montran.main;

import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;

public class EmployeeCollectionMainV2 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int employeeId;
		int newSalary;
		String name;
		double salary;
		Employee employee;
		Employee employeeArray[];
		int choice,numberOfEmployees;
		String continueChoice;
		EmployeeCollectionUtil employeeCollectionUtil = new EmployeeCollectionUtil();
		List<Employee> employeeList;
		
		do
		{
			employeeList=employeeCollectionUtil.getAllEmployees();
			for (Employee employee2 : employeeList) {
				if (employee2!=null) 
					System.out.println(employee2.getEmployeeId() + "\t" + employee2.getName() + "\t" + employee2.getSalary());
			}
			
			System.out.println("=====MENU====");
			System.out.println("1.Add Single Employee");
			System.out.println("2.Add multiple Employees");
			System.out.println("3.Update existing Employee Salary");
			System.out.println("4.Delete Existing Employee");
			System.out.println("5.Print Single Employee details");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			choice=scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter Employee Id::");
				employeeId=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Employee name::");
				name=scanner.nextLine();
				System.out.println("Enter Employee Salary::");
				salary=scanner.nextDouble();
				employee=new Employee(employeeId, name, salary);
				if(employeeCollectionUtil.addNewEmployee(employee))
					System.out.println("Employee details added successfully");
				else
					System.out.println("Failed to add Employee details");
				break;
				
			case 2:
				System.out.println("How many Employees do you want to add ?");
				numberOfEmployees=scanner.nextInt();

					employeeArray=new Employee[numberOfEmployees];
					for (int i = 0; i < numberOfEmployees; i++) {
						
						System.out.println("Enter Employee Id::");
						employeeId=scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter Employee name::");
						name=scanner.nextLine();
						System.out.println("Enter Employee Salary::");
						salary=scanner.nextDouble();
						employee=new Employee(employeeId, name, salary);
						employeeArray[i]=employee;
					}
					employeeCollectionUtil.addAllEmployees(employeeArray);
					System.out.println("Employees added successfully");
				
				break;
				
			case 3:
				System.out.println("Enter Employee Id to update salary::");
				employeeId=scanner.nextInt();
				employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if(employee!=null) {
					System.out.println(employee);
					System.out.println("Enter New Employee Salary::");
					newSalary=scanner.nextInt();
					if(employeeCollectionUtil.updateEmployeeSalary(employeeId, newSalary))
						System.out.println("Employee Salary successfully updated");
					else
						System.out.println("Employee salary update failed");
				}
				else
					System.out.println("Employee not found !! Invalid Employee Id");
				break;
				
			case 4:
				System.out.println("Enter Employee Id to delete::");
				employeeId=scanner.nextInt();
				employee=employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if(employee!=null) {
					System.out.println(employee);
					if(employeeCollectionUtil.deleteEmployee(employeeId))
						System.out.println("Employee deleted");
				}
				else
					System.out.println("Employee not found !! Invalid Employee Id");
				break;
				
			case 5:
				System.out.println("Enter EmployeeId::");
				employeeId = scanner.nextInt();
				employee = employeeCollectionUtil.getEmployeeByEmployeeId(employeeId);
				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("Employee not found !! Invalid Employee Id");
				break;
				
			case 6:
				System.out.println("Thank You!!");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice");
			}
			System.out.println("Do you want to continue:(yes-no)");
			continueChoice=scanner.next();
		}while(continueChoice.equals("yes"));
		System.out.println("Thank you");
		scanner.close();
	}

}
