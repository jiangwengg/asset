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
	var url = 'zctp/pagelist';
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
	var url = 'zctp/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + (x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' +( data[x].dongdz == null?'':conertPicPath(data[x].dongdz.split(',')[0])) + '</td>';
	    html += 	'<td>' +( data[x].xidz == null?'':conertPicPath(data[x].xidz.split(',')[0]))+ '</td>';
	    html += 	'<td>' +( data[x].nandz == null?'':conertPicPath(data[x].nandz.split(',')[0])) + '</td>';
	    html += 	'<td>' +( data[x].beidz == null?'':conertPicPath(data[x].beidz.split(',')[0])) + '</td>';
	    html += 	'<td>' +( data[x].dongnandz == null?'':conertPicPath(data[x].dongnandz.split(',')[0]))  + '</td>';
	    html += 	'<td>' +( data[x].dongbeidz == null?'':conertPicPath(data[x].dongbeidz.split(',')[0])) + '</td>';
	    html += 	'<td>' +( data[x].xinandz == null?'':conertPicPath(data[x].xinandz.split(',')[0])) + '</td>';
	    html += 	'<td>' +( data[x].xibeidz == null?'':conertPicPath(data[x].xibeidz.split(',')[0])) + '</td>';
	    html += '<td><a href="javascript:;" class="layui-btn" onclick=modify(' + data[x].id + ')>修改</a>';
	    html += '<a href="javascript:;" class="layui-btn" onclick=delete(' + data[x].id + ')>删除</a> </td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}



//资产下拉框的change事件
layui.use('form', function(){
	var form = layui.form;
	form.on('select(zichanList)', function(data){
		callAjax("zctp/byzichan", {zcid:data.value}, function(data) {
			data=data.data;
			//清空数据
			$('#modifyForm .pathValue input').val('');
			$('#modifyForm img').remove();
			$('.layui-upload-list').empty();
			$('#id').val('');
			if(data){
				doModify(data);
			}
			
		});	
	}); 
});




var index ='';
// 修改图片
function  modify(id){
	//清空数据
	$('#modifyForm input').val('');
	$('#modifyForm select').val('');
	$('#modifyForm img').remove();
	$('.layui-upload-list').empty();
	
	if(id){
		callAjax("zctp/byid", {id:id}, function(data) {
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
			area: ['900px', '700px'],
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
    var fws=["dongdz","nandz","xidz","beidz","dongnandz","dongbeidz","xinandz","xibeidz"];
    //显示图片
    for(var t in fws){
      var fangwei=fws[t];
      var dzs=data[fangwei];
      if(dzs!=undefined && dzs!=''){
          var dz=dzs.split(',');
       	  $('#showtp'+fangwei).append('<input type="hidden"   class="pathValue"   id="'+fangwei+'"   name="'+fangwei+'"  value="'+dzs+'"  >    ');
          for(var m=0;m<dz.length;m++){
           	  $('#showtp'+fangwei).append('<img  id="'+ (fangwei+m) +'"  src="'+picPath+dz[m] +'"  class="layui-upload-img images">') 
			  $('#showtp'+fangwei).append(' <button  onclick="deleteTp(\''+ (fangwei+m) +'\')" class="layui-btn layui-btn-normal layui-btn-sm  my-del"><i class="layui-icon"></i></button>');
          }
      }
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
		var url = 'zctp/update';
		callAjax(url, params, function(data) {
			layer.msg("保存成功");
			layer.close(index); 			
			initTable();
		});
	    return false;
	  });	
	});


	var fangwe='';
	layui.use('upload', function(){
		  upload = layui.upload;
		  // 多图片上传
		  upload.render({
		    elem: '.tp'
		    ,url: globleURL+'file/upload'
		    ,multiple: true
		    ,data: {path:"asset"} //可选项。额外的参数
		    ,before: function(obj){
		      // 预读本地文件示例，不支持ie8
		      console.log('接口地址：'+ this.fangwei, this.item, {tips: 1});
		      fangwei=this.fangwei;
		      obj.preview(function(index, file, result){
	    		 var nextTp='0';
	    		 if($('#'+fangwei).val() != undefined){
	    			 nextTp = $('#'+fangwei).val().split(',').length+1; 
		         }	    			
		         $('#showtp'+fangwei).append('<img  id="'+ file.name +'"   src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img images">')
			     $('#showtp'+fangwei).append(' <button  onclick="deleteTp(\''+ (fangwei+nextTp)+'\')" class="layui-btn layui-btn-normal layui-btn-sm  my-del"><i class="layui-icon"></i></button>');
		      });
		    }
		    ,done: function(res){
		    	if(res.code == 200){//上传成功
		    		var data=res.data;
		    		if($('#'+fangwei).length<1){
			    		 $('#showtp'+fangwei).append('<input type="hidden"  class="pathValue"  id="'+fangwei+'"   name="'+fangwei+'"  value="'+ data[0].path +'" >    ');
		    		}else{
		    			var  value=$('#'+fangwei).val();
		    			value=value+","+data[0].path;
		    			$('#'+fangwei).val(value);
		    		}
		    	}
		    	console.log(res);
		      // 上传完毕
		    }
		});
	});
	
	
	//点击图片 删除图片
	deleteTp=function(filename){
		console.log("delete..."+filename);
		var tag= ($('#'+filename)[0].src).replace(picPath,'');
		var shuzi=filename.match(/\d+/ig);
        var pos=filename.indexOf(shuzi);
		$('#'+filename).hide();
		$('#'+filename).next().hide();
        var  paths= filename.substring(0,pos);
        var zhi=$('#'+paths).val();
        zhi=zhi.replace(tag,'');
        $('#'+paths).val(zhi);
	}
	
	
	//转换图片地址
  function conertPicPath(obj) {
		if (typeof (obj) == "undefined" || obj =='') {
			obj = "";
		}else{
			obj=picPath+obj
			obj='<img src="'+obj+ '"   onclick="fangda(\''+obj+ '\')"  >';
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