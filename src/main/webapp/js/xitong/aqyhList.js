//预定义查询对象
var param = {};
var form = null;
//启用layer模块
layui.use(['laypage', 'form'], function(){
	var laypage = layui.laypage;
    form = layui.form;
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
	$('#addBtn').click(function(){
		modify('');
	});

}


function initTable() {
	//根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'aqyh/pagelist';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	param.pageNum=1,
	param.numPerPage=10,
	callAjax(url, param,function(data){
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
	$("#data-table").empty();
	param.pageNum = page,
	callAjax('aqyh/pagelist', param, function (data) {printTable(data.dataList);});
}
function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].xm) + '</td	>';
	    html += 	'<td>' + isnull(data[x].yhm) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zuoji) + '</td	>';
	    html += 	'<td>' + isnull(data[x].shouji) + '</td	>';
	    html += 	'<td>' + isnull(data[x].email) + '</td	>';
	    if(data[x].zt == 0){
	    	  html += 	'<td>禁用</td>';
	    }else if(data[x].zt == 1){
	    	  html += 	'<td>启用</td>';
	    }
	    if(data[x].zt == 0){
		     html += '<td><a href="javascript:;" class="layui-btn" onclick=changeStatus('+ data[x].id +',1)>启用</a>';
	    }else if(data[x].zt == 1){
	    	 html += '<td><a href="javascript:;" class="layui-btn ayui-btn-danger" onclick=changeStatus('+ data[x].id +',0)>停用</a>';
	    }
	    html += '<a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteThis(' + data[x].id + ')>删除</a>';
	    html += '</td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

	//修改操作
	function modify(id) {
		$('#modifyUserDiv input').val('');
		if(id){
			callAjax("aqyh/byid", {id:id}, function(data){
			     data=data.data;
				 $('#id').val(data.id);
			     $('#xm').val(data.xm);
			     $('#yhm').val(data.yhm);
			     $('#mm').val(data.mm);
			     $('#zuoji').val(data.zuoji);
			     $('#shouji').val(data.shouji);
			     $('#email').val(data.email);
			});
		}
		doModify();
  }
	
 function doModify() {
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
		var url = 'aqyh/update';
		callAjax(url, params, function(data) {
			layer.msg("修改成功");
			layer.close(index); 
			initTable();
		});
	    return false;
	  });	
	});
}

 //停用 启用
function changeStatus(id,zt){
	callAjax("aqyh/change", {id:id,zt:zt}, function(data) {
		layer.msg("修改成功");
		initTable();
	});
}
function deleteThis(id){
	layui.use('layer',function(){
		var layer=layui.layer;
		var url = 'aqyh/change';
		layer.open({
			content:'确认删除该记录？',
			btn:['确认','取消'],
			yes:function(index,layero){
				layer.close(index);//关闭消息框
				callAjax(url, {id:id,zt:9}, function(){
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








