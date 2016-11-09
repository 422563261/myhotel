$(function(){
	var $username;
	$.ajax({
		url: '/Hotel/WebApp/My-header.html',
		type: 'GET',
		dataType: 'html',
		data: {},
		success:function(data){
			$('.inner').before(data);
			$.ajax({
				url: '/Hotel/WebApp/refresh.action',
				type: 'GET',
				dataType: 'json',
				data: {},
				success:function(data){
					console.log(data);
					// if(data.status=="1"){
					// 	$username = data.username;
					// 	$('.username').text($username);
					// }
					// else{
					// 	alert("你还未登录！");
					// 	location.href="/Hotel/WebApp/index.html"
					//}
				},
				error:function(){
					$('#username').text("NULL");
				}
			});
			$("#logout").on('click', function(event) {
				event.preventDefault();
				$.ajax({
					url: '/Hotel/WebApp/loginOut.action',
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
		}
	})

	

	$(".dir ul li:last-child").after("<li>&gt;</li><li><a href='#'>个人中心</a></li>");
	$(".dir ul li:last-child a").hover(function(){
		$(this).css({
			"color": "#000",
			"cursor": "text"
		});
	});

	$(".img-up").on('click', function(event) {
		event.preventDefault();
		$("#img_up").trigger('click');
	});
	$("#img_up").on('change',  function(event) {
		event.preventDefault();

	});
})