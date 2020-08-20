package com.montran.action;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
		
		
		issueDetailsDAO dao= new issueDetailsDAO();
        issueForm issueform=(issueForm)form;
        member_master membermaster=null;
        Book_master book_master=null;
        Book_issue bookissue=null;
        HttpSession httpSession = request.getSession();
      
        if (request.getParameter("serialno") != null) {
			if (request.getParameter("serialno").equals("Get SerialNumber")) {
				System.out.println("serialnumber Button Clicked");
				System.out.println(issueform.getserialnumber());
				
				bookissue = dao.getbookbyID(issueform.getserialnumber());
				member_master member=(member_master)bookissue.getMember();
				Book_master book=(Book_master)bookissue.getBook();
				issueform.setmemberCode(member.getMemberCode());
				issueform.setmemberName(member.getmemberName());
				issueform.setmemberName(member.getmemberName());
				issueform.setbook_code(book.getBook_code());
				issueform.settitle(book.gettitle());
				issueform.setauthor(book.getauthor());
				issueform.setissue_Date(bookissue.getissue_Date().toString());
				issueform.setreturn_Date(bookissue.getreturn_Date().toString());
				
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("member", member);
				httpSession.setAttribute("bookissued", bookissue);
				httpSession.setAttribute("issueDate", bookissue.getissue_Date());
				httpSession.setAttribute("returnDate", bookissue.getreturn_Date());
				return mapping.findForward("membercode");
			}
		}
        
        if (request.getParameter("membercode") != null) {
			if (request.getParameter("membercode").equals("Get Member Code")) {
				System.out.println("getMember Button Clicked");
				
				if(request.getParameter("memberCode").equals(""))
				{
					
				}
				else
				{
				
				System.out.println(issueform.getmemberCode());
				
				membermaster = dao.getmemberdetails(issueform.getmemberCode());
				issueform.setmemberName(membermaster.getmemberName());
				}
				httpSession.setAttribute("member", membermaster);
				return mapping.findForward("bookcode");
			}
		}
        
        if (request.getParameter("bookcode") != null) {
			if (request.getParameter("bookcode").equals("Get Book Code")) {
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
				return mapping.findForward("update");
			}
        }
        
        
        
        if (request.getParameter("update") != null) {
			if (request.getParameter("update").equals("update Book")) {
				System.out.println("update Book Button Clicked");
				System.out.println(issueform.getserialnumber());
				
				
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book_master = (Book_master) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					membermaster = (member_master) httpSession.getAttribute("member");
				if (httpSession.getAttribute("bookissued") != null)
					book_master = (Book_master) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					membermaster = (member_master) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");
				
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				bookissue= new Book_issue(issueform.getserialnumber(), issueDate, returnDate, book_master, membermaster);
				dao.updateBook(bookissue);
				System.out.println("Book updated Successfully !!");
				
				httpSession.setAttribute("bookissued", bookissue);
						}
		}
        
		return mapping.findForward("success");
	}
}

