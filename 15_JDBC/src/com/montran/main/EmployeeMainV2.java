package com.montran.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeDatabaseUtil;

public class EmployeeMainV2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "montran";
		String password = "montran";
		String sql = "";
		ResultSet resultSet;
		PreparedStatement preparedStatement;
		Employee employee;
		Scanner scanner = new Scanner(System.in);
		int employeeId;
		int newSalary;
		String name;
		double salary;
		Employee employeeArray[];
		int choice, numberOfEmployees;
		String continueChoice;
		List<Employee> employeeList;
		EmployeeDatabaseUtil employeeDatabaseUtil = new EmployeeDatabaseUtil();

		try {
			Class.forName(driver);
			System.out.println("Driver loaded successfully");

			Connection connection = DriverManager.getConnection(url, user, password);
			if (connection != null) {
				System.out.println("Connection success!!");
				do {
					
					sql="select * from employee_master order by employee_id";
					preparedStatement=connection.prepareStatement(sql);
					resultSet = employeeDatabaseUtil .getAllEmployees(connection);
					
					while (resultSet.next()) {
						System.out.println("Employee Id::"+resultSet.getInt("employee_id"));
						System.out.println("Employee name::"+resultSet.getString("name"));
						System.out.println("Salary::"+resultSet.getDouble("salary"));
						System.out.println("------------------------------------------");
						
					}

					System.out.println("=====MENU====");
					System.out.println("1.Add Single Employee");
					System.out.println("2.Add multiple Employees");
					System.out.println("3.Update existing Employee Salary");
					System.out.println("4.Delete Existing Employee");
					System.out.println("5.Print Single Employee details");
					System.out.println("6.Exit");
					System.out.println("Enter your choice:");
					choice = scanner.nextInt();

					switch (choice) {
					case 1:
						System.out.println("Enter Employee Id::");
						employeeId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter Employee name::");
						name = scanner.nextLine();
						System.out.println("Enter Employee Salary::");
						salary = scanner.nextDouble();
						employee = new Employee(employeeId, name, salary);
						
						if (employeeDatabaseUtil .addNewEmployee(employee,connection)) {
							System.out.println("Employee details added successfully to database");
						}
						else
							System.out.println("Failed to add Employee details");
						break;

					case 2:
						System.out.println("How many Employees do you want to add ?");
						numberOfEmployees = scanner.nextInt();

						employeeArray = new Employee[numberOfEmployees];
						for (int i = 0; i < numberOfEmployees; i++) {

							System.out.println("Enter Employee Id::");
							employeeId = scanner.nextInt();
							scanner.nextLine();
							System.out.println("Enter Employee name::");
							name = scanner.nextLine();
							System.out.println("Enter Employee Salary::");
							salary = scanner.nextDouble();
							employee = new Employee(employeeId, name, salary);
							employeeArray[i] = employee;
						}
						employeeDatabaseUtil.addAllEmployees(employeeArray,connection);
						System.out.println("Employees added successfully");

						break;

					case 3:
						System.out.println("Enter Employee Id to update salary::");
						employeeId = scanner.nextInt();
						System.out.println("Enter New Employee Salary::");
						newSalary = scanner.nextInt();
							if (employeeDatabaseUtil.updateEmployeeSalary(employeeId, newSalary,connection))
								System.out.println("Employee Salary successfully updated");
							else
								System.out.println("Employee salary update failed, employee Id not found");
						break;

					case 4:
						System.out.println("Enter Employee Id to delete::");
						employeeId = scanner.nextInt();
						
							if (employeeDatabaseUtil.deleteEmployee(employeeId,connection))
								System.out.println("Employee deleted");
							else
								System.out.println("Employee not found");
						break;

					case 5:
						System.out.println("Enter EmployeeId::");
						employeeId = scanner.nextInt();
						
						if (employeeDatabaseUtil.getEmployeeByEmployeeId(employeeId,connection)) {
							System.out.println("Employee Found");
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
					continueChoice = scanner.next();
				} while (continueChoice.equals("yes"));
				System.out.println("Thank you");
				scanner.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
