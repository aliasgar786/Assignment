package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Account;
import com.montran.pojo.Current;
import com.montran.pojo.Savings;

public class AccountMainV7 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int accountNumber;
		String name;
		double balance;
		int transactionChoice;
		int amount;
		boolean result;
		String continueChoice;
		boolean isSalary=false;
		int accountChoice;
		double overDraftBalance=0,overDraftLimit=0;
		Account account = null;
		System.out.println(" Hello Welcome to ABC Bank");
		
		System.out.println("====MENU====");
		System.out.println("1.Savings");
		System.out.println("2.Current");
		
		System.out.println("Enter choice:");
		accountChoice=scanner.nextInt();
		
		System.out.println("Enter account Number:");
		accountNumber=scanner.nextInt();
		
		System.out.println("Enter name:");
		name=scanner.next();
		
		System.out.println("Enter balance:");
		balance=scanner.nextDouble();
		
		switch(accountChoice) {
			case 1:
				System.out.println("Do you want to salary account(true-false)");
				isSalary=scanner.nextBoolean();
				account = new Savings(accountNumber, name, balance, isSalary);
				break;
			case 2:
				System.out.println("Enter overDraft Balance ::");
				overDraftBalance=scanner.nextDouble();
				overDraftLimit=overDraftBalance;
				account=new Current(accountNumber, name, balance, overDraftBalance,overDraftLimit);
				break;
		}
		
		System.out.println("Your account is opened successfully");
		System.out.println(account);
		
		do
		{
		System.out.println("=====MENU====");
		System.out.println("1.Withdraw");
		System.out.println("2.Deposit");
		System.out.println("3.Print Balance");
		System.out.println("Enter your transaction choice:");
		transactionChoice=scanner.nextInt();
		
		switch (transactionChoice) {
		case 1:
			System.out.println("Enter amount to withdraw:");
			amount=scanner.nextInt();
			result=account.withdraw(amount);
			if(result)
				System.out.println("Transaction success");
			else
				System.out.println("Transaction failed");
			break;
		case 2:
			System.out.println("Enter amount to deposit:");
			amount=scanner.nextInt();
			result=account.deposit(amount);
			if(result)
				System.out.println("Transaction success");
			else
				System.out.println("Transaction failed");
			break;
		case 3:
			System.out.println(account);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		System.out.println("Do you want to continue?");
		continueChoice=scanner.next();
		
		}while(continueChoice.equals("yes"));
		System.out.println("Thank You For Banking With Us !!");
		scanner.close();
	}

}
