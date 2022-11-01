<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1"/>
<title>kiosk</title>
<link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/mainpage.css'/>">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
<p class="adminurl"><a onclick="location.href='order';"><span class="material-symbols-outlined">
arrow_back
</span></a></p>
<p class="adminurl"><a style="float: left;" onclick="location.href='admin';" >관리자추가메뉴</a></p>
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
			<table class="cartListtable">
			<!-- ajax들어감 -->
			</table>
<script type="text/javascript" src="<c:url value='/resources/js/cart.js'/>"></script>
		</div>
		<div class="payment">
			<div class="payment-bottom">
				<ul>
					<li>수량 : <em class="totalNum"></em></li>
					<li id="sumorder">합계 : <em class="totalPrice"></em></li>
				</ul>
			</div>
			<div class="payment-bottom payment-btn">
				<button class="alldelete purchase">전체취소</button>
				<button class="purchase"><a id="modal-list" data-value="${menu.mid}" class="modal_btn"  rel="modal:open" href="#modal1">결제하기</a></button>
			</div>
		</div>
	</div>
</div>
	
<!-- modal body -->
<div id="modal1" class="modal" >
	<h2>주문내역확인</h2>
	<hr/>
	<div class="cart-list">
		<p>주문정보를 확인해 주세요</p>
	    <form action="pay" method="post" class="modal_body">
			<table class="testmodal">
				<tr><th>상품명</th><th>수량</th><th>가격</th></tr>
				<tbody class="cartmodellist">
				</tbody>
			</table>
		    <div class="total-list">
		    	<div><span>총수량 <em class="totalNum"></em> 개</span></div>
		    	<div><span>총 결제금액 : <em class="totalPrice"></em> 원</span></div>
		    </div>
			<input class="Paying" type="submit" name="pay" value="결제하기">
	    </form>
	</div>
</div>

</body>
</html>