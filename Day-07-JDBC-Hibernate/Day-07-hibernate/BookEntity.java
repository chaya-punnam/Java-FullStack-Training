package com.abc.demo.FirstHibernateProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity {
	
	@Id
	private int bookId;
	private String bookTitle;
	private int bookPrice;
	private String bookAuthor;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public BookEntity(int bookId, String bookTitle, int bookPrice, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	
}