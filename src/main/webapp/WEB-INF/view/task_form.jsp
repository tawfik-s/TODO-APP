<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: tshal
  Date: 10/24/2022
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save task</title>
    <link type="text/css"
        rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-task-style.css">

</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>ToDo App</h2>
        </div>
    </div>
    <div id="container">
        <h3>save task</h3>
        <form:form action="saveTask" modelAttribute="task" method="post">
            <form:hidden path="id"/>
            <table>
                <tbody>
                <tr>
                    <td>
                        <label>name</label>
                    </td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>description</label>
                    </td>
                    <td>
                        <form:input path="description"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label></label>
                    </td>
                    <td>
                        <input type="submit" value="save" class="save">
                    </td>
                </tr>
                </tbody>
            </table>

        </form:form>
        <p>
            <a href="${pageContext.request.contextPath}/task/list">
                Back to list
            </a>
        </p>
    </div>

</body>
</html>
