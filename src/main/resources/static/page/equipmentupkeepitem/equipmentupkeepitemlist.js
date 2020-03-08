layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 设备列表
var tableIns = table.render({
elem : '#userList',
url : '/equipmentupkeepitem/selectAllEquipmentupkeepitem',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [
	{type : "checkbox",upkeeped : "left",width : 100},
	{field : 'eupkeepitemid',title : '保养单号',width : 200,align : "center"}, 
	{field : 'eid',title : '设备档案号',width : 200,align : "center"}, 
	{field : 'eupkeepapplicanter',title : '申请人',width : 200,align : "center"}, 
	{field : 'eupkeeptime',title : '保养时间',width : 300,align : "center"}, 
	{field : 'eupkeeper',title : '保养人员',width : 150,align : "center"}, 
	{field : 'eproblems',title : '问题描述',width : 150,align : "center"}, 
	{field : 'ps',title : '备注信息',width : 200,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',upkeeped:"right",align:"center"}
] ]
});

// 搜索设备档案号
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/equipmentupkeepitem/selectEquipmentupkeepitemByByEid',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 20,
id : "userListTable",
where: {
key: $(".searchVal").val() //搜索的关键字
},
cols : [ [
	{type : "checkbox",upkeeped : "left",width : 100},
	{field : 'eupkeepitemid',title : '保养单号',width : 200,align : "center"}, 
	{field : 'eid',title : '设备档案号',width : 200,align : "center"}, 
	{field : 'eupkeepapplicanter',title : '申请人',width : 200,align : "center"}, 
	{field : 'eupkeeptime',title : '保养时间',width : 300,align : "center"}, 
	{field : 'eupkeeper',title : '保养人员',width : 150,align : "center"}, 
	{field : 'eproblems',title : '问题描述',width : 150,align : "center"}, 
	{field : 'ps',title : '备注信息',width : 200,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',upkeeped:"right",align:"center"}
] ]
});
} else {
layer.msg("请输入搜索的内容");
}
});


//添加
function addUser(edit){
var index = layui.layer.open({
title : "",
type : 2,
content : "equipmentupkeepitemAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".eid").val(edit.eid);
	body.find(".eupkeepapplicanter").val(edit.eupkeepapplicanter); 
	body.find(".eupkeeptime").val(edit.eupkeeptime); 
	body.find(".eupkeeper").val(edit.eupkeeper); 
	body.find(".eproblems").val(edit.eproblems); 
	body.find(".ps").val(edit.ps);
form.render();
}
setTimeout(function(){
	layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
	tips: 3
	});
},500)
}
})
layui.layer.full(index);
window.sessionStorage.setItem("index",index);
//改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
$(window).on("resize",function(){
layui.layer.full(window.sessionStorage.getItem("index"));
})
}
$(".addNews_btn").click(function(){
addUser();
})

//查看
function detailUser(edit){
var index = layui.layer.open({
title : "",
type : 2,
content : "equipmentupkeepitemDetail.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".eid").val(edit.eid);
	body.find(".eupkeepapplicanter").val(edit.eupkeepapplicanter); 
	body.find(".eupkeeptime").val(edit.eupkeeptime); 
	body.find(".eupkeeper").val(edit.eupkeeper); 
	body.find(".eproblems").val(edit.eproblems); 
	body.find(".ps").val(edit.ps);
form.render();
}
setTimeout(function(){
	layui.layer.tips('点击此处返回列表', '.layui-layer-setwin .layui-layer-close', {
	tips: 3
	});
},500)
}
})
layui.layer.full(index);
window.sessionStorage.setItem("index",index);
//改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
$(window).on("resize",function(){
layui.layer.full(window.sessionStorage.getItem("index"));
})
}
$(".addNews_btn").click(function(){
addUser();
})



// 列表操作
table.on('tool(userList)',
function(obj) {
var layEvent = obj.event, data = obj.data;
if (layEvent === 'edit') { // 编辑查看
	detailUser(data);
}else if (layEvent === 'del') { // 删除
layer.confirm('确定删除？',{icon:3, title:'提示信息'},
		function(index){
			$.get("/equipmentupkeepitem/deleteEquipmentupkeepitem",
					{eupkeepitemid : data.eupkeepitemid },//将需要删除的newsId作为参数传入
					function(data){
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
