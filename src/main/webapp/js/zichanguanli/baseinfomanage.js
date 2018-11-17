//全局保存使用人信息
var shiyongren = {};
//全局保存共有情况信息
var gongyouqk = {};
//全局保存权利类型
var quanlilx = {};
//全局保存权利性质
var quanlixz = {};

//预定义查询对象
var param = {
		keywords:'',
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
	initSYR();
	//初始化共有情况选择器
	initGYQK();
	//初始化权利类型选择器
	initQLLX();
	//初始化权利性质选择器
	initQLXZ();
}

function initSYR() {
	var url = 'select/shiyongrenlist';
	callAjax(url, null, function(data) {
		shiyongren = data.dataList;
		//初始化使用人选择器
		initSYRmc();
	});
}


function initSYRmc(){
	//初始化搜索内容
	var target = $('#shiyongren-select');
	var html = '';

	
	for (key in shiyongren) {
		html += '<option value="' + shiyongren[key].id+ '">' + shiyongren[key].mc + '</option>';
	}
	target.each(function() {
		$(this).append(html);
	});
}

function initGYQK() {
	var url = 'select/gongyonglist';
	callAjax(url, null, function(data) {
		gongyouqk = data.dataList;
		//初始化共有情况选择器
		initGYmc();
	});
}

function initGYmc(){
	//初始化搜索内容
	var target = $('#gongyou-select');
	var html = '';

	
	for (key in gongyouqk) {
		html += '<option value="' + gongyouqk[key].id+ '">' + gongyouqk[key].mc + '</option>';
	}
	target.each(function() {
		$(this).append(html);
	});
}

function initQLLX() {
	var url = 'leixing/list';
	callAjax(url, null, function(data) {
		quanlilx = data.dataList;
		//初始化权利类型选择器
		initQLLXmc();
	});
}

function initQLLXmc(){
	//初始化搜索内容
	var target = $('#quanli_lx-select');
	var html = '';
	for (key in quanlilx) {
		html += '<option value="' + quanlilx[key].id+ '">' + quanlilx[key].mc + '</option>';
	}
	target.each(function() {
		$(this).append(html);
	});
}

function initQLXZ() {
	var url = 'qlxz/list';
	callAjax(url, null, function(data) {
		quanlixz = data.dataList;
		//初始化权利性质选择器
		initQLXZmc();
	});
}

function initQLXZmc(){
	//初始化搜索内容
	var target = $('#quanli_xz-select');
	var html = '';
	for (key in quanlixz) {
		html += '<option value="' + quanlixz[key].id+ '">' + quanlixz[key].mc + '</option>';
	}
	target.each(function() {
		$(this).append(html);
	});
}

