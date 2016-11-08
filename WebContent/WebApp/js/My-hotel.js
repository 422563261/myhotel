$(function(){
	var $money,$username;
	$.ajax({
		url: '/Hotel/WebApp/My-header.html',
		type: 'GET',
		dataType: 'html',
		data: {},
		success:function(data){
			$('body').append(data);
			$.ajax({
				url: '/Hotel/WebApp/refresh.action',
				type: 'GET',
				dataType: 'json',
				data: {},
				success:function(data){
					if(data.status=="1"){
						$username = data.username;
						$money = data.money;
					}
					else{
						location.href="/Hotel/WebApp/index.html"
					}
				},
				error:function(){
					$('#username').text("NULL");
				}
			});
			$("#logout").on('click', function(event) {
				event.preventDefault();
				$.ajax({
					url: '/Hotel/loginOut.action',
					type: 'GET',
					dataType: 'json',
					data: {},
					success:function(){
						location.href="/Hotel/WebApp/index.html"
					}
				})
			});
			$("#logo").on('click',  function(event) {
				event.preventDefault();
				location.href="/Hotel/WebApp/index.html"
			});
			$("#slogan").on('click',  function(event) {
				event.preventDefault();
				location.href="/Hotel/WebApp/My-hotel.html"
			});
		},
		complete:function(){
			$.ajax({
				url: '/Hotel/WebApp/My-body.html',
				type: 'GET',
				dataType: 'html',
				data: {},
				success:function(data){
					$('body').append(data);
					$('.head').before("<script src='/Hotel/WebApp/js/My-page.js'></script>");
					$("#money").text($money);
					$('.username').text($username);
					$.ajax({
						url: '/Hotel/WebApp/getOrder.action',
						type: 'GET',
						dataType: 'json',
						data: {},
						success:function(data){}
					})
				}
			})
		}
	})
})