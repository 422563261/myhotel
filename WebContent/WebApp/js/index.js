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
   			"url":"/hm/login.action",
   			"dataType":"json",
   			"data":{"username":$username,"password":$password},
   			"success":function(data){
   				alert(data.status);
   			},
   			"error":function(){
   				alert("请稍后再试！");
   			}

		})
	});
})