<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List</h1>

	<table border="1px">

		<tr>
			<th>ID</th>
			<th>PWD</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>JUMIN</th>
			<th>REGDATE</th>
			<th>UPDATEDATE</th>
		</tr>
		
		<c:forEach var="member" items="${memberList}" varStatus="status">
			<tr>
				<td>${member.id }</td>
				<td>${member.pwd }</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
				<td>${member.jumin }</td>
				<td>${member.regdate }</td>
				<td>${member.updatedate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>