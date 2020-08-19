package com.montran.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.issueDetailsDAO;
import com.montran.pojo.*;

public class LibrarylistAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in bookIssueDetailsAction");
		issueDetailsDAO dao = new issueDetailsDAO();
		List<Book_issue> issueDetails = dao.getAllBookIssueDetails();
		System.out.println(issueDetails);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("bookissuedDtetails", issueDetails);
 
		return mapping.findForward("success");
	}
}
