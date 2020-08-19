package com.montran.form;

import java.time.LocalDate;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.montran.pojo.Book_master;
import com.montran.pojo.member_master;

public class issueForm extends ActionForm {
	private int serialnumber;
	private String memberCode;
	private String memberName;
	private String book_code;
	private String title;
	private String author;
	private String issue_Date;
	private String return_Date;

	public int getserialnumber() {
		return serialnumber;
	}

	public void setserialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getmemberCode() {
		return memberCode;
	}

	public void setmemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getmemberName() {
		return memberName;
	}

	public void setmemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getbook_code() {
		return book_code;
	}

	public void setbook_code(String bookCode) {
		this.book_code = bookCode;
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

	public String getissue_Date() {
		return issue_Date;
	}

	public void setissue_Date(String issueDate) {
		this.issue_Date = issueDate;
	}

	public String getreturn_Date() {
		return return_Date;
	}

	public void setreturn_Date(String returnDate) {
		this.return_Date = returnDate;
	}

	@Override
	public String toString() {
		return "IssueDetailsForm [issueCode=" + serialnumber + ", memberCode=" + memberCode + ", memberName=" + memberName
				+ ", bookCode=" + book_code + ", title=" + title + ", author=" + author + ", issueDate=" + issue_Date
				+ ", returnDate=" + return_Date + "]";
	}

}
