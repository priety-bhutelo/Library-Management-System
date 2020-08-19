package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.montran.form.issueForm;


@Entity(name = "book_master")
public class Book_master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookCode")
	private String book_code; 
	
	@Column(name="availablebooks")
	private int availableBooks; 
	@Column(name="title")
	private  String title;
	@Column(name="Author")
	private String author;
	@Column(name="IsBook_issueable")
	private String isBookIssuable; 
	
	
	public int getAvailableBooks() {
		return availableBooks;
	}
	public void setAvailableBooks(int availableBooks) {
		this.availableBooks = availableBooks;
	}
	public String getIsBookIssuable() {
		return isBookIssuable;
	}
	public void setIsBookIssuable(String isBookIssuable) {
		this.isBookIssuable = isBookIssuable;
	}


	
	public Book_master() {
		// TODO Auto-generated constructor stub
	}
	public Book_master(String book_code,String title,String author,String isBookIssuable,int availableBooks) {
		// TODO Auto-generated constructor stub
		super();
		this.book_code = book_code;
		this.availableBooks = availableBooks;
		this.title = title;
		this.isBookIssuable =isBookIssuable;
		
		
	}

	public String getBook_code() {
		return book_code;
	}


	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}


	public String gettitle() {
		return title;
	}


	public void settitle(String title) {
		this.title = title;
	}


	public String getauthor() {
		return author;
	}


	public void setauthor(String author) {
		this.author = author;
	}


	public String isBookIssuable() {
		return isBookIssuable;
	}


	public void setBookIssuable(String isBookIssuable) {
		this.isBookIssuable = isBookIssuable;
	}


	@Override
	public String toString() {
		return "Book_master [book_code=" + book_code + ", title=" + title + ", author=" + author + ", isBookIssuable="
				+ isBookIssuable + "]";
	}

	
}
