$(function(){
	var $register_username;
	var $register_password;
	var $register_password_confirm;
	$.ajax({
		"url": '/Hotel/refresh.action',
		"type": 'GET',
		"dataType": 'json',
		"data": {},
		"success":function(data){
			console.log(data);
			if(data.status=="0"){

			}
			else if(data.status=="1"){
				$('.register a').text('退出');
				$('.register').removeClass().addClass('logout');
				$('.login a').text(data.username);
				$('.login').removeClass().addClass('self-center');
			}
		},
		"error":function(){
			console.log("错误！");
		}
	});
	
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
   			"url":"/Hotel/login.action",
   			"dataType":"json",
   			"data":{"username":$username,"password":$password},
   			"success":function(data){
   				
   				if(data.status=="1"){
   					setTimeout(function(){
   						location.reload();
   					},500)
   				}
   			},
   			"error":function(){
   				alert("网络不畅，请稍后再试！");
   			}
		})
	});
	$('#box_up_r').on('click', function() {
		console.log('dianji ');
		$.ajax({
   			"type":"GET",
   			"url":"/Hotel/register.action",
   			"dataType":"json",
   			"data":{"username":$register_username,"password":$register_password},
   			"beforeSend":function(){
   				if($('.error').text()!=""||$register_username==""||$register_password==""||$register_password_confirm==""){
   					return false;	
   				}
   			},
   			"success":function(data){
   				alert("注册成功!");
   				location.reload();
   			},
   			"error":function(){
   				alert("网络不畅，请稍后再试！");
   			}
		})
	});
	$('#register_username').on('blur',  function() {
		event.preventDefault();
		var $username = $(this).val();
		$register_username = $username;
		if($username==""){
			$('.error-username').text('用户名不能为空');
		}
		else{
			$('.error-username').text('');
			$.ajax({
				"url": '/Hotel/check.action',
				"type": 'GET',
				"dataType": 'json',
				"data": {"username": $username},
				"success":function(data){
					if(data.status=="0"){
						$('.error-username').text('用户名已被占用');
					}
					else if(data.status=="1"){
						$('.error-username').text('');
					}
				}
			})
		}
	});
	$('#register_password').on('blur', function() {
		event.preventDefault();
		console.log(1);
		var $password = $(this).val();
		$register_password = $password;
		if($password==""&&$password.length<6){
			$('.error-password').text('密码少于6位');
		}
		else{
			$('.error-password').text('');
		}
	});
	$('#register_password_confirm').on('blur', function() {
		event.preventDefault();
		var $password = $(this).val();
		$register_password_confirm = $password;
		if($register_password_confirm!=$register_password){
			$('.error-password-confirm').text('两个密码不一致');
		}
		else{
			$('.error-password-confirm').text('');
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
	$('.hotel-name').on('mouseover', function(event) {
		event.preventDefault();
		$(this).css({
			"color":"#ffc",
		    "text-shadow":"0 0 .02rem, 0 0 .02rem"
		});
	});
	$('.hotel-name').on('mouseout',  function(event) {
		event.preventDefault();
		$(this).css({
			"color":"#fff",
		    "text-shadow":""
		});
	});
})