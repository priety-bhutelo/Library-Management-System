package com.montran.action;
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

public class DeleteBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	issueDetailsDAO dao= new issueDetailsDAO();
        issueForm issueform=(issueForm)form;
        member_master membermaster=null;
        Book_master book_master=null;
        Book_issue bookissue=null;
        HttpSession httpSession = request.getSession();
		
        if (request.getParameter("serialdelete") != null) {
				if (request.getParameter("serialdelete").equals("Get SerialNumber")) {
					System.out.println("delete serialnumber Button Clicked");
					System.out.println(issueform.getserialnumber());
					
					bookissue = dao.getbookbyID(issueform.getserialnumber());
					System.out.println(bookissue);
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
					return mapping.findForward("update");
				}
			}
	        
	        if (request.getParameter("delete") != null) {
				if (request.getParameter("delete").equals("delete Book")) {
					System.out.println("delete Book Button Clicked");
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

				  
					dao.deleteBook(bookissue);
					System.out.println("Book deleted Successfully !!");
					
					httpSession.setAttribute("bookissued", bookissue);
							}
			}
	        
			return mapping.findForward("success");
		}
	}

	       
