//预定义查询对象
var param = {
		zichan:'',
		keywords:''
};

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
	var url = 'zctz/pagelist';
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
	var url = 'zctz/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + (x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zcmc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>'  ;
	    var dzs=data[x].dz.split(',');
	    for(var t in dzs){
	    	html += conertPicPath(dzs[t])
	    }
	    html +=  '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=deleteTz(' + data[x].id + ')>删除</a> </td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

	//删除记录
	function deleteTz(id) {
		layui.use('layer', function(){
		var layer = layui.layer;
		layer.open({
			  content: '确定删除该记录？'
			  ,btn: ['确定', '取消']
			  ,yes: function(index, layero){
				layer.close(index); //关闭信息框 
				callAjax("zctz/change", {id:id,zt:"9"}, function(data) {
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
// 修改图片
function  modify(id){
	//清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
	$('#modifyForm img').remove();
	
	if(id){
		callAjax("zctz/byid", {id:id}, function(data) {
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
    $('#m-zichanList').val(data.zichan);
    $('#mc').val(data.mc);
    //显示图纸
    var dzs=data.dz;
    var dz=dzs.split(',');
    for(var t=0;t< dz.length; t++){
    	var fileId=new Date().getTime();
       	$('#showtz').append('<input type="hidden"   id="file'+fileId+'"   name="file'+fileId+'"  value="'+dz[t]+'"  >    ');
        $('#showtz').append('<img  style="width: 50px;height: 50px;" id="'+ fileId +'"  onclick="deleteTp(\''+ fileId +'\')"  src="'+picPath+dz[t] +'"  class="layui-upload-img">')
    }


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
		//设置图纸地址
		var file=$('[id^=file]');
		var f=[];
		for(var m=0; m<file.length; m++){
			if(file[m].value){
			 f.push(file[m].value);
			}
		}
		params.dz=f.join(',');
		
		var url = 'zctz/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});


	var fileId='';
	layui.use('upload', function(){
		  upload = layui.upload;
		  // 多图片上传
		  upload.render({
		     elem: '.tp'
		    ,url: globleURL+'file/upload'
		    ,multiple: true
		    ,accept: 'file' //普通文件
		    ,exts: 'svg' //只允许上传svg文件
		    ,data: {path:"asset"} //可选项。额外的参数
		    ,before: function(obj){
		      // 预读本地文件示例，不支持ie8
		      obj.preview(function(index, file, result){
		    	fileId=new Date().getTime();
		        $('#showtz').append('<img  style="width: 50px;height: 50px;" id="'+ fileId +'"  onclick="deleteTp(\''+ fileId +'\')"  src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
		      });
		    }
		    ,done: function(res){
		    	if(res.code == 200){// 上传成功
		    		var data=res.data;
		    		 $('#showtz').append('<input type="hidden"   id="file'+fileId+'"   name="file'+fileId+'"  value="'+ data[0].path +'" >    ');
		    	   }
		      // 上传完毕
		    }
		});
	});
	
	
	//点击图片 删除图片
	deleteTp=function(filename){
		$('#'+filename).hide();
		$('#file'+filename).remove();
	}
	
	
	//转换图片地址
  function conertPicPath(obj) {
		if (typeof (obj) == "undefined") {
			obj = "";
		}else{
			obj=picPath+obj
		//	obj='	<embed  src="'+obj+ '" width="300" height="100"  type="image/svg+xml"  	pluginspage="http://www.adobe.com/svg/viewer/install/" />  ';
			obj='<img src="'+obj+ '"   onclick="fangda(\''+obj+ '\')"   >';
		}
		return obj;
	}
  
  function fangda(tupian){
	layui.use('layer', function(){
		var layer = layui.layer;  
	      // 放大预览图片
	      layer.open({
	          type: 1,
	          title: false,
	          closeBtn: 1,
	          shadeClose: true,
	          area: ['700px','600px'], // 宽高
	          content: '<img width="700" height="600" src="' + tupian +'" />'
	      });
	  });
 }