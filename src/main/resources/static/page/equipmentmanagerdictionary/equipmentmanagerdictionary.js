layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 字典列表
var tableIns = table.render({
elem : '#userList',
url : '/equipmentmanagerdictionary/selectAllEquipmentmanagerdictionary',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [
	{type : "checkbox",fixed : "left",width : 100}, 
	{field : 'emdid',title : '部门编号',width : 200,align : "center"}, 
	{field : 'keshi',title : '部门名称',width : 300,align : "center"},
	{field : 'emanager',title : '管理员',width : 150,align : "center"}, 
	{field : 'efix',title : '维修员',width : 150,align : "center"},
	{field : 'eupkeeper',title : '保养员',width : 200,align : "center"},
	{field : 'keshileader',title : '部门领导',width : 150,align : "center"},
	{field : 'submiter',title : '提交人',width : 250,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});

// 搜索药品名
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/equipmentmanagerdictionary/selectEquipmentmanagerdictionaryByEmdame',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 10, 15, 20, 25 ],
limit : 20,
id : "userListTable",
where: {
key: $(".searchVal").val() //搜索的关键字
},
cols : [ [
	{type : "checkbox",fixed : "left",width : 100}, 
	{field : 'emdid',title : '部门编号',width : 200,align : "center"}, 
	{field : 'keshi',title : '部门名称',width : 300,align : "center"},
	{field : 'emanager',title : '管理员',width : 150,align : "center"}, 
	{field : 'efix',title : '维修员',width : 150,align : "center"},
	{field : 'eupkeeper',title : '保养员',width : 200,align : "center"},
	{field : 'keshileader',title : '部门领导',width : 150,align : "center"},
	{field : 'submiter',title : '提交人',width : 250,align : "center"},
	{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});
} else {
layer.msg("请输入搜索的内容");
}
});


//添加设备
function addUser(edit){
var index = layui.layer.open({
title : "",
type : 2,
content : "equipmentmanagerdictionaryAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
body.find(".emdid").val(edit.emdid); //药品名
body.find(".keshi").val(edit.keshi); //药品名
body.find(".emanager").val(edit.emanager); //药品名
body.find(".efix").val(edit.efix); //药品名
body.find(".eupkeeper").val(edit.eupkeeper); //药品名
body.find(".keshileader").val(edit.keshileader); //药品名
body.find(".submiter").val(edit.submiter); //药品名
form.render();
}
setTimeout(function(){
layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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
content : "equipmentmanagerdictionaryEdit.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
body.find(".emdid").val(edit.emdid); 
body.find(".keshi").val(edit.keshi); 
body.find(".emanager").val(edit.emanager); 
body.find(".efix").val(edit.efix); 
body.find(".eupkeeper").val(edit.eupkeeper); 
body.find(".keshileader").val(edit.keshileader); 
body.find(".submiter").val(edit.submiter); 
form.render();
}
setTimeout(function(){
layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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
// 批量删除
$(".delAll_btn")
.click(
function() {
var checkStatus = table
.checkStatus('userListTable'), data = checkStatus.data, newsId = [];
if (data.length > 0) {
for ( var i in data) {
newsId.push(data[i].newsId);
}
layer.confirm('确定删除选中的用户？', {
icon : 3,
title : '提示信息'
}, function(index) {
// $.get("删除文章接口",{
// newsId : newsId
// //将需要删除的newsId作为参数传入
// },function(data){
tableIns.reload();
layer.close(index);
// })
})
} else {
layer.msg("请选择需要删除的用户");
}
})

// 列表操作
table.on('tool(userList)',
function(obj) {
var layEvent = obj.event, data = obj.data;

if (layEvent === 'edit') { // 编辑

editUser(data);
} else if (layEvent === 'detail') { //查看
    console.log(data);
    addUser(data);	
} else if (layEvent === 'del') { // 删除
layer.confirm('确定删除？',{icon:3, title:'提示信息'},
		function(index){
			$.get("/equipmentmanagerdictionary/deleteEquipmentmanagerdictionary",
					{emdid : data.emdid },//将需要删除的Id作为参数传入
					function(data){
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
