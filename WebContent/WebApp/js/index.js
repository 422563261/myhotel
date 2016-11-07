$(function(){
	$.ajax({
		url: '/Hotel/WebApp/MainBody.html',
		type: 'GET',
		dataType: 'html',
		success:function(data){
			$('body').append(data);
			$('.hidden').before("<script src='/Hotel/WebApp/js/MainBody.js'><script>");
		}
	});
})
