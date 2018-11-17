//加载layui功能模块
//		var user = getCookie("userinfo");
//		if(!user) {
//			window.location.href = "../login.html";
//		}
layui.use('element', function(){
  var element = layui.element;
  initPage();
  initEvent();

});

function initPage() {
	var showMenu = $('.layui-this').find('a').attr('submenu');
	var submenus = $('.submenu').hide();
	for (var x = 0; x < submenus.length; x++) {
		if ($(submenus[x]).attr('menu-id') == showMenu) {
			$(submenus[x]).show();
		}
	}
	
}

function initEvent() {
	$('.my-menu-1').click(function() {
		var showMenu = $(this).attr('submenu');
		var submenus = $('.submenu').hide();
		for (var x = 0; x < submenus.length; x++) {
			if ($(submenus[x]).attr('menu-id') == showMenu) {
				$(submenus[x]).show();
			}
		}
	});
	  
	$('.my-menu-2').click(function() {
		$('#my-body').attr('src', $(this).attr('ref'));
	});
}

 


function printYhm(data){
	 var target = $('#username');
	 var html = '<h1>'+ data.username +'<h1>';
	 target.append(html);
}

function logout(){
	var url='aqyh/logout';
	callAjax(url, null, function (data) {
		  clearCookie("user");
		  window.location.href="../login.html";
	});
}

