$(function(){
	$('.close').on('click', function() {
		$('.hidden').css({
			"visibility":"hidden"
		});
		$('.box').css({
			"width":"0",
			"height":"0"
		});
	});
	$('.login-button').on('click', function() {
		$('.hidden').css({
			"visibility":"visible"
		});
		$('.box').animate({
			"width":"3.9rem",
			"height":"3.1rem"
		},"swing");
		$('.box-hotel-register').css({
			"font-size":".16rem",
			"color":"#7f1f59",
			"margin-top":".24rem"
		});
		$('.box-hotel-login').css({
			"font-size":".2rem",
			"color":"#000",
			"margin-top":".21rem"
		});
		$('.login-box').css({
			"display":"block"
		});
		$('.register-box').css({
			"display":"none"
		});
	});
	$('.register-button').on('click', function() {
		$('.hidden').css({
			"visibility":"visible"
		});
		$('.box').animate({
			"width":"3.9rem",
			"height":"3.7rem"
		},"swing");
		$('.box-hotel-login').css({
			"font-size":".16rem",
			"color":"#7f1f59",
			"margin-top":".24rem"
		});
		$('.box-hotel-register').css({
			"font-size":".2rem",
			"color":"#000",
			"margin-top":".21rem"
		});
		$('.register-box').css({
			"display":"block"
		});
		$('.login-box').css({
			"display":"none"
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
   				if(data.status=="1"){
   					setTimeout(function(){
   						window.location.href = "info.html";
   					},500)
   				}
   			},
   			"error":function(){
   				alert("网络不畅，请稍后再试！");
   			}
		})
	});
	$('#box_up_r').on('click',  function() {
		var $username = $("#register_username").val();
		var $password = $("#register_password").val();
		$.ajax({
   			"type":"GET",
   			"url":"/hm/register.action",
   			"dataType":"json",
   			"data":{"username":$username,"password":$password},
   			"success":function(data){
   				alert("success!");
   			},
   			"error":function(){
   				alert("网络不畅，请稍后再试！");
   			}
		})
	});
	$('#register_username').on('blur',  function() {
		event.preventDefault();
		console.log($(this))
		if($(this).val()==""){
			$('.error-username').text('用户名不能为空');
		}
		else{
			$('.error-username').text('');
		}
	});
	$('.bar').on('mouseover', 'li', function() {
		event.preventDefault();
		$('.bar li').removeClass('active');
		var $value = $(this).attr("value");
		if ($value=="2") {
			$(this).addClass('active');
			$("#bar_LP").css({
				"left":"2.96rem",
				"width":"0.72rem"
			});
		}
		else if($value==3){
			$(this).addClass('active');
			$("#bar_LP").css({
				"left":"5.48rem",
				"width":"0.72rem"
			});
		}
		else if($value==1){
			$(this).addClass('active');
			$("#bar_LP").css({
				"left":".8rem",
				"width":"0.36rem"
			});
		}
	});
	$('.bar').on('mouseout', 'li', function() {
		event.preventDefault();
		var $value = $(this).attr("value");
		if ($value!="1") {
			$(this).removeClass('active');
			$("#bar_first").addClass('active');
		}
		$("#bar_LP").css({
				"left":".8rem",
				"width":"0.36rem"
			});
	});
})