package com.montran.main;

import java.util.Scanner;

import com.montran.pojo.Book;
import com.montran.util.BookUtil;

public class BookMain {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in); 
		Book book;
		Book books[]=null;
		BookUtil bookUtil=new BookUtil(100);
		int choice;
		int bookId;
		String bookName;
		double bookPrice;
		int numberOfBooks;
		String continueChoice;
		do
		{
			books=bookUtil.getAllBooks();
			for (Book book2 : books) {
				if (book2!=null) 
					System.out.println(book2.getBookId() + "\t" + book2.getName() + "\t" + book2.getPrice());
			}
			System.out.println("=====MENU====");
			System.out.println("1.Add Single book");
			System.out.println("2.Add multiple book");
			System.out.println("3.Update existing book");
			System.out.println("4.Delete Existing book");
			System.out.println("5.Print Single Book details");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Book Id::");
				bookId=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Book name::");
				bookName=scanner.nextLine();
				System.out.println("Enter book price::");
				bookPrice=scanner.nextDouble();
				book=new Book(bookId, bookName, bookPrice);
				if(bookUtil.addNewBook(book))
					System.out.println("Book is added successfully");
				else
					System.out.println("Failed to add books");
				break;
				
			case 2:
				System.out.println("How many books do you want to add ?");
				numberOfBooks=scanner.nextInt();
				if(numberOfBooks<bookUtil.getMaxIndex()-bookUtil.getNextIndex())
				{
					books=new Book[numberOfBooks];
					for (int i = 0; i < numberOfBooks; i++) {
						System.out.println("Enter Book Id::");
						bookId=scanner.nextInt();
						scanner.nextLine();
						System.out.println("Enter Book name::");
						bookName=scanner.nextLine();
						System.out.println("Enter book price::");
						bookPrice=scanner.nextInt();
						book=new Book(bookId, bookName, bookPrice);
						books[i]=book;
					}
					bookUtil.addAllBooks(books);
					System.out.println("Books added successfully");
				}
				else
				{
					System.out.println("No sufficient Space available");
				}
				break;
				
			case 3:
				System.out.println("Enter book Id to update::");
				bookId=scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if(book!=null) {
				scanner.nextLine();
				System.out.println("Enter Book name::");
				bookName=scanner.nextLine();
				System.out.println("Enter book price::");
				bookPrice=scanner.nextInt();
				if(bookUtil.updateBook(bookId, bookName, bookPrice))
					System.out.println("Book successfully updated");
				else
					System.out.println("BookId not found !! Invalid Book Id");
				}
				else
					System.out.println("No book found");
				break;
				
			case 4:
				System.out.println("Enter book Id to delete::");
				bookId=scanner.nextInt();
				book=bookUtil.getBookByBookId(bookId);
				if(book!=null) {
					if(bookUtil.deleteBook(bookId))
						System.out.println("Book deleted");
				}
				else
					System.out.println("BookId not found !! Invalid Book Id");
				break;
				
			case 5:
				System.out.println("Enter BookId::");
				bookId = scanner.nextInt();
				book = bookUtil.getBookByBookId(bookId);
				if (book != null) {
					System.out.println(book);
				} else
					System.out.println("BookId not found !! Invalid Book Id");
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
	}

}
