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
				<form action="/SchoolManagement/courseDetails" method="post">
					<h4>ADD NEW COURSE</h4>
					<div id="addData">
						<label for="course">Name of course: </label>
						<input type="text" name="courseName" id="course" required="required"/>
						
						<br/><br/><br/>
						<b>SELECT SPECIALIZATION</b><br/><br/>
						<c:forEach items="${specialization}" var="item">
							<label for="${item}"><c:out value="${item}" /></label>
							<input type="radio" value="${item}" name="specialization" id="${item}" required="required"/>
						</c:forEach><br/>
						<input type="submit" value="Save New Course" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>