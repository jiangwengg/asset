//预定义查询对象
var param = {
		zichan:'',
		louceng:'',
		keywords:''
};
//pageNum:1,
//numPerPage:10
// 启用layer模块
layui.use(['laypage', 'form'], function(){
	var laypage = layui.laypage;
	var form = layui.form;
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
	
	//新增用户
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
	})	
	callAjax("zlfx/list", null, function(data) {
		printZlfx(data);
	})		
}


//资产下拉框的change事件
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
function printZl(data) {
	data=data.dataList;
	var target = document.getElementById('loucengList')
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="lcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html
	// 新增和修改窗口
	document.getElementById('m-loucengList').innerHTML += html
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
}


function 	printZlfx(data){
	data=data.dataList;
	var target = document.getElementById('m-xingzhi')
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="xzOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
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
	    html += 	'<td>' + isnull(data[x].renyuan) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += ' </td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

var index ='';
// 修改资产楼层房间
function  modify(id){
	//清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
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
	$('#id').val(data.id) ;
    $('#mc').val(data.mc) ;
    $('#mianji').val(data.mianji) ;
    $('#m-zichanList').val(data.zichan);
    $('#m-loucengList').val(data.lou_ceng);
    $('#m-xingzhi').val(data.xingzhi);
    
	//重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
	
}

//提交表单
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



