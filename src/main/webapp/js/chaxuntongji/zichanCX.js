//预定义查询对象
var param = {
		zcmc : "",
		pageNum:1,
		numPerPage:10
};
//启用layer模块
layui.use(['laypage','form'],function(){
	var laypage = layui.laypage;
	var form = layui.form;
	
	initPage();
})

function initPage(){
	initTable();
}

function initTable(){
	var url = "zichanCX/pagelist";
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
			elem : 'my-page',
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
	var _data = {
			zcmc : "",
			pageNum:page,
			numPerPage:10	
	};
	var url = 'zichanCX/pagelist';
	callAjax(url, _data, function (data) {
		printTable(data.dataList);
	});
}

function printTable(data) {
	var target = document.getElementById('data-table');
	var html = '';
	for ( var x = 0; x < data.length; x++) {
		html += '<tr>';
		html += '<td>' + data[x].zcmc + '</td>';
		html += '<td>' + data[x].syrmc + '</td>';
		html += '<td>' + data[x].zcgymc + '</td>';
		html += '<td>' + data[x].zuoluo + '</td>';
		html += '<td>' + data[x].danyuan_bh + '</td>';
		html += '<td>' + data[x].lxmc+ '</td>';
		html += '<td>' + data[x].yongtu + '</td>';
		html += '<td>' + data[x].mianji_pingfangmi + ' m²</td>';
		html += '<td>' + data[x].kaishi + ' 至  '+ data[x].jieshu +'</td>';
		html += '<td>' + data[x].quanli_qita + '</td>';
		html += '<td>' + data[x].yhmc + '</td>';
		html += '</tr>'
	}
	target.innerHTML = html;
}