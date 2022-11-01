<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/mainpage.css'/>">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>

	결제완료 
<c:forEach var="order" items="${cartList}">
	<!-- <button class=cart id="${cart.oid}" value="${cart.oid}">${cart.menuName}</button> -->
	<li>${order.menuName}</li>
	<li>${order.number}</li>
	<li>${order.menuPrice}</li>
</c:forEach> 
 	<button onclick="location.href='main'">메인페이지</button>
</body>
</html>