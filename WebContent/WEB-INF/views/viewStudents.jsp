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
				<form action="/SchoolManagement/deleteOrUpdate" method="get">
					<h4>LIST OF STUDENTS</h4>
					<div id="schoolData">
					<table>
					<tr id="headerViews"><td>Registration No.</td>
						<td>Name</td>
						<td>Year Of Study</td>
						<td>Phone No.</td>
						<td>Email</td>
						<td>Specialization</td>
					</tr>
						<c:forEach items="${allStudents}" var="item">
						<tr>
							<td><c:out value="${item.registrationNo}"/></td>
							<td><c:out value="${item.name}"/></td>
							<td><c:out value="${item.studentYear}"/></td>
							<td><c:out value="${item.phoneNo}"/></td>
							<td><c:out value="${item.email}"/></td>
							<td><c:out value="${item.specialization}"/></td>
							<td><input type="submit" value="Delete" name="${item.registrationNo}"/></td>
							<td><input type="submit" value="Update" name="${item.registrationNo}"/></td>
							
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