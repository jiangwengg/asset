var form =null;
var lx=getQueryString("lx");
$('#lx').val(lx);
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
	
	//新增用户
	$('#addBtn').click(function () {
		 modify('');
	});
	
	form.on('select(zichan)', function(data){
		callAjax("zl/list", {zichan:data.value}, function(data) {
			printChangeSelect('lou_ceng',data.dataList,'id','mc','')
		})	
	});  

	form.on('select(lou_ceng)', function(data){
		callAjax("zlf/list", {zichanId:$('#zichan').val(),lcid:data.value}, function(data) {
			printChangeSelect('fang_jian',data.dataList,'id','mc','')
		})	
	});  
	
}

//渲染下拉框
function printChangeSelect(tag,data,key,value,checkvalue) {
	var target = document.getElementById(tag);
	var html = '<option value class="id"> 请选择</option>';
	for (var x = 0; x < data.length; x++) {
		var tempName="";
		if(data[x][value] != undefined){
			tempName=data[x][value];
		}
		if(data[x][key] == checkvalue){
			html += '<option selected class="'+tag+'Option" value="' + data[x][key] + '">' + tempName + '</option>';
		}else{
			html += '<option class="'+tag+'Option" value="' + data[x][key] + '">' + tempName + '</option>';
		}
	}
	target.innerHTML = html;
	form.render();
}

// 加载下拉选择查询条件
function initSelectList() {
	callAjax('zichan/list', null, function(data) {
		printZc(data.dataList);
	})
	
	callAjax('zl/list', null, function(data) {
		printSelect('lou_ceng',data.dataList,'id','mc')
	})
	
	callAjax('zlf/list', null, function(data) {
		printSelect('fang_jian',data.dataList,'id','mc')
	})
}



// 渲染资产下拉框
function printZc(data) {
	var target = document.getElementById('zichanList');
	var html = ''
	for (var x = 0; x < data.length; x++) {
		html += '<option class="zcOption" value="' + data[x].id + '">' + data[x].mc + '</option>'
	}
	target.innerHTML += html
	// 新增和修改窗口
	document.getElementById('zichan').innerHTML += html
	// 重新渲染DOM
	layui.use('form', function(){
		var form = layui.form;
		form.render('select');
	});
}


function initTable() {
	// 根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zcbj/pagelist';
	var paramForm = document.getElementById('paramFrom');
	param = formToJson(paramForm);
	param.lx=lx;
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
	param.lx=lx;
	param.pageNum=page;
	param.numPerPage=10;
	var url = 'zcbj/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].zcmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' + isnull(data[x].bianhao) + '</td>';
	    if(data[x].fwlx  == 1){
		    html += 	'<td>关联楼宇</td>';
	    }else if(data[x].fwlx  == 2){
	    	 html += 	'<td>关联楼层</td>';
	    }else{
	    	 html += 	'<td>关联房间</td>';
	    }
	    html += 	'<td>' + isnull(data[x].fjs) + '</td>';
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
		callAjax("zcbj/byid", {id:id}, function(data) {
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
		printChangeSelect('lou_ceng',result.dataList,'id','mc',data.lou_ceng)
	})	

	callAjax("zlf/list", {zichanId:data.zichan,lcid:data.lou_ceng}, function(result) {
		printChangeSelect('fang_jian',result.dataList,'id','mc',data.fang_jian)
	})	
 
	$('#id').val(data.id) ;
    $('#mc').val(data.mc) ;
    $('#bianhao').val(data.bianhao) ;
    $('#gllx').val(data.gllx) ;
    $('#zichan').val(data.zichan);
//    $('#fang_jian').val(data.fang_jian);
//    $('#lou_ceng').val(data.lou_ceng);
    
	
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
		params.lx=lx;
		var url = 'zcbj/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});



