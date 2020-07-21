package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;

public class BookMain {

	public static void main(String[] args) {
		Book book=new Book();
		Scanner scanner=new Scanner(System.in);
		book.input(101,"Macbeth", 100);
		System.out.println(book);
		int copies;
		System.out.println("Enter the number of copies to be purcahsed :: ");
		copies=scanner.nextInt();	
		System.out.println("Total amount to be paid ::"+book.purchase(copies));
	}

}
