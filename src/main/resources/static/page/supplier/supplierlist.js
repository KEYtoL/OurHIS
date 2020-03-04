layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 设备列表
var tableIns = table.render({
elem : '#userList',
url : '/supplier/selectAllSupplier',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [
{type : "checkbox",fixed : "left",width : 100}, 
{field : 'spid',title : '供应商编号',width : 200,align : "center"}, 
{field : 'spname',title : '供应商名称',width : 300,align : "center"},
{field : 'spprinciplename',title : '负责人姓名',width : 150,align : "center"}, 
{field : 'spprincipletel',title : '负责人电话',width : 150,align : "center"},
{field : 'spprincipleemail',title : '负责人邮箱',width : 200,align : "center"},
{field : 'spprincipleaddress',title : '邮寄地址',width : 150,align : "center"},
{field : 'zzjgdmzid',title : '组织机构代码证',width : 250,align : "center"},
{field : 'zzjgdmzimg',title : '附件',width : 250,align : "center"},
{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
] ]
});

// 搜索药品名
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/supplier/selectSupplierBySpname',
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
	{field : 'spid',title : '供应商编号',width : 200,align : "center"}, 
	{field : 'spname',title : '供应商名称',width : 300,align : "center"},
	{field : 'spprinciplename',title : '负责人姓名',width : 150,align : "center"}, 
	{field : 'spprincipletel',title : '负责人电话',width : 150,align : "center"},
	{field : 'spprincipleemail',title : '负责人邮箱',width : 200,align : "center"},
	{field : 'spprincipleaddress',title : '邮寄地址',width : 150,align : "center"},
	{field : 'zzjgdmzid',title : '组织机构代码证',width : 250,align : "center"},
	{field : 'zzjgdmzimg',title : '附件',width : 250,align : "center"},
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
content : "supplierAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
body.find(".spid").val(edit.spid); 
body.find(".spname").val(edit.spname);
body.find(".spprinciplename").val(edit.spprinciplename); 
body.find(".spprincipletel").val(edit.spprincipletel); 
body.find(".spprincipleemail").val(edit.spprincipleemail); 
body.find(".spprincipleaddress").val(edit.spprincipleaddress); 
body.find(".zzjgdmzid").val(edit.zzjgdmzid); 
body.find(".zzjgdmzimg").val(edit.zzjgdmzimg); 
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

addUser(data);
}else if (layEvent === 'del') { // 删除
layer.confirm('确定删除此设备？',{icon:3, title:'提示信息'},
		function(index){
			$.get("/supplier/deleteSupplier",
					{spid : data.spid },//将需要删除的newsId作为参数传入
					function(data){
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
