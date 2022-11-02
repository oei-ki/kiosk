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
<link rel="stylesheet" href="<c:url value='/resources/css/pay.css'/>">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="content">
	<h1>결제완료</h1>
		<div class="box">
			<h3>주문내역</h3>
			<hr>
			<table>
				<tr>
				<th>메뉴명</th><th>수량</th><th>가격</th>
				</tr>
				<c:forEach var="order" items="${cartList}">
					<tr>
						<td>${order.menuName}&nbsp;&nbsp;&nbsp;</td><td>${order.number}</td><td>${order.menuPrice}</td>
					</tr>
				</c:forEach> 
			</table>
			<div class="btn">
			 	<button onclick="location.href='main'">메인페이지</button>
			</div>
		</div>	
</div> 
</body>
</html>