<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="company">Companies Tree</a>
	<br><br><br><br>
	<c:url value="/" var="url"/>
	<sf:form method="POST" modelAttribute="company" action="${url}">
	<sf:input path="id" type="hidden"/>
	<table>
		<tr>
			<td>Input company name</td>
			<td><sf:input path="name"/></td>
		</tr>
		<tr>
			<td>Input invest</td>
			<td><sf:input path="invest"/></td>
		</tr>
		<tr>
			<td>Select parent</td>
			<td><sf:select path="parent">
				<sf:option value="" />
				<sf:options items="${parents}" itemValue="id" itemLabel="name"/>
			</sf:select></td>
		</tr>

	</table>
	<input type="submit" value="Add">
	</sf:form>
	
	<table>
		<tr>
			<th>Company name</th>
			<th>Parent company</th>
			<th>Investment</th>
		</tr>
		<c:forEach var="company" items="${companies}">
			<tr>
				<td>${company.name}</td>
				<td>${company.parent.name}</td>
				<td>${company.invest}</td>
				
				<td><c:url value="/${company.id}" var="url" /><a
					href="${url}">delete</a></td>
				<td><c:url value="/edit/${company.id}" var="url" /><a
					href="${url}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>