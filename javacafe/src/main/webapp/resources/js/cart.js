console.log("cart")
//수량변경에 따른 가격변화
$("#result").on("propertychange change paste input", function() {
console.log("change");
});
$("#input").on("change keyup paste input", function(){
console.log("change");

});