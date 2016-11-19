/**
 * Created by tan on 2016/11/18.
 */
$(function(){
    var $register_username;
    var $register_password;
    var $register_password_confirm;
    var $reg1 = /^[A-Za-z0-9]{3,11}$/;//用户名要求是3~11的位的字母或者数字
    var $reg2 = /^[A-Za-z0-9]{6,11}$/;//密码要求是6~11的位的字母或者数字

    //对于用户是否登录的检测请求
    $.ajax({
        "url": '/Hotel/WebApp/refresh.action',
        "type": 'POST',
        "dataType": 'json',
        "data": {},
        "success":function(data){
            var data = $.parseJSON(data.content);
            if(data[0].status=="1"){
                console.log(data[1].username);
                $('.register').remove();
                $('.login').remove();
                $('.logo-bar').after("<li class='user'><a href='#'>"+data[1].username+"</a></li>");
                $(".logo-bar").after("<li class='logout'><a href='#'>退出</a></li>");
            }
        },
        "error":function(){
            console.log("网络错误！");
        }
    });

    //退出登录事件
    $(document).on('click',".logout", function(event) {
        event.preventDefault();
        $.ajax({
            url: '/Hotel/loginOut.action',
            type: 'GET',
            dataType: 'json',
            data: {},
            success:function(){
                location.reload();
            }
        })
    });


    //点击关闭按钮事件
    $('.close').on('click', function() {
        $('.hidden').css({
            "visibility":"hidden"
        });
        $('.box').removeClass('box-login-active').removeClass('box-register-active');
        $('.box input').val('');
        $('.error').text('');
    });

    //点击登录按钮事件
    $('.login-button').on('click',login);
    function login (){
    	console.log(1);
        $('.hidden').css({
            "visibility":"visible"
        });
        $('.box').addClass('box-login-active').removeClass('box-register-active');
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
    }

    //点击注册按钮事件
    $('.register-button').on('click', register);
    function register(){
        $('.hidden').css({
            "visibility":"visible"
        });
        $('.box').addClass('box-register-active').removeClass('box-login-active');
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
    }

    //登录事件
    $('#box_up').on('click',function() {
        var $username = encodeURI($("#username").val());
        var $password = $("#password").val();
        $.ajax({
            "type":"POST",
            "url":"/Hotel/login.action",
            "dataType":"json",
            "data":{"username":$username,"password":$password},
            "contentType":"application/x-www-form-urlencoded; charset=UTF-8",
            "success":function(data){
                var data = $.parseJSON(data.content);
                if(data[0].status=="1"){
                    $('#box_up').before('<p class="login-success">登陆成功！</p>');
                    setTimeout(function(){
                        location.reload();
                    },500)
                }
                else{
                    $('#box_up').before('<p class="login-error">用户名或者密码错误！</p>');
                }
            },
            "error":function(){
                alert("网络不畅，请稍后再试！");
            }
        })
    });


    //注册事件
    $('#box_up_r').on('click', function() {
        $.ajax({
            "type":"GET",
            "url":"/Hotel/register.action",
            "dataType":"json",
            "contentType":"charset=UTF-8",
            "data":{"username":$register_username,"password":$register_password},
            "beforeSend":function(){
                if($('.error').text()!=""||$register_username==""||$register_password==""||$register_password_confirm==""){
                    return false;
                }
            },
            "success":function(data){
                var data = $.parseJSON(data.content);
                console.log(data[0].username);
                $('#box_up_r').before('<p class="login-success">注册成功！</p>');
                setTimeout(function(){
                    location.reload();
                },500)
            },
            "error":function(){
                alert("网络不畅，请稍后再试！");
            }
        })
    });

    //检测用户名是否被占用和是否符合规范
    $('#register_username').on('blur',  function(event) {
        event.preventDefault();
        var $username = $(this).val();
        if($username==""){
            $('.error-username').text('用户名不能为空');
        }
        else if(!$reg1.test($username)) {
            $('.error-username').text('用户名不合规范');
        }
        else{
            $register_username = encodeURI($username);
            $('.error-username').text('');
            $.ajax({
                "url": '/Hotel/check.action',
                "type": 'GET',
                "dataType": 'json',
                "data": {"username": $register_username},
                "success":function(data){
                    var data = $.parseJSON(data.content);
                    if(data[0].status=="0"){
                        $('.error-username').text('用户名已被占用');
                    }
                    else if(data[0].status=="1"){
                        $('.error-username').text('');
                    }
                }
            })
        }
    });

    //检测密码是否符合规范
    $('#register_password').on('blur', function(event) {
        event.preventDefault();
        var $password = $(this).val();
        if($password==""){
            $('.error-password').text('密码不能为空');
        }
        else if(!$reg2.test($password)){
            $('.error-password').text('密码不合规范');
        }
        else{
            $('.error-password').text('');
            $register_password = $password;
        }
    });

    //检测两次密码输入是否一致
    $('#register_password_confirm').on('blur', function(event) {
        event.preventDefault();
        var $password = $(this).val();
        if($register_password_confirm!=$register_password){
            $('.error-password-confirm').text('两个密码不一致');
        }
        else{
            $('.error-password-confirm').text('');
            $register_password_confirm = $password;
        }
    });

    //input[type:checkbox]的唯一选项判定
    $("input[type=checkbox]").on('click',function(){
        $(this).parent().siblings("span").find("input").prop("checked",false);
        var $name = $(this).prop("id");
        console.log($name);
        $.ajax({
            url:"./",
            type:"POST",
            dataType:"json",
            data:{direction:$name},
            success:function(data){
                console.log(data);
            }
        })
    });


    //朝北不允许有双人间
    $("#north").on("click",function(){
        $("#ultra").prop({
            "disabled":false
        }).siblings("label").css("color","#000");
        if($(this).prop("checked") == true){
            $("#double").prop("disabled",true).siblings().css("color","#999");
        }
        else {
            $("#double").prop("disabled",false).siblings().css("color","#000");
        }
    });

    //朝南不允许有四人间
    $("#south").on("click",function(){
        $("#double").prop({
            "disabled":false
        }).siblings("label").css("color","#000");
        if($(this).prop("checked") == true){
            $("#ultra").prop("disabled",true).siblings().css("color","#999");
        }
        else {
            $("#ultra").prop("disabled",false).siblings().css("color","#000");
        }
    });

    //双人间不允许朝北
    $("#double").on("click",function(){
        $("#south").prop({
            "disabled":false
        }).siblings().css("color","#000");
        if($(this).prop("checked") == true){
            $("#north").prop("disabled",true).siblings().css("color","#999");
        }
        else {
            $("#north").prop("disabled",false).siblings().css("color","#000");
        }
    });

    //四人间不允许朝南
    $("#ultra").on("click",function(){
        $("#north").prop({
            "disabled":false
        }).siblings().css("color","#000");
        if($(this).prop("checked") == true){
            $("#south").prop("disabled",true).siblings().css("color","#999");
        }
        else {
            $("#south").prop("disabled",false).siblings().css("color","#000");
        }
    });

    //三人间朝向无要求
    $("#triple").on("click",function(){
        $(".choice").eq(0).find("input").prop({
            "disabled":false
        }).siblings().css("color","#000");
    });

    $(".clean").on("click",function(){
        $(this).siblings(".lab").find("input").prop({
            "disabled":false,
            "checked":false
        }).find("label").css({
            "color":"#000"
        })
    });
});





