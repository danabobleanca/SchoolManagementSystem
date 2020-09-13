<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@ include file="style.css" %></style> 
</head>
<body>
<div id="container">
		<h3>University Management System</h3>
		<div id="systemContainer">
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="addNewItem">
				<form:form action="/SchoolManagement/studentUpdated" method="post" modelAttribute="studentToUpdate">
					
					<h4>UPDATE STUDENT</h4>
					<div id="addData">
					<label for="registrationNo">Registration No.</label>
					<form:input path="registrationNo" name="registrationNo" id="registrationNo" required="required"/> <br/>
					
					<label for="name"> Name</label>
					<form:input path="name" name="name" id="name" required="required"/><br/>
					
					<label for="phoneNo"> Phone No.</label>
					<form:input path="phoneNo" name="phoneNo" id="phoneNo" required="required"/><br/>
					
					<label for="email"> Email</label>
					<form:input path="email" name="email" id="email" /><br/>
					
					<label for="specialization"> Specialization</label>
					<select name="specialization" id="specialization" required="required">
						<c:forEach items="${specializations}" var="item">
							<option value="${item}"><c:out value="${item}" /></option>
						</c:forEach>
					</select><br/> 
					<input type="submit" value="Update Student" />
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>