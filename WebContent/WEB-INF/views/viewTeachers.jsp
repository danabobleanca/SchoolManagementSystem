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
<div id="container" class="viewContainer">
		<h3>University Management System</h3>
		<div id="systemContainer">
			<div id="menuSystem">
				<div id="student"><a href="/SchoolManagement/">STUDENT</a></div>
				<div id="teacher"><a href="/SchoolManagement/teacher">TEACHER</a></div>
				<div id="course"><a href="/SchoolManagement/course">COURSE</a></div>
				<div id="exam"><a href="/SchoolManagement/exam">EXAM</a></div>
			</div>
			<div id="addNewItem">
				<form action="/SchoolManagement/deleteOrUpdateTeacher" method="get">
					<h4>LIST OF TEACHERS</h4>
					<div id="schoolData">
					<table>
					<tr id="headerViews"><td>Teacher id</td>
						<td>Name</td>
						<td>Phone No.</td>
						<td>Email</td>
					</tr>
						<c:forEach items="${teachers}" var="teacher">
						<tr>
							<td><c:out value="${teacher.registrationNo}"/></td>
							<td><c:out value="${teacher.name}"/></td>
							<td><c:out value="${teacher.phoneNo}"/></td>
							<td><c:out value="${teacher.email}"/></td>
							<td><input type="submit" value="Delete" name="${teacher.registrationNo}"/></td>
							<td><input type="submit" value="Update" name="${teacher.registrationNo}"/></td>
							
						</tr>
						</c:forEach>
					</table>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>