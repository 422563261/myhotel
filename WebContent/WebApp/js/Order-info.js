define(['jquery','login'],function($){
	return{
		orderInfo:function(){

            $.ajax({
                url:'/Hotel/WebApp/Order-header.html',
                type:"POST",
                dataType:"html",
                success:function(data){
                    $(".container").before(data);
                }
            });
            $.ajax({
                url:'/Hotel/WebApp/Order-footer.html',
                type:"POST",
                dataType:"html",
                success:function(data){
                    $(".container").after(data);
                }
            });
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
                    else{
                    	alert("请登录之后操作");
                    }
                },
                "error":function(){
                    console.log("网络错误！");
                }
            });

		}
	}
})