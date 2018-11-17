var latlngs = [];  //经纬度
var names = [];  //名称
var zcIds = [];  //编号
//启用layer模块
layui.use(['laypage','form'],function(){
	var laypage = layui.laypage;
	var form = layui.form;
	initPage();
})


function initPage() {
	var url = 'zczb/list';
	callAjax(url, {}, function(data) {
		data = data.dataList;
		for ( var i = 0; i < data.length; i++) {
		   var point=new qq.maps.LatLng(data[i].zuobiao_x,data[i].zuobiao_y);
		   latlngs.push(point);
		   names.push(data[i].zcMc);
		   zcIds.push(data[i].zichan);
		   init();
		}
	});
}


var Marker = qq.maps.Marker;
var LatLng = qq.maps.LatLng;
var Event = qq.maps.event;

var MarkerImage = qq.maps.MarkerImage;
var MarkerShape = qq.maps.MarkerShape;
var MarkerAnimation = qq.maps.MarkerAnimation;
var Point = qq.maps.Point;
var Size = qq.maps.Size;
var ALIGN = qq.maps.ALIGN;

var init = function() {
	// 加载地图
	var map = new qq.maps.Map(document.getElementById("container"), {
		center : new qq.maps.LatLng(31.8318, 117.2080),
		zoom : 13
	});
	// 绑定单击事件添加参数
	qq.maps.event.addListener(map, 'click', function(event) {
		alert('您点击的位置为: [' + event.latLng.getLat() + ', '
				+ event.latLng.getLng() + ']');
	});

	// 添加控件
	var scaleControl = new qq.maps.ScaleControl({
		align : qq.maps.ALIGN.BOTTOM_LEFT,
		margin : qq.maps.Size(85, 15),
		map : map
	});

	
	//提示框
	var infoWin = new qq.maps.InfoWindow({
	    map: map
	});
	// 创建点
    for(var i = 0;i < latlngs.length; i++) {
        (function(n){
            var marker = new qq.maps.Marker({
                position: latlngs[n],
                map: map
            });
            qq.maps.event.addListener(marker, 'click', function() {
                infoWin.open();
                infoWin.setContent('<div style="text-align:center;white-space:'+
                'nowrap;margin:10px;">此处是 ' + names[n] + ' 资产</div>');
                infoWin.setPosition(latlngs[n]);
                
                loadLouCeng(zcIds[n]);
                loadTuPian(zcIds[n])
            });
        })(i);
    }
}

//加载图片
function  loadTuPian(zcid){
	$('.layui-upload-list').empty();
	callAjax("zctp/byzichan", {zcid:zcid}, function(data) {
		if(!(data.code == 200 && data.data)) {
			return;
		}
		data=data.data;
	    var fws=["dongdz","nandz","xidz","beidz","dongnandz","dongbeidz","xinandz","xibeidz"];
	    //显示图片
	    for(var t in fws){
	      var fangwei=fws[t];
	      var dzs=data[fangwei];
	      if(dzs!=undefined && dzs!=''){
	          var dz=dzs.split(',');
	          for(var m=0;m<dz.length;m++){
	           	  $('#showtp'+fangwei).append('<img  id="'+ (fangwei+m) +'"  src="'+picPath+dz[m] +'"   onclick="fangda(\''+picPath+dz[m]+ '\')"   class="layui-upload-img images">') 
	          }
	      }
	    }
	});	
}
//点击图片放大
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

//加载楼层表格
var param={};
function loadLouCeng(zcId){
	var url = 'zl/pagelist';
	var param = {
			zichanId:zcId,
			pageNum:1,
			numPerPage:10
	};
	callAjax(url, param,function(data){
		if(!(data.code == 200 && data.dataList)) {
			return;
		}
		initTableBack(data);
	});
}

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

function jumpTo(page) {
	$("#data-table").empty();
    param.pageNum = page;
	var url = 'zl/pagelist';
	callAjax(url, param, function (data) {printTable(data.dataList);});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + isnull(data[x].zcmc) + '</td	>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' + isnull(data[x].bh) + '</td>';
	    html += 	'<td>' + isnull(data[x].mianji) + '</td>';
	    html +=     '<td><a href="javascript:;" class="layui-btn" onclick=chakan(' + data[x].zichan + ',' + data[x].id + ')>查看房间</a></td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}

//查看房间
function chakan(zichanId,loucengId){
	var index ='';
	layui.use('layer', function(){
		var layer = layui.layer;
		index=layer.open({
			type : 1,
			content : $('#fangjianList'),
			title : false,
			closeBtn : 0,
			shadeClose : true,
			area: ['800px', '500px'],
		});
	}); 
	
	initFangjian(zichanId,loucengId);
	
	$('#cancelBtn').click(function() {
		layer.close(index);//关闭消息框
	});
}

//加载房间列表
var fangjianParam={};
function initFangjian(zichanId,loucengId) {
	// 根据用户设置的查询条件获取数据，生成分页并跳转至第一页
	var url = 'zlf/pagelist';
	fangjianParam.pageNum=1;
	fangjianParam.numPerPage=10;
	fangjianParam.zichan=zichanId;
	fangjianParam.louceng=loucengId;
	callAjax(url, fangjianParam,function(data){
		if(!(data.code == 200 && data.dataList)) {
			return;
		}
		initFjTableBack(data);
	});
}

function initFjTableBack(data) {
	// 重新获取laypage实例
	layui.use('laypage', function(laypage) {
		laypage.render({
			elem : 'myfangjian-table',
			limit : 10,
			count : data.totalCount,
		
			// 首次加载不执行jumpTo，避免重复ajax浪费性能
			jump : function (obj, first) {
				if(!first){
					jumpFjTo(obj.curr);
				}
			},
			layout : ['prev', 'page', 'next', 'count']
		});
		printFjTable(data.dataList);
	});
}

//跳页不涉及查询对象属性的改变
function jumpFjTo(page) {
	$("#fangjian-table").empty();
	fangjianParam.pageNum=page;
	var url = 'zlf/pagelist';
	callAjax(url, fangjianParam, function (data) {printFjTable(data.dataList);});
}

function printFjTable(data) {
	var target = document.getElementById('fangjian-table');
	var html = '';
	for (var x = 0; x < data.length; x++) {
	    html += '<tr>';
	    html += 	'<td>' + (x+1) + '</td	>';
	    html += 	'<td>' + isnull(data[x].zichanMc) + '</td>';
	    html += 	'<td>' + isnull(data[x].lou_cengMc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mc) + '</td>';
	    html += 	'<td>' + isnull(data[x].mianji) + ' m²</td>';
	    html += 	'<td>' + isnull(data[x].renyuanMc) + '</td>';
	    html += '</tr>';
	}
	target.innerHTML = html;
}