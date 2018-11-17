//预定义查询对象
var param = {
		zichan:'',
		louceng:'',
		keywords:''
};
var form=null;
// 启用layer模块
layui.use(['laypage', 'form'], function(){
	var laypage = layui.laypage;
    form = layui.form;
	initPage();
	initEvent();
	
});

function initPage() {
	// 页面初始化时即重置查询条件，所有条件为空
	initTable();
	// 加载下拉选
	initSelectList();

}
function initEvent() {
	$('#searchBtn').click(function () {
		initTable();
	});
	
	// 新增用户
	$('#addBtn').click(function () {
		 modify('');
	});
}


// 加载下拉选择查询条件
function initSelectList() {
	var url = 'zichan/list';
	callAjax(url, null, function(data) {
		printZc(data);
	})
	callAjax("zl/list", null, function(data) {
		printZl(data);
		printZlModify(data);
	})	
	callAjax("zlfx/list", null, function(data) {
		printZlfx(data);
	})	
	callAjax("shiyongren/list", null, function(data) {
		printYg(data);
	})	
	
	form.on('select(m-zichanList)', function(data){
		callAjax("zl/list", {zichan:data.value}, function(data) {
			printZlModify(data);
		})	
	});  
	
}


// 资产下拉框的change事件
layui.use('form', function(){
	var form = layui.form;
	form.on('select(zcList)', function(data){
		callAjax("zl/list", {zichan:data.value}, function(data) {
			data=data.dataList;
			var target = document.getElementById('loucengList');
			var html = ''
			for (var x = 0; x < data.length; x++) {
				html += '<option class="lcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
			}
			target.innerHTML = html
			// 重新渲染DOM
		    form.render('select');
		});	
	}); 
});

