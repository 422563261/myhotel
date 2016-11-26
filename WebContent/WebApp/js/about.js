define(['jquery'],function($){
	return{
		mainAbout:function(){
			$(function(){
				$.ajax({
					url: '/Hotel/WebApp/Main-body.html',
					type: 'GET',
					dataType: 'html',
					success:function(data){
						$('body').append(data);
						$('.info').remove();
						//$('.hidden').before("<script src='/Hotel/WebApp/js/MainBody.js'><\/script>");
						require(['Main-body'],function(){});
					}
				});
				
			})
		}
	}
	
})
