<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 하기</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/default.css'/>"/>
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'/>">
<script src = "http://code.jquery.com/jquery-latest.js"></script>
<script>
    var cnt = 1;
    function fn_addFile(){
        $("#d_file").append("<br>" + "<input type='file' name='file" + cnt + "' />");
        cnt++;
    }
</script>
</head>
<body>
<h3>상품추가</h3>

<form:form action="add_menu" method="post" modelAttribute="menuItem" enctype="multipart/form-data"> <!--enctype 해당 폼이 multipart형식임을 알려준다 -->
	<label>카테고리선택</label>
	<form:select name="cateFk" path="cateFk" value="cateFk">
		<form:options items ="${CategoryProviderList }" itemValue="cid" itemLabel="cateName"/>		
	</form:select><br>
	<label>메뉴</label>
	<form:input path="menuName" name="menuName"/><br>
	<label>size</label>
	<select name="menuSize" path="menuSize">
		<option value="Tall">Tall</option>	
		<option value="Grande">Grande</option>		
		<option value="Venti">Venti</option>								
	</select><br>
	<label>가격</label>
	<form:input path="menuPrice"/><br>
	<label>이미지</label>
	<form:input path="file" type="file" value="파일 추가" onClick="fn_addFile()"/><br>
	  <div id="d_file">
          
       </div>
	<button type="submit">추가하기</button>
</form:form>

</body>
</html>