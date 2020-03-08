layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 设备列表
var tableIns = table.render({
elem : '#userList',
url : '/equipmentfixitem/selectAllEquipmentfixitem',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [
	{type : "checkbox",fixed : "left",width : 100},
	{field : 'efixitemid',title : '维修单号',width : 200,align : "center"}, 
	{field : 'eid',title : '设备档案号',width : 200,align : "center"}, 
	{field : 'efixapplicanter',title : '报修人',width : 200,align : "center"}, 
	{field : 'efixtime',title : '维修时间',width : 300,align : "center"}, 
	{field : 'efixer',title : '维修人员',width : 150,align : "center"}, 
	{field : 'eproblems',title : '问题描述',width : 150,align : "center"}, 
	{field : 'ps',title : '备注信息',width : 200,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});

// 搜索设备档案号
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/equipmentfixitem/selectEquipmentfixitemByByEid',
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
	{type : "checkbox",fixed : "left",width : 100},
	{field : 'efixitemid',title : '维修单号',width : 200,align : "center"}, 
	{field : 'eid',title : '设备档案号',width : 200,align : "center"}, 
	{field : 'efixapplicanter',title : '报修人',width : 200,align : "center"}, 
	{field : 'efixtime',title : '维修时间',width : 300,align : "center"}, 
	{field : 'efixer',title : '维修人员',width : 150,align : "center"}, 
	{field : 'eproblems',title : '问题描述',width : 150,align : "center"}, 
	{field : 'ps',title : '备注信息',width : 200,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
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
content : "equipmentfixitemAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".eid").val(edit.eid);
	body.find(".efixapplicanter").val(edit.efixapplicanter); 
	body.find(".efixtime").val(edit.efixtime); 
	body.find(".efixer").val(edit.efixer); 
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
content : "equipmentfixitemDetail.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".eid").val(edit.eid);
	body.find(".efixapplicanter").val(edit.efixapplicanter); 
	body.find(".efixtime").val(edit.efixtime); 
	body.find(".efixer").val(edit.efixer); 
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
			$.get("/equipmentfixitem/deleteEquipmentfixitem",
					{efixitemid : data.efixitemid },//将需要删除的newsId作为参数传入
					function(data){
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
