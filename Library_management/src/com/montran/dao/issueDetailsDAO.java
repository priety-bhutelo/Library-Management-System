package com.montran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.montran.pojo.Book_issue;
import com.montran.pojo.Book_master;
import com.montran.pojo.member_master;
import com.montran.util.SessionFactoryUtil;

public class issueDetailsDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getsessionFactory();

	public void issueNewBook(Book_issue book) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.save(book);
		transaction.commit();
		session.close();
	}
	public void updateBook(Book_issue book) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.update(book);
		transaction.commit();
		session.close();
	}
	public void deleteBook(Book_issue book) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		session.delete(book);
		transaction.commit();
		session.close();
	}
	
	public member_master getmemberdetails(String membercode)
	{
		if(SessionFactoryUtil.getsessionFactory()!=null)
		{
			session=SessionFactoryUtil.getsessionFactory().openSession();
			member_master member=session.get(member_master.class,membercode);
			if(member!=null) 
			{
				session.close();
				System.out.println("member="+member);
				return member;
			}
			session.close();
			return null;
		}
		else
		{
			return null;	
		}
	  
	}
	public Book_issue getbookissued(int serialnumber)
	{
		
		if(SessionFactoryUtil.getsessionFactory()!=null)
		{
			session=SessionFactoryUtil.getsessionFactory().openSession();
			Book_issue book=session.get(Book_issue.class,serialnumber);
			Query query = session.createQuery("from Book_issue where serialnumber=:serialnumber");
		   query.setInteger("serialnumber", serialnumber);
			Object queryResult = query.uniqueResult();
			Book_issue querybook = (Book_issue)queryResult;
			
			if(book!=null) 
			{
				session.close();
				System.out.println("in issue="+book);
				return book;
			}
			session.close();
			return null;
		}
		else
		{
			return null;	
		}
	  
	}

	public Book_master getbookdetails(String bookcode)
	{
		System.out.println("bookcode="+bookcode);
		if(SessionFactoryUtil.getsessionFactory()!=null)
		{
			session=SessionFactoryUtil.getsessionFactory().openSession();
			Book_master book=session.get(Book_master.class,bookcode);
			System.out.println("book="+book);
			if(book!=null) 
			{
				session.close();
				System.out.println("book="+book);
				return book;
			}
			session.close();
			return null;
		}
		else
		{
			return null;	
		}
	  
	}
	
	
	public List<Book_issue> getAllBookIssueDetails() {
		if(SessionFactoryUtil.getsessionFactory()!=null)
		{
		session = factory.openSession();
		Query query = session.createQuery("from Book_issue");
		List<Book_issue> bookIssueList = query.list();
		session.close();
		return bookIssueList;
	}
		else
		{
			return null;	
		}
}}

