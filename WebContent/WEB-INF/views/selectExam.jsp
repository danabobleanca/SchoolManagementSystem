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
				<form action="/SchoolManagement/addExam" method="get">
					<h4>ADD NEW EXAM</h4>
					<div id="addData">
						<c:forEach items="${courses}" var="item">
							<label for="${item.course}"><c:out value="${item.course}"/></label>
							<input type="radio" value="${item.course}" name="examSelected" id="${item.course}" required="required">
						</c:forEach>
						<input type="submit" value="Continue" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>