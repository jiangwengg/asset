var form=null;
//预定义查询对象
var param = {
		pageNum:'',
		numPerPage:10
};
//启用layer模块
layui.use(['laypage', 'form','laydate'], function(){
	var laypage = layui.laypage;
    form = layui.form;
    var laydate = layui.laydate;
    //日期
    laydate.render({
      elem: '#qixian_kaishi'
    });
    laydate.render({
      elem: '#qixian_jieshu'
    });
    laydate.render({
        elem: '#zhengjian_rq'
     });
	initPage();
	initEvent();
	
});

function initPage() {
	//页面初始化时即重置查询条件，所有条件为空
	initTable();
	//加载权利类型和权利性质
	initQuanli();
}

function initQuanli() {
	callAjax('leixing/list', null, function(data) {
		printSelect('zc_quanli_lx',data.dataList,'id','mc');
		printSelect('quanli_lx',data.dataList,'id','mc');
	});
	callAjax('qlxz/list', null, function(data) {
		printSelect('zc_quanli_xingzhi',data.dataList,'id','mc');
		printSelect('quanli_xingzhi',data.dataList,'id','mc');
	});
	callAjax('select/shiyongrenlist', null, function(data) {
		printSelect('shiyongren',data.dataList,'id','mc');
	});
	callAjax('select/gongyonglist', null, function(data) {
		printSelect('gongyou',data.dataList,'id','mc');
	});
}

function initEvent() {
	$('#searchBtn').click(function () {
		initTable();
	});
	//新增
	$('#addBtn').click(function () {
		modify('');
	});

}


function initTable() {
	//根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zichan/pagelist';
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
	param = formToJson(paramForm);
	param.pageNum=page;
	param.numPerPage=10;
	var url = 'zichan/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}
function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' +(x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zuoluo) + '</td>';
	    html += 	'<td>' + isnull(data[x].mianji_pingfangmi) + '</td>';
	    html += 	'<td>' + isnull(data[x].syrmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].qllxmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].qlxzmc) + '</td>';
	    html += 	'<td>' + (data[x].zhengjian_zt == "0"?'未办理不动产权证':'已办理不动产权证') + '</td>';
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
			callAjax("zichan/change", {id:id,zt:"9"}, function(data) {
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

//修改操作
function modify(id) {
    if(id){
    	callAjax("zichan/byid", {id:id}, function(data){
    		doModify(data.data);
    	});
    }else{
    	doModify('');
    }

}
function doModify(data) {
	var f=$("#modifyUserDiv input[name!='']");
    for(var t=0;t<f.length;t++){
    	var idName=f[t].id;
    	if(idName!=""){
        	$('#'+idName).val(data[idName]);
    	}
    }
	var fs=$("#modifyUserDiv select[name!='']");
    for(var t=0;t<fs.length;t++){
    	var idName=fs[t].id;
    	if(idName!=""){
        	$('#'+idName).val(data[idName]);
    	}
    }
	
	//重新渲染DOM
	form.render('select');
	
	var index ='';
	layui.use('layer', function(){
		var layer = layui.layer;
		index=layer.open({
			type : 1,
			content : $('#modifyUserDiv'),
			title : false,
			closeBtn : 0,
			shadeClose : true,
			area: ['650px', '700px'],
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
		var url = 'zichan/update';
		callAjax(url, params, function(data) {
			layer.msg("操作成功");
			layer.close(index); 
			initTable();
		});
	    return false;
	  });	
	});
}








