
//预定义查询对象
var param = {
		serchmc:'',
		pageNum:'',
		numPerPage:10
};
//启用layer模块
layui.use(['laypage', 'form'], function(){
	var laypage = layui.laypage;
	var form = layui.form;
	initPage();
	initEvent();
	
});

function initPage() {
	//页面初始化时即重置查询条件，所有条件为空
	initTable();
}









function initEvent() {
	$('#searchBtn').click(function () {
		initTable();
	});
	//新增
	$('#addBtn').click(function () {
		var id = $('#Id').val('');
		var mc = $('#mc').val('');
		//重新渲染DOM
		layui.use('form', function(){
			var form = layui.form;
			form.render('select');
		});
		layui.use(['layer','form'], function(){
			var layer = layui.layer;
			var form=layui.form;
			var index = layer.open({
				type : 1,
				content : $('#modifyUserDiv'),
				title : false,
				closeBtn : 0,
				shadeClose : true,
				area: ['650px', '500px'],
			});
			$('#cancelBtn').click(function() {
				layer.close(index);//关闭消息框
			});
			//监听提交
			form.on('submit(formDemo)',function(data){
				$('#modifyUserForm')[0].reset();
			    var da=data.field;
			  
				var params=da;
				var url = 'qlxz/update';
				callAjax(url, params, function(data) {
					layer.msg("保存成功");
					layer.close(index); 
					initTable();
				});
			    return false;
			});
		}); 
		initTable('');
	});

}


function initTable() {
	//根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'qlxz/page';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	var seachmc = $('#seachmc').val();
	
	var _data = {
			mc:seachmc,
			pageNum:1,
			numPerPage:10
	};
	
	
	callAjax(url, _data,function(data){
		if(!(data.code == 200 && data.dataList)) {
			return;
		}
		initTableBack(data);
		});
}

//获取信息后初始化分页并装载数据
function initTableBack(data) {
	//重新获取laypage实例
	layui.use('laypage', function(laypage) {
		laypage.render({
			elem : 'my-table',
			limit : 10,
			count : data.totalCount,
		
			//首次加载不执行jumpTo，避免重复ajax浪费性能
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
//跳页不涉及查询对象属性的改变
function jumpTo(page) {
	console.log(page);
	$("#data-table").empty();
	var seachmc = $('#seachmc').val();
	var _data = {
			mc:seachmc,
			pageNum:page,
			numPerPage:10	
	};
	var url = 'qlxz/page';
	callAjax(url, _data, function (data) {printTable(data.dataList);});
}
function printTable(data) {
	var target = document.getElementById('data-table');
	
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td	>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteThis(' + data[x].id + ')>删除</a>';
	    html += '</td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

//修改操作
function modify(id) {
	var url = "qlxz/byid";
	var param = {
			id : id
	};
	callAjax(url, param, function(data){
		doModify(data.data);
	});
}
function doModify(data) {
	var id = $('#Id').val(data.id);
	var mc = $('#mc').val(data.mc);
//重新渲染DOM
layui.use('form', function(){
	var form = layui.form;
	form.render('select');
});
var index ='';
layui.use('layer', function(){
	var layer = layui.layer;
	index=layer.open({
		type : 1,
		content : $('#modifyUserDiv'),
		title : false,
		closeBtn : 0,
		shadeClose : true,
		area: ['650px', '500px'],
	});
}); 

$('#cancelBtn').click(function() {
	layer.close(index);//关闭消息框
});
layui.use('form', function(){
	var form = layui.form;
   //监听提交
	form.on('submit(formDemo)', function(data){
	$('#modifyUserForm')[0].reset();
    var da=data.field;
	var params=da;
	
	var url = 'qlxz/update';
	callAjax(url, params, function(data) {
		layer.msg("修改成功");
		layer.close(index); 
		initTable();
	});
    return false;
  });	
});

}


function deleteThis(id){
	layui.use('layer',function(){
		var layer=layui.layer;
		var url = 'qlxz/delete';
		var _data={
			id : id,
		};
		layer.open({
			content:'确认删除该权利性质？',
			btn:['确认','取消'],
			yes:function(index,layero){
				layer.close(index);//关闭消息框
				callAjax(url, _data, function(){
					initTable();
				});
			},
			btn2:function(index,layero){
			    //return false 开启该代码可禁止点击该按钮关闭
			},
			cancel:function(){
			    //return false 开启该代码可禁止点击该按钮关闭
			}
		});
	});
}
//	debugger;
//	var url = 'jichu/qlxzdelete';
//	var _data={
//		id : id,
//	};
//	callAjax(url, _data, function(){
//		initTable();
//	});
//}







