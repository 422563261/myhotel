$(function(){
	$.ajax({
		url: '/Hotel/WebApp/main.html',
		type: 'GET',
		dataType: 'html',
		success:function(data){
			$('body').append(data);
			$('.hidden').before("<script src='/Hotel/WebApp/js/main.js'><\/script>");
		}
	});
})