function initEvent() {
	$('#searchBtn').click(function () {
		initTable();
	});
	//新增
	$('#addBtn').click(function () {
		var id = $('#Id').val('');
		var mc = $('#mc').val('');
		$('#shiyongren-select').children().each(function() {
			if($(this).val() == "") {
				$(this).attr('selected', 'selected');
			} else {
				$(this).removeAttr('selected');
			}
		});
		$('#gongyou-select').children().each(function() {
			if($(this).val() == "") {
				$(this).attr('selected', 'selected');
			} else {
				$(this).removeAttr('selected');
			}
		});
		var zuoluo = $('#zuoluo').val('');
		var danyuan_bh = $('#danyuan_bh').val('');
		$('#quanli_lx-select').children().each(function() {
			if($(this).val() == "") {
				$(this).attr('selected', 'selected');
			} else {
				$(this).removeAttr('selected');
			}
		});
		$('#quanli_xz-select').children().each(function() {
			if($(this).val() == "") {
				$(this).attr('selected', 'selected');
			} else {
				$(this).removeAttr('selected');
			}
		});
		var yongtu = $('#yongtu').val('');
		var quanli_qita = $('#quanli_qita').val('');
		var mianji_pingfangmi = $('#mianji_pingfangmi').val('');
		var mianji_mu = $('#mianji_mu').val('');
		var tuhao = $('#tuhao').val('');
		var dihao = $('#dihao').val('');
		var mianji_shiyong = $('#mianji_shiyong').val('');
		var mianji_fentan = $('#mianji_fentan').val('');
		var qixian_kaishi = $('#qixian_kaishi').val('');
		var qixian_jieshu = $('#qixian_jieshu').val('');
		var zhengjain_bianhao_nianfen = $('#zhengjain_bianhao_nianfen').val('');
		var zhengjian_rq = $('#zhengjian_rq').val('');
		$('#zt-select').children().each(function() {
			if($(this).val() == "") {
				$(this).attr('selected', 'selected');
			} else {
				$(this).removeAttr('selected');
			}
		});
		
		layui.use('laydate', function(){
			  var laydate = layui.laydate;
			  
			  //执行一个laydate实例
			  laydate.render({
			    elem: '#qixian_kaishi'//指定元素
			  });
			  laydate.render({
				    elem: '#qixian_jieshu'//指定元素
				  });
			  laydate.render({
				    elem: '#zhengjian_rq' //指定元素
				  });
			});
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
			    da.qixian_kaishi = new Date(Date.parse(da.qixian_kaishi));
			    da.qixian_jieshu = new Date(Date.parse(da.qixian_jieshu));
			    da.zhengjian_rq = new Date(Date.parse(da.zhengjian_rq));
				var params=da;
				var url = 'zichan/update';
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
	var url = 'zichan/pagelist';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	console.log(param);
	var seachmc = $('#seachmc').val();
	
	var _data = {
			keywords:seachmc,
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
	var _data = {
			keywords:'',
			pageNum:page,
			numPerPage:10	
	};
	console.log(_data);
	var url = 'zichan/pagelist';
	callAjax(url, _data, function (data) {printTable(data.dataList);});
}
function printTable(data) {
	var target = document.getElementById('data-table');
	
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td	>';
	    html += 	'<td>' + isnull(data[x].syrmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].qllxmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].qlxzmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mianji_pingfangmi) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=Details(' + data[x].id + ')>详情</a>';
	    html += '</td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

//修改操作
function modify(id) {
	var url = "zichan/byid";
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
	$('#shiyongren-select').children().each(function() {
		if($(this).val() == data.shiyongren) {
			$(this).attr('selected', 'selected');
		} else {
			$(this).removeAttr('selected');
		}
	});
	$('#gongyou-select').children().each(function() {
		if($(this).val() == data.gongyou) {
			$(this).attr('selected', 'selected');
		} else {
			$(this).removeAttr('selected');
		}
	});
	var zuoluo = $('#zuoluo').val(data.zuoluo);
	var danyuan_bh = $('#danyuan_bh').val(data.danyuan_bh);
	$('#quanli_lx-select').children().each(function() {
		if($(this).val() == data.quanli_lx) {
			$(this).attr('selected', 'selected');
		} else {
			$(this).removeAttr('selected');
		}
	});
	$('#quanli_xz-select').children().each(function() {
		if($(this).val() == data.quanli_xingzhi) {
			$(this).attr('selected', 'selected');
		} else {
			$(this).removeAttr('selected');
		}
	});
	var yongtu = $('#yongtu').val(data.yongtu);
	var quanli_qita = $('#quanli_qita').val(data.quanli_qita);
	var mianji_pingfangmi = $('#mianji_pingfangmi').val(data.mianji_pingfangmi);
	var mianji_mu = $('#mianji_mu').val(data.mianji_mu);
	var tuhao = $('#tuhao').val(data.tuhao);
	var dihao = $('#dihao').val(data.dihao);
	var mianji_shiyong = $('#mianji_shiyong').val(data.mianji_shiyong);
	var mianji_fentan = $('#mianji_fentan').val(data.mianji_fentan);
	var zhengjian_bianhao = $('#zhengjian_bianhao').val(data.zhengjian_bianhao);
	$('#zt-select').children().each(function() {
		if($(this).val() == data.zhengjian_zt) {
			$(this).attr('selected', 'selected');
		} else {
			$(this).removeAttr('selected');
		}
	});
	var qixian_kaishi = $('#qixian_kaishi').val(data.qixian_kaishi);
	var qixian_jieshu = $('#qixian_jieshu').val(data.qixian_jieshu);
	var zhengjain_bianhao_nianfen = $('#zhengjain_bianhao_nianfen').val(data.zhengjain_bianhao_nianfen);
	var zhengjian_rq = $('#zhengjian_rq').val(data.zhengjian_rq);
	
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#qixian_kaishi'//指定元素
		  });
		  laydate.render({
			    elem: '#qixian_jieshu'//指定元素
			  });
		  laydate.render({
			    elem: '#zhengjian_rq' //指定元素
			  });
		});
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
    da.qixian_kaishi = new Date(Date.parse(da.qixian_kaishi));
    da.qixian_jieshu = new Date(Date.parse(da.qixian_jieshu));
    da.zhengjian_rq = new Date(Date.parse(da.zhengjian_rq));
	var params=da;
	
	var url = 'zichan/update';
	callAjax(url, params, function(data) {
		layer.msg("修改成功");
		layer.close(index); 
		initTable();
	});
    return false;
  });	
});
}


