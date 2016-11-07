$(function(){
	$.ajax({
		url: '/Hotel/WebApp/MainBody.html',
		type: 'GET',
		dataType: 'html',
		success:function(data){
			$('body').append(data);
			$('.info').remove();
			$('.hidden').before("<script src='/Hotel/WebApp/js/MainBody.js'><\/script>");
		}
	});
	
})