// 渲染资产下拉框
function printZc(data) {
	data=data.dataList;
	var target = document.getElementById('zichanList');
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="zcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html
	// 新增和修改窗口
	document.getElementById('m-zichanList').innerHTML += html
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
}
// 渲染查询条件下拉框
function printZl(data) {
	data=data.dataList;
	var target = document.getElementById('loucengList')
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="lcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
}
// 渲染修改楼层下拉框
function printZlModify(data) {
	data=data.dataList;
	var html = '<option value class="id"> 请选择</option>'
	for (var x = 0; x < data.length; x++) {
		html += '<option class="lcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	// 新增和修改窗口
	document.getElementById('m-loucengList').innerHTML = html
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
}

function printZlfx(data){
	data=data.dataList;
	var target = document.getElementById('m-xingzhi')
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="xzOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html		
}


function printYg(data){
	data=data.dataList;
	var target = document.getElementById('renyuan')
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="ryOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html		
}

function initTable() {
	// 根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zlf/pagelist';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	param.pageNum=1;
	param.numPerPage=10;
	callAjax(url, param,function(data){
		if(!(data.code == 200 && data.dataList)) {
			return;
		}
		initTableBack(data);
	});
}

// 获取信息后初始化分页并装载数据
function initTableBack(data) {
	// 重新获取laypage实例
	layui.use('laypage', function(laypage) {
		laypage.render({
			elem : 'my-table',
			limit : 10,
			count : data.totalCount,
		
			// 首次加载不执行jumpTo，避免重复ajax浪费性能
			jump : function (obj, first) {
				if(!first){
					jumpTo(obj.curr);
				}
			},
			layout : ['prev', 'page', 'next', 'count']
		});
		printTable(data.dataList);
	});
}
// 跳页不涉及查询对象属性的改变
function jumpTo(page) {
	console.log(page);
	$("#data-table").empty();
	param.pageNum=page;
	param.numPerPage=10;
	var url = 'zlf/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + (x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zichanMc) + '</td>';
	    html += 	'<td>' + isnull(data[x].lou_cengMc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mianji) + ' m²</td>';
	    html += 	'<td>' + isnull(data[x].renyuanMc) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteThis(' + data[x].id + ')>删除</a></td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}



// 删除记录
function deleteThis(id) {
	layui.use('layer', function(){
	var layer = layui.layer;
	layer.open({
		  content: '确定删除该记录？'
		  ,btn: ['确定', '取消']
		  ,yes: function(index, layero){
			layer.close(index); // 关闭信息框
			callAjax("zlf/change", {id:id,zt:"9"}, function(data) {
				layer.msg("删除成功");
				initTable();
			});
		  }
	     ,btn2: function(index, layero){
		  }
		  ,cancel: function(){ 
		  }
		});
	});	
}


var index ='';
// 修改资产楼层房间
function  modify(id){
	// 清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
	$('#ryqd').empty();
	if(id){
		callAjax("zlf/byid", {id:id}, function(data) {
			doModify(data.data);
		});		
	}
		

	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
	
	layui.use('layer', function(){
		var layer = layui.layer;
		index=layer.open({
			type : 1,
			content : $('#modifyDiv'),
			title : false,
			closeBtn : 0,
			shadeClose : true,
			area: ['600px', '500px'],
		})
	}); 
	
	$('#cancelBtn').click(function(){
		layer.close(index); 
	});
	
}

// 回显数据
function doModify(data){
	callAjax("zl/list", {zichan:data.zichan}, function(result) {
		result=result.dataList;
		var html = '<option value class="id"> 请选择</option>'
		for (var x = 0; x < result.length; x++) {
			html += '<option class="lcOption" value="' + result[x].id + '">' + result[x].mc + '</option>'
		}
		document.getElementById('m-loucengList').innerHTML = html
		$('#m-loucengList').val(data.lou_ceng);
        form.render('select');
	})	
	$('#id').val(data.id) ;
    $('#mc').val(data.mc) ;
    $('#mianji').val(data.mianji) ;
    $('#m-zichanList').val(data.zichan);
//    $('#m-loucengList').val(data.lou_ceng);
    $('#m-xingzhi').val(data.xingzhi);
    $('#renyuans').val(data.renyuanIds);

    var renyuanIds = (data.renyuanIds == undefined ?'':data.renyuanIds.split(','));
    var renyuanNames =(data.renyuanMc == undefined ?'':data.renyuanMc.split(','));
    for(var  i=0; i < renyuanNames.length ; i++){
    	var html='';
    	html += ' <span fsw="select" style="padding: 2px 5px; background: rgb(240, 242, 245); border-radius: 2px; color: rgb(144, 147, 153); display: block; line-height: 20px; height: 20px; margin: 2px 5px 2px 0px; float: left; cursor: initial; user-select: none;">' 
    	html += '   <font fsw="select">'+renyuanNames[i]+'</font>  '
    	html += '   <i fsw="select" class="layui-icon" style="background-color: rgb(192, 196, 204); color: rgb(255, 255, 255); margin-left: 8px; border-radius: 20px; font-size: 12px; cursor: initial;"  onclick="delDizhi(this,\''+renyuanIds[i]+'\')">ဆ</i> '
    	html += ' </span>'
        $('#ryqd').append(html);
    }
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
	
}

// 提交表单
	layui.use('form', function(){
		var form = layui.form;
	   // 监听提交
		form.on('submit(formDemo)', function(data){
	    var da=data.field;
		var params=da;
		var url = 'zlf/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});


   layui.use('form', function(){
	var form = layui.form;
    form.on('select(renyuan)', function(data){
    	var value=$('#renyuan').val();
    	var text=$("#renyuan option:selected").text();// 获取当前选择项文本
		
    	var renyuans=$('#renyuans').val();
    	if(!renyuans && value!=""){ // 第一次
        	$('#renyuans').val(value);
        	var html='';
        	html += ' <span fsw="select" style="padding: 2px 5px; background: rgb(240, 242, 245); border-radius: 2px; color: rgb(144, 147, 153); display: block; line-height: 20px; height: 20px; margin: 2px 5px 2px 0px; float: left; cursor: initial; user-select: none;">' 
        	html += '   <font fsw="select">'+text+'</font>  '
        	html += '   <i fsw="select" class="layui-icon" style="background-color: rgb(192, 196, 204); color: rgb(255, 255, 255); margin-left: 8px; border-radius: 20px; font-size: 12px; cursor: initial;"  onclick="delDizhi(this,\''+value+'\')">ဆ</i> '
        	html += ' </span>'
            $('#ryqd').append(html);
    	}else{
    		if(renyuans.split(',').indexOf(value)<0){
    			$('#renyuans').val(renyuans+","+value);
    	    	var html='';
    	    	html += ' <span fsw="select" style="padding: 2px 5px; background: rgb(240, 242, 245); border-radius: 2px; color: rgb(144, 147, 153); display: block; line-height: 20px; height: 20px; margin: 2px 5px 2px 0px; float: left; cursor: initial; user-select: none;">' 
    	    	html += '   <font fsw="select">'+text+'</font>  '
    	    	html += '   <i fsw="select" class="layui-icon" style="background-color: rgb(192, 196, 204); color: rgb(255, 255, 255); margin-left: 8px; border-radius: 20px; font-size: 12px; cursor: initial;"  onclick="delDizhi(this,\''+value+'\')">ဆ</i> '
    	    	html += ' </span>'
    	        $('#ryqd').append(html);
    		}
    	}
    })
 });
   
   
   // 删除选中的地址
   function delDizhi(ob,checkVal){
	 var sp=$(ob).parent();
	 sp.remove();
	 var renyuans = $('#renyuans').val().split(',');
	 var temp = renyuans.indexOf(checkVal);
	 renyuans.splice(temp,1);
	 $('#renyuans').val(renyuans.join(','));
   }
   

