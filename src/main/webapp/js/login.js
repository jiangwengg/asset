// 启用layer模块
var form=null;
layui.use(['laypage', 'form'], function(){
	var laypage = layui.laypage;
    form = layui.form;
	
});


$('.login_btn').click(function(){
	var url = 'aqyh/login';
	var param = {
		username : $('#username').val(),
		password : $('#password').val()
	}
	callAjaxNoCookie(url, param, function(data) {
		setCookie("user",data.data.id)
		window.location.href = "html/main.html";
	})
	return false;
});

// 登录按钮事件
/*form.on("submit(login)", function() {
	var url = 'user/login';
	var param = {
		name : $('#username').val(),
		password : $('#password').val()
	}
	callAjax(url, param, function(data) {
		window.location.href = "html/main.html";
	})
	return false;
});*/