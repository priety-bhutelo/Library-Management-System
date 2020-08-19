<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib  uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Book</title>

</head>
<body>
</head>
<body>
	<h3>update Book</h3>
	<hr>
	<html:form action="DeleteBookAction" method="post">
		<table>
			<tr>
				<td>Issue serial Number</td>
				<td><html:text property="serialnumber" /></td>
				<td><html:submit value="getBook">Get Book Details</html:submit></td>
				<td></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><bean:write name="issueForm" property="memberCode" /></td>
				
			</tr>
			<tr>
				<td>Member Name</td>
				<td><bean:write name="issueForm" property="name" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Book Code</td>
				<td><bean:write name="issueForm" property="book_code" /></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><bean:write name="issueForm" property="title" /></td>
								<td></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><bean:write name="issueForm" property="author" /></td>
				<td></td>
			</tr>
			
			<tr>
			<td><html:submit value="Delete Book">Get Book Details</html:submit></td>
			</tr>
		</table>	
	</html:form>


</body>
</html>