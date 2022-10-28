console.log("hello")
$('button.category').on('click', function() {
	var cateFk = $(this).attr('value')
	console.log(cateFk);
	$("button.category").each(function(index, el){
		$(el).removeClass("active")
		$(".menuItem_ul").empty();
	})
	$(this).addClass("active")
	if($(this).hasClass("active") == true){
	
	$.ajax({
		url: 'requestObject',
		type: 'POST',
		contentType: 'application/json; charset=UTF-8',
		dataType: 'text',
		data: JSON.stringify({
			'cateFk': cateFk
			}), 
		success: function(data) { 
            var html = ""
            console.log(JSON.parse(data))
			$.each(JSON.parse(data), function(index, el){
				console.log(el.mid)
				html = '<li class="menuItem"><a name="cart" class="modal-btn" data-toggle="modal" data-target="#exampleModal" >'
				html += "<img src=/jvx330/resources/img/" + el.imgUrl + ">"
				html += "<div class='menu_text_box'><p class='menu_text'>" + el.menuName + "</p><p class='menu_text'>" + el.menuPrice + "원</p></div>"
				html += "<span hidden>" + el.mid + "</span></a></li>"
				$(".menuItem_ul").append(html)
			})	
          },
  	      error: function(){
          alert("simpleWithObject err");
      }
	});
	}
});
/*리스트에 집어넣기 */
$(document).on('click', '.modal-btn', function() {
	let mid = $(this).find('span').text();
	//console.log(mid)
	$.ajax({
	            url: "requestCart",
	            type: "POST",
	            contentType: "application/json; charset=utf-8",
	            dataType: "text",
	            data: JSON.stringify({
				'mid': mid
				}),
	           success: function(data){
	            //console.log(JSON.parse(data))
	            var data = JSON.parse(data)
	            //console.log(data[0].menuName);
		        var html = '<tr class="cartlist_line">'
				html += '<td>'+ data[0].menuName+'</td>'
				html += '<input name="menuName" value="' + data[0].menuName + '">'
				html += '<td class="countbtn-box"><input type="number" class="result" id="result" min="1" value="1">'
				html += '</td>'
				html += '<td><input id="menuPrice" class="menuPrice" name="menuPrice" value="' + data[0].menuPrice + '">원</td>'
				html += '<td><button class="listDeletbtn">x</button></td>'
				html += '<td style="display:none">'+ data[0].menuPrice +'</td>'
				html += '<form name="form" action="main" class="modal-form">'
				html += '<input type="number" max="10" class="numberInput" name="buyCount" value="' + data[0].mid + '" /></form>'
				html += '</tr>'
				$(".menulist table").append(html)
				
				//각 메뉴 가격*개수
				$(".result").on("propertychange change paste input", function() {
					let price = parseInt($(this).parent().parent().children("td:nth-child(5)").text());
					var orderNum = $(this).val();
						$(this).parent().parent().children("td:nth-child(3)").children(".menuPrice").attr("value", price * orderNum);
					//합계구하기
					const menuPriceList = $(".menuPrice")
					let totalPrice = 0;
				
					for(let i = 0; i<menuPriceList.length;i++) {
					totalPrice += parseInt(menuPriceList[i].value)
					} 
					$("em.totalPrice").text(totalPrice);
					
					//총수량구하기
		         	const menuNumList = $(".result")
					let totalNum = 0;
					
					for(let i = 0; i<menuNumList.length;i++) {
						totalNum += parseInt(menuNumList[i].value)
					} 
					$("em.totalNum").text(totalNum); 
				})
				
				//합계구하기
	         	const menuPriceList = $(".menuPrice")
				let totalPrice = 0;
				
				for(let i = 0; i<menuPriceList.length;i++) {
					totalPrice += parseInt(menuPriceList[i].value)
				} 
				$("em.totalPrice").text(totalPrice);  
				
				//총수량구하기
	         	const menuNumList = $(".result")
				let totalNum = 0;
				
				for(let i = 0; i<menuNumList.length;i++) {
					totalNum += parseInt(menuNumList[i].value)
				} 
				$("em.totalNum").text(totalNum);  
				
				//메뉴 삭제하기
							
	          },
	          error: function(){
	              alert("simpleWithObject err");
	          }
	      });
	         
});

