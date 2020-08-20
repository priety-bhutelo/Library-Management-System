<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
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
	<html:form action="/updatebook" method="post">
		<table>
			<tr>
				<td>Issue serial Number</td>
				<td><html:text property="serialnumber" /></td>
				<td><td><html:submit property="serialno" value="Get SerialNumber">Get Serial Number</html:submit></td></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode" /></td>
				<td><td><html:submit property="membercode" value="Get Member Code">Get member code</html:submit></td></td>
			</tr>
			<tr>
				<td>Member Name</td>
				<td><html:text property="memberName" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Book Code</td>
				<td><html:text property="book_code" /></td>
				<td><td><html:submit property="bookcode" value="Get Book Code">Get Book Code</html:submit></td></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><html:text property="title" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><html:text property="author" /></td>
				<td></td>
			</tr>
			<tr>
				<td>IssueDate</td>
				<td><html:text property="issue_Date" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Returndate</td>
				<td><html:text property="return_Date" /></td>
				<td></td>
			</tr>
			
			<tr>
			<td><html:submit property="update" value="update Book">Update Book Details</html:submit></td>
			</tr>
			</table>
	</html:form>


</body>
</html>
