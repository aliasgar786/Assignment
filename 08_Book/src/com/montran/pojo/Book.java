package com.montran.pojo;

public class Book {
	private int bookId;
	private String name;
	private double price;
	public Book(int bookId, String name, double price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
