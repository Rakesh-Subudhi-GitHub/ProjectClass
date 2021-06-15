<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script >

		function confirmDelete(){
			 return confirm("Are you sure, you want to delete? ");
		}
</script>

<body>
<div> 

<h3>View Contacts </h3>

	<a href="loadForm">+AddContacts</a>

<table border="1">
		<thead>
				<tr>
				      <th>SerialNo</th>
				      <th>CotactName</th>
				      <th>ContactEmail</th>
				      <th>ContactPhone</th>
				      <th>Action</th>
				</tr>
				
		</thead>
	
		<tbody>
			
			 <c:forEach items = "${contacts}" var="c" varStatus="count">
			      <tr>
			      		<td>${count.index+1}</td>
			      		<td>${c.contactName}</td>
			      		<td>${c.contactEmail}</td>
			      		<td>${c.contactNumber}</td>
			      		<td> <a href="editContact?cid=${c.contactId }">Edit</a> &nbsp; 
			      				<a href="deleteContact?cid=${c.contactId }" onclick="confirmDelete()">Delete</a> 
			      		</td>
			      </tr>
			 
			 </c:forEach>
			 
		</tbody>
</table>

				<!-- pageination for -->
				<c:if test="${currentPage > 1}">
					<a href="viewContacts?pNo=${currentPage -1}"> Previous</a>
				</c:if>
				
				<c:forEach begin="1" end="${tp}" var="pageNo">
				
						<c:choose>
								<c:when test="${currentPage==pageNo}">
									${pageNo}
								</c:when>
								<c:otherwise>
									<a href="viewContacts?pNo=${pageNo }">${pageNo}</a>
								</c:otherwise>
						</c:choose>
				
				</c:forEach>
				
				<c:if test="${currentPage < tp}">
					<a href="viewContacts?pNo=${currentPage + 1}"> Next</a>
				</c:if>
</div>

</body>
</html>