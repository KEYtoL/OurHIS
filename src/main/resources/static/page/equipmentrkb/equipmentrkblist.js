layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 设备列表
var tableIns = table.render({
elem : '#userList',
url : '/equipmentrkb/selectAllEquipmentrkb',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [
	{type : "checkbox",fixed : "left",width : 100},
	{field : 'eid',title : '设备编号',width : 200,align : "center"}, 
	{field : 'ename',title : '设备名称',width : 300,align : "center"}, 
	{field : 'ecategory',title : '固资分类',width : 150,align : "center"}, 
	{field : 'keeper',title : '保管人',width : 150,align : "center"}, 
	{field : 'estatus',title : '目前使用状态',width : 200,align : "center"},
	{field : 'storagelocation',title : '存放地点',width : 150,align : "center"},
	{field : 'ps',title : '备注',width : 250,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});

// 搜索药品名
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/equipmentrkb/selectEquipmentrkbByEname',
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
	{field : 'eid',title : '设备编号',width : 200,align : "center"}, 
	{field : 'ename',title : '设备名称',width : 300,align : "center"}, 
	{field : 'ecategory',title : '固资分类',width : 150,align : "center"}, 
	{field : 'keeper',title : '保管人',width : 150,align : "center"}, 
	{field : 'estatus',title : '目前使用状态',width : 200,align : "center"},
	{field : 'storagelocation',title : '存放地点',width : 150,align : "center"},
	{field : 'ps',title : '备注',width : 250,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});
} else {
layer.msg("请输入搜索的内容");
}
});


//添加供应商
function addUser(edit){
var index = layui.layer.open({
title : "",
type : 2,
content : "equipmentrkbAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".erkid").val(edit.erkid); 
	body.find(".eid").val(edit.eid);
	body.find(".ename").val(edit.ename); 
	body.find(".ecategory").val(edit.ecategory); 
	body.find(".machineid").val(edit.machineid); 
	body.find(".productiondate").val(edit.productiondate); 
	body.find(".keeper").val(edit.keeper);
	body.find(".specificationid").val(edit.specificationid); 
	body.find(".usedate").val(edit.usedate);
	body.find(".guaranteeperiod").val(edit.guaranteeperiod); 
	body.find(".depreciationperiod").val(edit.depreciationperiod); 
	body.find(".ebrand").val(edit.ebrand); 
	body.find(".estatus").val(edit.estatus); 
	body.find(".originalprice").val(edit.originalprice); //药品名
	body.find(".monthdepression").val(edit.monthdepression); //药品名
	body.find(".storagelocation").val(edit.storagelocation); //药品名
	body.find(".submiter").val(edit.submiter); //药品名
	body.find(".ps").val(edit.ps); //药品名
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

//编辑
function editUser(edit){
var index = layui.layer.open({
title : "",
type : 2,
content : "equipmentrkbEdit.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
	body.find(".erkid").val(edit.erkid); 
	body.find(".eid").val(edit.eid);
	body.find(".ename").val(edit.ename); 
	body.find(".ecategory").val(edit.ecategory); 
	body.find(".machineid").val(edit.machineid); 
	body.find(".productiondate").val(edit.productiondate); 
	body.find(".keeper").val(edit.keeper);
	body.find(".specificationid").val(edit.specificationid); 
	body.find(".usedate").val(edit.usedate);
	body.find(".guaranteeperiod").val(edit.guaranteeperiod); 
	body.find(".depreciationperiod").val(edit.depreciationperiod); 
	body.find(".ebrand").val(edit.ebrand); 
	body.find(".estatus").val(edit.estatus); 
	body.find(".originalprice").val(edit.originalprice); //药品名
	body.find(".monthdepression").val(edit.monthdepression); //药品名
	body.find(".storagelocation").val(edit.storagelocation); //药品名
	body.find(".submiter").val(edit.submiter); //药品名
	body.find(".ps").val(edit.ps); //药品名
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

editUser(data);
}else if (layEvent === 'del') { // 删除
layer.confirm('确定删除此设备？',{icon:3, title:'提示信息'},
		function(index){
			$.get("/equipmentrkb/deleteEquipmentrkb",
					{erkid : data.erkid },//将需要删除的newsId作为参数传入
					function(data){
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
