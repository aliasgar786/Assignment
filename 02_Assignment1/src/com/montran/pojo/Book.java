package com.montran.pojo;


public class Book {
	private int bookNumber;
	private String bookTitle;
	private double price;
	private double total_cost(double number)
	{
		return price*number;
	}
	
	public void input(int bookNumber,String bookTitle,int price)
	{
		this.bookNumber=bookNumber;
		this.bookTitle=bookTitle;
		this.price=price;
	}
	
	public double purchase(int copies)
	{
		 return total_cost(copies);
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + ", price=" + price +"]";
	}
	
	
}