function Details(id) {
	var url = "zichan/details";
	var param = {
			id : id
	};
	callAjax(url, param, function(data){
		doDetails(data.data);
	});
}

function doDetails(data) {
	$('#Detailmc').val(data.mc);
	$('#Detailshiyongren').val(data.syrmc);
	$('#Detailgongyou').val(data.gymc);
	$('#Detailzuoluo').val(data.zuoluo);
	$('#Detaildanyuan_bh').val(data.danyuan_bh);
	$('#Detailquanli_lx').val(data.qllxmc);
	$('#Detailquanli_xingzhi').val(data.qlxzmc);
	$('#Detailyongtu').val(data.yongtu);
	$('#Detailquanli_qita').val(data.quanli_qita);
	$('#Detailmianji_pingfangmi').val(data.mianji_pingfangmi);
	$('#Detailmianji_mu').val(data.mianji_mu);
	$('#Detailtuhao').val(data.tuhao);
	$('#Detaildihao').val(data.dihao);
	$('#Detailmianji_shiyong').val(data.mianji_shiyong);
	$('#Detailmianji_fentan').val(data.mianji_fentan);
	$('#Detailzhengjian_bianhao').val(data.zhengjian_bianhao);
	$('#Detailzhengjian_zt').val(data.zhengjian_zt);
	$('#Detailqixian_kaishi').val(data.qixian_kaishi);
	$('#Detailqixian_jieshu').val(data.qixian_jieshu);
	$('#Detailzhengjain_bianhao_nianfen').val(data.zhengjain_bianhao_nianfen);
	$('#Detailzhengjian_rq').val(data.zhengjian_rq);
	if(data.zhengjian_zt==0){
		$('#Detailzhengjian_zt').val("未办理不动产权证");
	}
	if(data.zhengjian_zt==1){
		$('#Detailzhengjian_zt').val("已办理不动产权证");
	}
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
		content : $('#DetailsDiv'),
		title : false,
		closeBtn : 0,
		shadeClose : true,
		area: ['650px', '500px'],
	});
}); 

$('#DetailcancelBtn').click(function() {
	layer.close(index);//关闭消息框
});
//layui.use('form', function(){
//	var form = layui.form;
//   //监听提交
//	form.on('submit(formDemo)', function(data){
//	$('#modifyUserForm')[0].reset();
//    var da=data.field;
//	var params=da;
//	var url = 'zichan/update';
//	callAjax(url, params, function(data) {
//		layer.msg("修改成功");
//		layer.close(index); 
//		initTable();
//	});
//    return false;
//  });	
//});
}

function isnull(obj){
	if (typeof(obj) == "undefined") { 
		   obj="";
		}
	return obj;
}


