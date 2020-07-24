package com.montran.main;

import java.io.File;
import java.util.Scanner;

import com.montran.util.FileInputStreamUtil;
import com.montran.util.FileOutputStreamUtil;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);	
		int employeeId;
		String name;
		double salary;
		String filePath;
		File file=null;
		String data;
		int choice;
		String continueChoice;
		byte[] fileData;
		FileInputStreamUtil fileInputStreamUtil=new FileInputStreamUtil();
		FileOutputStreamUtil fileOutputStreamUtil=new FileOutputStreamUtil();
		do
		{
		System.out.println("======MENU======");
		System.out.println("1.Add Employee data into file");
		System.out.println("2.Read Employee data from file");
		System.out.println("3.Exit");
		System.out.println("Enter your choice::");
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
			scanner.nextLine();
			
			System.out.println("Enter path of file to store data of employee::");
			filePath = scanner.nextLine();
			file = new File(filePath);
			
			data=employeeId+"  "+name+"  "+salary;
			fileOutputStreamUtil.writeDataIntoFile(file, data.getBytes());
			System.out.println("Data written successfully");
			break;
		case 2:
			System.out.println("Id  Name  Salary");
			fileData=fileInputStreamUtil.getFileData(file);
				for (byte b : fileData) {
					System.out.print((char) b);
				}
			System.out.println();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		System.out.println("Do you want to continue::(yes-no)");
		continueChoice=scanner.next();
		}while(continueChoice.equals("yes"));
		System.out.println("Thankyou");
		
	}
}
