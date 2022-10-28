<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
<title>현재 메뉴 목록</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<table>
	<c:forEach var="menu" items="${menuList}">
		<tr>	
			<td>${menu.mid}</td>
			<td>${menu.cateFk}</td>
			<td>${menu.menuName}</td>
			<td>${menu.menuSize}</td>
			<td>${menu.menuPrice}</td>
			<td><img src="/jvx330/resources/img/${menu.imgUrl}" alt="menuimg"/></td>
			<td>
				<form action="menudelete" method="post">
					<input type="text" name="mid" value="${menu.mid }">
					<button type="submit" name="menudelete">x</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
	<button onclick="location.href='order'">주문창으로</button>
</body>
</html>