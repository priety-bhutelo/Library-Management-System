<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update2 Book</title>
</head>
<body>

</head>
<body>
<%!int serialnumber;
String membercode;
%>
<%

serialnumber=Integer.parseInt(request.getParameter("serialnumber"));//<td><%=serialnumber</td>

%>
	<h3>Update Book</h3>
	<hr>
	<html:form action="/UpdateBook" method="post">
		<table>
			<tr>
				<td>Issue serial Number:</td>
				
				
				<td></td>
			</tr>
			<tr>
				<td>Member Code:</td>
				<td><bean:write name="issueForm" property="memberCode"/>
				</td>
				
			</tr>
			<tr>
				<td>Member Name:</td>
				<td><bean:write name="issueForm" property="name" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Book Code:</td>
				<td><bean:write name="issueForm" property="book_code" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><bean:write name="issueForm" property="title" /></td>
								<td></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><bean:write name="issueForm" property="author" /></td>
				<td></td>
			</tr>
			
			<tr>
			<td><html:submit value="Update Book">Get Book Details</html:submit></td>
			</tr>
			</table>
	</html:form>

</body>
</html>