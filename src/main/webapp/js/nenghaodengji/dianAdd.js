var form =null;
var lx=getQueryString("lx");
var param=null;
$('#lx').val(lx);
// 启用layer模块
layui.use(['laypage', 'form','laydate'], function(){
	var laypage = layui.laypage;
    form = layui.form;
    var laydate = layui.laydate;
    //日期
    laydate.render({
      elem: '#rq_kaishi'
    });
    laydate.render({
      elem: '#rq_jieshu'
    });
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
	callAjax('zcbj/list', {lx:lx}, function(data) {
		printSelect('biaojiName',data.dataList,'id','mc');
		printSelect('biaoji',data.dataList,'id','mc')
	})
}

function initTable() {
	// 根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zcbjfy/pagelist';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	param.bjlx=lx;
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
	$("#data-table").empty();
	param.pageNum=page;
	var url = 'zcbj/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' + isnull(data[x].renyuanshu) + '</td>';
	    html += 	'<td>' + isnull(data[x].rq_kaishi) + '</td>';
	    html += 	'<td>' + isnull(data[x].rq_jieshu) + '</td>';
	    html += 	'<td>' + isnull(data[x].feiyong) + '</td>';
	    html += 	'<td>' + isnull(data[x].feiyong_renjun) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteThis(' + data[x].id + ')>删除</a></td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}



//删除记录
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
	//清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
	if(id){
		callAjax("zcbjfy/byid", {id:id}, function(data) {
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
    $('#biaoji').val(data.biaoji) ;
    $('#rq_kaishi').val(data.rq_kaishi) ;
    $('#rq_jieshu').val(data.rq_jieshu) ;
    $('#feiyong').val(data.feiyong);
    $('#feiyong_renjun').val(data.feiyong_renjun);
    $('#shiyongliang').val(data.shiyongliang);
    
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
		var url = 'zcbjfy/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});



