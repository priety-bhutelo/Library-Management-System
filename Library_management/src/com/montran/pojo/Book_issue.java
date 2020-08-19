package com.montran.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "Book_issue")
public class Book_issue {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_issue_gen")
	@SequenceGenerator(sequenceName = "book_issue_sequence", name = "book_issue_gen")
	@Column(name = "serialnumber")
	private int serialnumber;

	@Column(name = "issue_date")
	private LocalDate issue_Date;

	@Column(name = "due_date_of_return")
	private LocalDate return_Date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOKCODE")
	private Book_master book;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MEMBERCODE")
	private member_master member;

	public Book_issue() {
		// TODO Auto-generated constructor stub
	}

	public Book_issue(int serialnumber, LocalDate issueDate, LocalDate returnDate, Book_master book, member_master member) {
		super();
		this.serialnumber = serialnumber;
		this.issue_Date = issueDate;
		this.return_Date = returnDate;
		this.book = book;
		this.member = member;
	}

	public int getserialnumber() {
		return serialnumber;
	}

	public void setserialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}

	public LocalDate getissue_Date() {
		return issue_Date;
	}

	public void setissue_Date(LocalDate issueDate) {
		this.issue_Date = issueDate;
	}

	public LocalDate getreturn_Date() {
		return return_Date;
	}

	public void setreturn_Date(LocalDate returnDate) {
		this.return_Date = returnDate;
	}

	public Book_master getBook() {
		return book;
	}

	public void setBook(Book_master book) {
		this.book = book;
	}

	public member_master getMember() {
		return member;
	}

	public void setMember(member_master member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "IssueDetails [issueCode=" + serialnumber + ", issueDate=" + issue_Date + ", returnDate=" + return_Date
				+ ", book=" + book + ", member=" + member + "]";
	}

}
