<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
<title>현재 메뉴 목록</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
<p class="adminurl"><a onclick="location.href='admin';"><span class="material-symbols-outlined">
arrow_back
</span></a></p>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div id=content>
	<table>
		<tr><th>mid</th><th>cateFk</th><th>메뉴명</th><th>사이즈</th><th>가격</th><th>이미지</th><th>삭제하기</th></tr>
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
						<input type="text" name="mid" value="${menu.mid }" style="display:none;">
						<button type="submit" name="menudelete" style="width:50px">x</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>