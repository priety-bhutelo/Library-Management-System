<%@page import="org.apache.bsf.util.Bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book</title>
</head>
<body>
	<h3>Issue Book</h3>
	<hr>
	<html:form action="/addNewBook" method="post">
		<table>
			<tr>
				<td>Issue serial Number</td>
				<td><html:text property="serialnumber" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><html:text property="memberCode" /></td>
				
				<td><html:submit  property="member" value="getMember">Get Member Details</html:submit></td>
			</tr>
			<tr>
				<td>Member Name</td>
				<td><html:text property="memberName" /></td>
				<td></td>
			</tr>
			<tr>
				<td>Book Code</td>
				<td><html:text property="book_code" /></td>
				
				<td><html:submit property="book" value="getBook">Get Book Details</html:submit></td>
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
			<td><html:submit property="issue" value="issue Book">Get Book Details</html:submit></td>
			</tr>
			</table>
	</html:form>
</body>
</html>


