<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키오스크admin</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">
</head>
<body>
<p class="adminurl"><a onclick="location.href='order';">메인으로</a></p>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="button-box">
	<button class="main-btn" onclick="location.href='add_category';">카테고리 추가</button>
	<button class="main-btn" onclick="location.href='add_menu';">메뉴 추가</button>
	<button class="main-btn" onclick="location.href='allmenu';">현재메뉴 보기</button>
</div>
</body>
</html>