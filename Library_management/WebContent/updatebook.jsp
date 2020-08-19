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
	<form action="updatebook2.jsp" method="post">
		<table>
			<tr>
				<td>Issue serial Number</td>
				<td><input type="text" name="serialnumber" /></td>
				<td><input type="submit" value="getBook"></td>
				<td></td>
			</tr>
			
	</table>
	</form>


</body>
</html>