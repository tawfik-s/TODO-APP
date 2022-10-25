<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>TODO list</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			<input type="button" value="add Task"
			onclick="window.location.href='showFormForAdd'; return false"
			class="add-button"/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="task" items="${tasks}">
					<c:url var="updateLink" value="/task/showFormForUpdate">
						<c:param name="taskId" value="${task.id}"/>
					</c:url>
					<c:url var="deleteLink" value="/task/delete">
						<c:param name="taskId" value="${task.id}"/>
					</c:url>
					<tr>
						<td> ${task.name} </td>
						<td> ${task.description} </td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('are you sure you want to delete this customer'))) return false"
							>Delete</a>
						</td>

					</tr>

				</c:forEach>

			</table>
				
		</div>
	
	</div>
	

</body>

</html>