//메뉴 개별 삭제하기
$(document).on('click', '.listDeletbtn', function() {
	console.log($(this).parent().parent())
	$(this).parent().parent().remove();
	
	//합계구하기
 	const menuPriceList = $(".menuPrice")
	let totalPrice = 0;
	
	for(let i = 0; i<menuPriceList.length;i++) {
		totalPrice += parseInt(menuPriceList[i].value)
	} 
	$("em.totalPrice").text(totalPrice);  
	
	//총수량구하기
 	const menuNumList = $(".result")
	let totalNum = 0;
	
	for(let i = 0; i<menuNumList.length;i++) {
		totalNum += parseInt(menuNumList[i].value)
	} 
	$("em.totalNum").text(totalNum);  
	
})

//메뉴전체삭제하기
$(document).on('click', '.alldelete', function() {
	console.log($('.alldelete').parent().prev().children().children().children())
	$('.alldelete').parent().prev().children().children().children().remove();
	
	//합계구하기
 	const menuPriceList = $(".menuPrice")
	let totalPrice = 0;
	
	for(let i = 0; i<menuPriceList.length;i++) {
		totalPrice += parseInt(menuPriceList[i].value)
	} 
	$("em.totalPrice").text(totalPrice);  
	
	//총수량구하기
 	const menuNumList = $(".result")
	let totalNum = 0;
	
	for(let i = 0; i<menuNumList.length;i++) {
		totalNum += parseInt(menuNumList[i].value)
	} 
	$("em.totalNum").text(totalNum);  
	
})



//증가감소버튼
/*
$('button.countbtn').on('click', function() {
const resultElement = $(this)
console.log(1)
let number = resultElement.text();
console.log(number)

	  if($(this).hasClass('plus')) {
	    number = parseInt(number) + 1;
	  }else if($(this).hasClass('minus'))  {
	    number = parseInt(number) - 1;
	      if(number<0){
			number = 0
		  }
	  }
	  resultElement.text(number);
});*/

//합계
/*function sumprice(type) {

  const resultElement = document.getElementById('result');
  
  let number = resultElement.innerText;

	  if(type === "plus") {
	    number = parseInt(number) + 1;
	  }else if(type === "minus")  {
	    number = parseInt(number) - 1;
	      if(number<0){
			number = 0
		  }
	  }
	  resultElement.innerText = number;
}*/
//empty() -> 선택한 요소의 내용을 지웁니다.
//카드담기 ajax 같은데
/*$(document).on('click', '.modal-btn', function() {
	console.log($(this))
	let mid = $(this).find('span').text();
	console.log(mid)
	$(".menulist table").empty(); 
	$.ajax({
	            url: "requestCart",
	            type: "POST",
	            contentType: "application/json; charset=utf-8",
	            dataType: "text",
	            data: JSON.stringify({
				'mid': mid
				}),
	           success: function(data){
	            console.log(JSON.parse(data))
	            var data = JSON.parse(data)
		        var html = '<form name="form" class="modal-form"><tr class="menulist_line">'
				html += '<div class="text-area"><td>'+ data.menuName+'</td>'
				html += '<input type="hidden" name="menuItemName" value="' + data.menuName + '">'
				html += '<td class="menu_price">' + data.menuPrice + '원</td>'
				html += '<input type="hidden" name="menuPrice" value="' + data.menuPrice + '">'
				html += '<input type="number" max="10" class="numberInput" name="buyCount" value="1" />'
				html += '<div class="text-area_btngrp"><button class="modal-btn" type="button" data-dismiss="modal" aria-label="Close">이전으로</button>'
				html += '<button type="submit" class="modal-btn" formaction="main" formmethod="post">카트담기</button></div></div></form>'
				$(".menulist table").append(html)
				
	          },
	          error: function(){
	              alert("simpleWithObject err");
	          }
	      });
})*/