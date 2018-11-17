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
	
	// 新增用户
	$('#addBtn').click(function () {
		 modify('');
	});
	
	//地址选择的监听
    window.addEventListener('message', function(event) {
        // 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
        var loc = event.data;
        if (loc && loc.module == 'locationPicker') {//防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
          console.log('location', loc);
          $('#address').val(loc.poiname);
          $('#zuobiao_x').val(loc.latlng.lat);
          $('#zuobiao_y').val(loc.latlng.lng);
        }
    }, false);
}


// 加载下拉选择查询条件
function initSelectList() {
	var url = 'zichan/list';
	callAjax(url, null, function(data) {
		printZc(data);
	})
}

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


function initTable() {
	// 根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zczb/pagelist';
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
	$("#data-table").empty();
	param.pageNum=page;
	var url = 'zczb/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + (x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zcMc) + '</td>';
	    html += 	'<td>' + isnull(data[x].bianhao) + '</td>';
	    html += 	'<td>' + isnull(data[x].zuobiao_x) + '</td>';
	    html += 	'<td>' + isnull(data[x].zuobiao_y) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
//	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteTz(' + data[x].id + ')>删除</a> ';
	    html +=' </td>'
	    html += '</tr>';
	}
	target.innerHTML = html;
}


//资产下拉框的change事件
layui.use('form', function(){
	var form = layui.form;
	form.on('select(zichanList)', function(data){
		callAjax("zczb/byzichan", {zcId:data.value}, function(data) {
			data=data.data;
			//清空数据
			$('#id').val('');
		    $('#bianhao').val('');
		    $('#zuobiao_x').val('');
		    $('#zuobiao_y').val('');
			if(data){
				doModify(data);
			}
		});	
	}); 
});

// 删除记录
//function deleteTz(id) {
//	layui.use('layer', function(){
//	var layer = layui.layer;
//	layer.open({
//		  content: '确定删除该记录？'
//		  ,btn: ['确定', '取消']
//		  ,yes: function(index, layero){
//			layer.close(index); // 关闭信息框
//			callAjax("zctz/change", {id:id,zt:"9"}, function(data) {
//				layer.msg("删除成功");
//				initTable();
//			});
//		  }
//	     ,btn2: function(index, layero){
//		  }
//		  ,cancel: function(){ 
//		  }
//		});
//	});	
//}
	
	
var index ='';
// 修改图片
function  modify(id){
	// 清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
	
	if(id){
		callAjax("zczb/byid", {id:id}, function(data) {
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
			area: ['800px', '700px'],
		})
	}); 
	
	$('#cancelBtn').click(function(){
		layer.close(index); 
	});
	
}

// 回显数据
function doModify(data){
	$('#id').val(data.id) ;
    $('#m-zichanList').val(data.zichan);
    $('#bianhao').val(data.bianhao);
    $('#zuobiao_x').val(data.zuobiao_x);
    $('#zuobiao_y').val(data.zuobiao_y);
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
		var url = 'zczb/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});
