package com.montran.util;

import com.montran.pojo.Book;

public class BookUtil {
	int nextIndex=0;
	int maxIndex;
	Book books[];
	public BookUtil(int numberOfBooks) {
		books=new Book[numberOfBooks];
		this.maxIndex=numberOfBooks;
	}
	
	
	public int getNextIndex() {
		return nextIndex;
	}


	public int getMaxIndex() {
		return maxIndex;
	}


	public boolean addNewBook(Book book)
	{
		if(nextIndex<books.length && nextIndex>=0)
		{
			books[nextIndex]=book;
			nextIndex++;
			return true;
		}
		return false;
	}
	
	public boolean addAllBooks(Book books[])
	{
		for(Book book:books)
			addNewBook(book);
		return true;
	}
	
	public boolean updateBook(int bookId , String newName , double newPrice)
	{
		for(int index=0;index<books.length;index++)
		{
			if(books[index].getBookId()==bookId)
			{
				books[index].setName(newName);
				books[index].setPrice(newPrice);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteBook(int bookid)
	{
		for (int i = 0; i < books.length; i++) {
			if(books[i].getBookId()==bookid)
				books[i]=null;
				return true;
			
		}
		return false;
	}
	
	public Book getBookByBookId(int bookId) {
		for (Book book : books) {
			if (book != null) {
				if (book.getBookId() == bookId)
					return book;
			}
		}
		return null;

	}
	
	public Book[] getAllBooks()
	{
		return books;
	}
}
