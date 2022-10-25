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
					<th>name</th>
					<th>description</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="task" items="${tasks}">

					<tr>
						<td> ${task.name} </td>
						<td> ${task.description} </td>
					</tr>

				</c:forEach>

			</table>
				
		</div>
	
	</div>
	

</body>

</html>









