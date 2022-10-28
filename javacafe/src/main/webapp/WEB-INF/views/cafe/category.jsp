<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/admin.css'/>"/>
</head>
<body>
<h3>카테고리 추가 및 삭제</h3>
<form:form method="post" modelAttribute="category">
	<label>대분류</label>
	<form:select path="cateType" value="${cateTypeProvider }">
		<form:options items="${cateTypeProvider }"/>
	</form:select>
	<label>중분류</label>
	<form:input path="cateName"/>
	<button type="submit">추가하기</button>
</form:form>

<!-- 목록 -->
<table>
	<c:forEach var="cate" items="${categoryList}">
		<tr>
			<td>${cate.cid}</td>
			<td>${cate.cateType}</td>
			<td>${cate.cateName}</td>
			<td>
				<form action="delete" method="post">
					<input type="text" name="cid" value="${cate.cid }">
					<button type="submit" name="delete">x</button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- formaction="delete" formmethod="post" -->

</body>
</html>