$(function(){
	$.ajax({
		url: '/Hotel/WebApp/My-header.html',
		type: 'GET',
		dataType: 'html',
		data: {},
		success:function(data){
			$('body').append(data);
		}
	})
	$.ajax({
		url: '/Hotel/WebApp/My-body.html',
		type: 'GET',
		dataType: 'html',
		data: {},
		success:function(data){
			$('body').append(data);
			$('.head').before("<script src='/Hotel/WebApp/js/My-page.js'></script>");
		}
	})
})