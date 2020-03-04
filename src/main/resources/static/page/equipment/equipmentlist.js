layui
.use(
[ 'form', 'layer', 'table', 'laytpl' ],
function() {
var form = layui.form, layer = parent.layer === undefined ? layui.layer
: top.layer, $ = layui.jquery, laytpl = layui.laytpl, table = layui.table;

// 设备列表
var tableIns = table.render({
elem : '#userList',
url : '/equipment/selectAllEquipment',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 1,10, 15, 20, 25 ],
limit : 10,
id : "userListTable",
cols : [ [{
type : "checkbox",
fixed : "left",
width : 100
}, {
field : 'eid',
title : '设备编号',
width : 200,
align : "center"
}, {
field : 'ename',
title : '设备名称',
width : 300,
align : "center"
}, {
field : 'ecategory',
title : '固资分类',
width : 150,
align : "center"
}, {
field : 'keeper',
title : '保管人',
width : 150,
align : "center"
}, {
field : 'estatus',
title : '目前使用状态',
width : 200,
align : "center"
},{
field : 'storagelocation',
title : '存放地点',
width : 150,
align : "center"
},
{field : 'ps',title : '备注',width : 250,align : "center"},
{title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}

] ]
});

// 搜索药品名
$(".search_btn").on("click", function() {
if ($(".searchVal").val() != '') {
table.render({
elem : '#userList',
url : '/equipment/selectEquipmentByEname',
cellMinWidth : 95,
page : true,
height : "full-125",
limits : [ 10, 15, 20, 25 ],
limit : 20,
id : "userListTable",
where: {
key: $(".searchVal").val() //搜索的关键字
},
cols : [ [{
type : "checkbox",
fixed : "left",
width : 100
}, {
field : 'eid',
title : '设备编号',
width : 100,
align : "center"
}, {
field : 'ename',
title : '设备名称',
width : 300,
align : "center"
}, {
field : 'ecategory',
title : '固资分类',
width : 200,
align : "center"
}, {
field : 'keeper',
title : '保管人',
width : 100,
align : "center"
}, {
field : 'estatus',
title : '目前使用状态',
width : 200,
align : "center"
},{
field : 'storagelocation',
title : '存放地点',
width : 200,
align : "center"
},
{
field : 'ps',
title : '备注',
width : 300,
align : "center"
} ] ]
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
content : "equipmentAdd.html",
success : function(layero, index){
var body = layui.layer.getChildFrame('body', index);
if(edit){
body.find(".eid").val(edit.eid); //药品名
body.find(".ename").val(edit.ename); //药品名
body.find(".ecategory").val(edit.ecategory); //药品名
body.find(".machineid").val(edit.machineid); //药品名
body.find(".productiondate").val(edit.productiondate); //药品名
body.find(".keeper").val(edit.keeper); //药品名
body.find(".specificationid").val(edit.specificationid); //药品名
body.find(".usedate").val(edit.usedate); //药品名
body.find(".guaranteeperiod").val(edit.guaranteeperiod); //药品名
body.find(".depreciationperiod").val(edit.depreciationperiod); //药品名
body.find(".ebrand").val(edit.ebrand); //药品名
body.find(".estatus").val(edit.estatus); //药品名
body.find(".originalprice").val(edit.originalprice); //药品名
body.find(".monthdepression").val(edit.monthdepression); //药品名
body.find(".storagelocation").val(edit.storagelocation); //药品名
body.find(".ps").val(edit.ps); //药品名



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

addUser(data);
} else if (layEvent === 'detail') { //查看
    console.log(data);
    addUser(data);
//    layer.open({
//    	  type: 2, 
//    	  content: '/page/equipment/equipmentDetails.html',
//    	  area: ['800px', '600px']//这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
//    	}); 
//    $.ajax({
//        url: "/equipment/selectEquipmentDetial",
//        type: "POST",
//        data:{"eid":data.eid},
//        dataType: "json",
//        success: function(data){
//        	console.log(data);
//        }
//
//    });
	
	
} else if (layEvent === 'del') { // 删除
layer.confirm('确定删除此设备？',{icon:3, title:'提示信息'},
		function(index){
			$.get("/equipment/deleteEquipment",
					{eid : data.eid },//将需要删除的newsId作为参数传入
					function(data){
					
					tableIns.reload();
					layer.close(index);
					})
				});
}
});

})
