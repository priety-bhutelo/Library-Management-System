<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Books Issued</title>
</head>
<body>
	<h3>List Of All  Books Issued</h3>
	<hr>
	<br>
	<html:form action="/LibrarylistAction">
	<table border="1">
		<tr>
			<th>Serial number</th>
			<th>Member code</th>
			<th>Member name</th>
			<th>BooK Code</th>
			<th>Book Name</th>
			<th>Date of Issue</th>
			<th>Date of return</th>
		</tr>
		<logic:iterate name="bookissuedDtetails" id="allbooks">
			<tr>
				<td><bean:write name="allbooks" property="serialnumber" /></td>
				<td><bean:write name="allbooks" property="member.memberCode" /></td>
				<td><bean:write name="allbooks" property="member.memberName" /></td>
				<td><bean:write name="allbooks" property="book.book_code" /></td>
				<td><bean:write name="allbooks" property="book.title" /></td>
				<td><bean:write name="allbooks" property="issue_Date" /></td>
				<td><bean:write name="allbooks" property="return_Date" /></td>
			</tr>
		</logic:iterate>
		
	</table>
	<br>
	<br>
	<html:link action="/addNewBook">Issue Book</html:link>
	<html:link action="/update.jsp">Update Book</html:link>
	<html:link action="/deletebook.jsp">Delete Book</html:link>
	</html:form>
</body>
</html>