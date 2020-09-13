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
				<form:form action="/SchoolManagement/teacherDetails" method="post" modelAttribute="teacher">
					<h4>ADD NEW TEACHER</h4>
					<div id="addData">
						<label for="registrationNo">Registration No: </label>
						<form:input path="registrationNo" id="registrationNo" name="registrationNo" required="required"/><br/>
						
						<label for="name">Name: </label>
						<form:input path="name" id="name" name="name" required="required"/><br/>
						
						<label for="phoneNo">Phone: </label>
						<form:input path="phoneNo" name="phoneNo" id="phoneNo" required="required"/><br/>
						
						<label for="email">Email:</label>
						<form:input path="email" name="email" id="email" required="required"/><br/>
						<br/><br/>
						
						<label for="courses" id="selectedCourses"><b>SELECT COURSES</b></label><br/><br/>
						<c:forEach items="${courses}" var="item">
							<label for="${item.course}"><c:out value="${item.course}" /></label>
							<input type="checkbox" name="course" id="${item.course}" value="${item.course}"/><br/>
						</c:forEach><br/>
						<input type="submit" value="Save New Teacher" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>