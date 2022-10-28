<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키오스크</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/mainpage.css'/>">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>

<p class="adminurl"><a onclick="location.href='admin';">관리자추가메뉴</a></p>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="category-box">
	<c:forEach var="cate" items="${categoryList}">
		<button class="category" id="${cate.cid}" value="${cate.cid}">${cate.cateName}</button>
		<!-- href 사용할까 <a onclick="location.href='주소';"></a>-->
	</c:forEach>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
<div id="contain">
	<ul class="menuItem_ul">
	<!-- ajax들어감 -->
	</ul>
</div>
<div class="container">
	<div class="cart-box">
		<p>구매내역</p>
		<div class="menulist">
			<table>
			<!-- ajax들어감 -->
			</table>
<script type="text/javascript" src="<c:url value='/resources/js/cart.js'/>"></script>
		</div>
		<div class="payment">
			<div>
				<ul>
					<li>수량 : <em class="totalNum"></em></li>
					<li id="sumorder">합계 : <em class="totalPrice"></em></li>
				</ul>
			</div>
			<button class="alldelete">전체취소</button>
			<button>결제하기</button>
			<a data-value="${menu.mid}" class="modal_btn"  rel="modal:open" href="#modal1"><span class="textLine">결제하기</span></a>
		</div>
	</div>
</div>
	
<!-- modal body -->
<div id="modal1" class="modal" >
   <form action="post" method="post" class="modal_body">
      <input class="modal_hidden_input" hidden name="bId" value="" />
      비밀번호 : <input type="password" name="passwd" maxlength="4" />
      <input class="submit_btn" type="submit" value="확인" />
   </form>
</div>

</body>
</html>