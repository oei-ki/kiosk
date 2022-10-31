<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, minimum-scale=1"
    />
<title>주문하세요</title>
<link rel="stylesheet" href="<c:url value='/resources/css/order.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>">
</head>
<body>
	<div id="content">
		<div>
			<button onclick="location.href='admin'">메뉴추가하기</button>
		</div>
		<div class="txt">
			<h1>여기에서 주문하세요!</h1>
		</div>
		
		<div class="btn">
			<button class="order" onclick="location.href='main'">테이크아웃</button>
			<button class="order" onclick="location.href='main'">매장</button>
		</div>
	</div>
</body>
</html>