<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<form:form action="/SchoolManagement/teacherUpdated" method="post" modelAttribute="teacherToUpdate">
					
					<h4>UPDATE STUDENT</h4>
					<div id="addData">
						<label for="registrationNo">Registration No.</label>
						<form:input path="registrationNo" id="registrationNo" name="registrationNo" required="required"/>
						
						<label for="name">Name</label>
						<form:input path="name" name="name" id="name" required="required"/>
						
						<label for="phoneNo">Phone No.</label>
						<form:input path="phoneNo" id="phoneNo" name="phoneNo" required="required"/>
						
						<label for="email">Email</label>
						<form:input path="email" id="email" name="email" required="required"/>
						
						<br/><br/><br/>
						<label for="courses" id="selectedCourses"><b>SELECT COURSES</b></label><br/><br/>
						<c:forEach items="${teacherCourses}" var="item">
							<label for="${item.course}">${item.course}</label>
							<input type="checkbox" value="${item.course}" name="course" id="${item.course}" checked="checked"/>
						</c:forEach>
						
						<c:forEach items="${uncheckedCourses}" var="item">
							<label for="${item.course}" >${item.course} </label>
							<input type="checkbox" value="${item.course}" name="course" id="${item.course}"/>
						</c:forEach>
						<input type="submit" value="Update Tacher"/>
					</div>
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>