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
	<a href="/">Back</a>
	<table>
		<c:forEach var="company" items="${companies}">
			<tr>
				<td style="padding-left: calc(25px*${company.level})">-${company.name} ${company.invest} | <c:if test="${company.allInvest ne 0}">${company.allInvest}</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<%-- <ul>
		<c:forEach var="company" items="${companies}">
			<li style="padding-left: calc(25px*${company.level})">-${company.name} ${company.invest} | <c:if test="${company.allInvest ne 0}">${company.allInvest}</c:if></li>
		</c:forEach>
	</ul> --%>

</body>
</html>