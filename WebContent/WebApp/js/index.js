$(function(){
	$.ajax({
		url: 'main.html',
		type: 'GET',
		dataType: 'html',
		success:function(data){
			$('body').append(data);
			$('.hidden').before("<script src='js/main.js'><\/script>");
		}
	});
})
