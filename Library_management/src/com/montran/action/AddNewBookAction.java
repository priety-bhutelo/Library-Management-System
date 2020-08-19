package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.montran.dao.issueDetailsDAO;
import com.montran.form.issueForm;
import com.montran.pojo.Book_issue;
import com.montran.pojo.Book_master;
import com.montran.pojo.member_master;

public class AddNewBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		issueDetailsDAO dao= new issueDetailsDAO();
        issueForm issueform=(issueForm)form;
        member_master membermaster=null;
        Book_master book_master=null;
        Book_issue bookissue=null;
        HttpSession httpSession = request.getSession();
       
        if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				System.out.println("getMember Button Clicked");
				System.out.println(issueform.getmemberCode());
				 //issueform.setserialnumber(dao.getMaxBookIssue());
				membermaster = dao.getmemberdetails(issueform.getmemberCode());
				if(request.getParameter("memberCode").equals(""))
				{
					
				}
				else
				{
				issueform.setmemberName(membermaster.getmemberName());
				httpSession.setAttribute("member", membermaster);
				return mapping.findForward("book");
			}
		}
        } 
        if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				System.out.println("getBook Button Clicked");
				System.out.println(issueform.getbook_code());
				membermaster = dao.getmemberdetails(issueform.getmemberCode());
				issueform.setmemberName(membermaster.getmemberName());

				book_master = dao.getbookdetails(issueform.getbook_code());
				LocalDate issueDate = LocalDate.now();
				LocalDate returnDate = LocalDate.now();
				issueform.setauthor(book_master.getauthor());
				issueform.settitle(book_master.gettitle());
				
				
				 System.out.println("date="+issueDate);
				
				if (membermaster.getMemberType().equals("Student")) {
					returnDate = returnDate.plusDays(8);
					System.out.println(issueform);
				}
				if (membermaster.getMemberType().equals("Teacher")) {
					returnDate = returnDate.plusDays(90);
					System.out.println(issueform);
				}
                
                 issueform.setissue_Date(issueDate.toString());
 				issueform.setreturn_Date(returnDate.toString());
			    
				
				System.out.println("--------------------------------------");
				System.out.println(issueform);

				

			
				httpSession.setAttribute("book", book_master);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("returnDate", returnDate);
				return mapping.findForward("member");
			}
        }
        
        
        if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issue Book")) {
				System.out.println("Issue Book Button Click");
				
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book_master = (Book_master) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					membermaster = (member_master) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");

			//	Random random = new Random();
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				bookissue= new Book_issue(issueform.getserialnumber(), issueDate, returnDate, book_master, membermaster);
				dao.issueNewBook(bookissue);
				System.out.println("Book Issued Successfully !!");
			}
		}

		return mapping.findForward("success");
	}
}

       