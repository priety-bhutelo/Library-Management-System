package com.montran.action;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.util.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.issueDetailsDAO;
import com.montran.form.issueForm;
import com.montran.pojo.*;

public class UpdateBook extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		    issueDetailsDAO dao = new issueDetailsDAO();
		    issueForm issueform=(issueForm)form;
		    
		    int serialnumber=issueform.getSerialnumber();
		    System.out.println("serialnumber="+serialnumber);
		    Book_issue book_issue=dao.getbookissued(serialnumber);
		    Book_master bookmaster=null;
		    member_master membermaster=null;
		    request.setAttribute("serialnumber", serialnumber);
		    String memberCode=issueform.getMemberCode();
		    String name=issueform.getName();
		    String book_code=bookmaster.getBook_code();
		    System.out.println("in book_updatebook cose="+book_code);
		    String title=issueform.getTitle();
		    String author=issueform.getAuthor();
		    LocalDate issuedate=book_issue.getIssue_date();
		    LocalDate returndate=book_issue.getReturn_date();
		    System.out.println("in book_issue="+book_issue);
		    
		   
		    Book_master book=dao.getbookdetails(bookmaster.getBook_code());
		    System.out.println("bookcode="+book);
	        member_master member=dao.getmemberdetails(membermaster.getMemberCode());
		    Book_issue issue=new Book_issue(serialnumber,member,book,issuedate,returndate);
		    System.out.println("in update"+issue);
		    request.setAttribute("issueDetail", issue);
		    dao.updateBook(issue);
		

		return mapping.findForward("success");
	}
}
