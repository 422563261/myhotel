$(function(){
	$('.close').on('click', function() {
		$('.hidden').css({
			"display":"none"
		});
	});
	$('.login').on('click', function() {
		$('.hidden').css({
			"display":"block"
		});
	});
	$('#box_up').on('click',  function() {
		var $username = $("#username").val();
		var $password = $("#password").val();
		$.ajax({
   			"type":"GET",
   			"url":"",
   			"dataType":"json",
   			"data":{"username":$username,"password":$password},
   			"success":function(data){},
   			"error":function(){
   				alert("请稍后再试！");
   			}

		})
	});
})