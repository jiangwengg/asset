// 启用layer模块
layui.use([ 'laypage', 'form' ], function() {
	var laypage = layui.laypage;
	var form = layui.form;

});


var fileId = '';
layui.use('upload', function() {
	upload = layui.upload;
	upload.render({
		elem : '.tp',
		url : globleURL + 'file/change',
		multiple : true,
		accept : 'file', // 普通文件
		exts : 'dxf', // 只允许上传svg文件
		data : {
			path : "asset"
		},
		before : function(obj) {
			// 预读本地文件示例，不支持ie8
			obj.preview(function(index, file, result) {
				fileId = new Date().getTime();
			 });
		},
		done : function(res) {
			if (res.code == 200) {// 上传成功
				var data = res.data;
				var paths=data[0].path.split('.');
				var temp=paths[0]+'.'+'svg';
		        $('#showtz').append('<img  style="width: 80px;height: 80px;" id="'+ fileId +'"  onclick="fangda(\''+ picPath+temp +'\')"  src="'+ (picPath+temp) +'"  class="layui-upload-img">')
				$('#showtz').append('<input type="hidden"   id="file' + fileId + '"   name="file' + fileId + '"  value="' + data[0].path + '" > ');
			}
		}
	});
});


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