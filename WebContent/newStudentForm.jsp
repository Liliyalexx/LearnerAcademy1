<%@page import="com.learnacad.model.Class"%>
<%@page import="java.util.List"%>
<%@page import="com.learnacad.service.ClassService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.register {border: 1px solid #000; margin: 10px; background-color: #ADD8E6;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
	.previous {border: 1px solid #000; margin: 10px; background-color: #f1f1f1;color: black;border-radius: 5%;text-decoration: none;display: inline-block;padding: 8px 16px;}
</style>
<meta charset="ISO-8859-1">
<title>Register Student</title>
</head>
<body>
	<div style="text-align: center">
		<h1>New Student</h1>
		
		<%! ClassService classService = new ClassService(); %>  
		<% List<Class> classList = classService.getClassList();
		   request.setAttribute("classList", classList);
		%>
		<form action="registerStudent" method="post">
			<label for="first_name">First Name:</label>
			<input type="text" id="first_name" name="first_name">
			<br><br>
			<label for="last_name">Last Name:</label>
			<input type="text" id="lastName" name="last_name">
			<br><br>
			<label for="email">Email:</label>
			<input type="email" id="email" name="email">
			<br><br>
			<label for="class_Id">Class:</label>
			<select id="class_Id" name="class_Id">
				<c:forEach items="${classList}" var="item">
				    <option value="${item.id}">${item.name}</option>
				</c:forEach>			
			</select>
			<br/><br/>
			<input class="register" type="submit" name="register" value="Register Student">
			<br/>
			<a href="dashboard.jsp" class="previous">&laquo; Back to Dashboard</a>
		</form>
	</div>	
</body>
</html>