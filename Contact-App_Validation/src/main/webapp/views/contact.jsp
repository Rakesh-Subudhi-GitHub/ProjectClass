<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Save Contact Here</h3>
	<p>
			<font color= 'green'>${succMsg}</font>
	</p>

	<p>
			<font color= 'red'>${errMsg}</font>
	</p>
	
													<!-- update the record thats is cid exits then  other wise it saved record as a new record-->
<form:form action="saveContact?contactId = ${contact.contactId}" modelAttribute="contact" method="POST">

	<table>
		<tr>
				<td>Contact Name :</td>
				<td><form:input  path="contactName"/></td>
				<td><form:errors path="contactName"/></td><!-- validate the contact field if error then direct show here-->
		</tr>
		<tr>
				<td>Contact Email :</td>
				<td><form:input  path="contactEmail"/></td>
				<td><form:errors path="contactEmail"/></td><!-- validate the contact field if error then direct show here-->
		</tr>
		<tr>
				<td>Contact Number :</td>
				<td><form:input  path="contactNumber"/></td>
				<td><form:errors path="contactNumber"/></td><!-- validate the contact field if error then direct show here-->
		</tr>
		<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
		</tr>
	</table>

</form:form>

<a href="viewContacts"> ViewAllContacts </a>
</body>
</html>