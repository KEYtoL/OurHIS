layui.use('laydate', function(){
  var laydate = layui.laydate;
  // 开始时间
  laydate.render({
    elem: '#begin'
    ,type: 'datetime'
  });
  
  // 结束时间
  laydate.render({
    elem: '#end'
    ,type: 'datetime'
  });
  
})
// 引入layui模块
layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    // 值班列表
    var tableIns = table.render({
        elem: '#onduty',// 表id
        url : '/myduty/selectAllOndutyinfo',// 请求地址
        toolbar: '#toolbarDemo',
        cellMinWidth : 95,
        page : true,// 确认启动分页
        height : 400,
        limits : [10,15,20,25],// 分页大小选项
        limit : 10,// 默认大小
        // 请求参数名 页码默认page，页面大小为limit
        id : "mydutyTable",
        cols : [[
        	// '<div>{{d.medicine.mname}}</div>'
        	{field: 'odid', title: '值班ID', width:100, align:"center"},// 属性为对象需要加templet:
            {field: 'doctor', title: '门诊医生', width:150,templet: '<div>{{d.doctor.tname}}</div>', align:"center" },
            {field: 'odstart', title: '开始时间', width:302, align:"center"},
            {field: 'odend', title: '结束时间', width:302, align:"center"},
            {field: 'odroom', title: '门诊室', width:100, align:"center"},
            {field: 'keshi', title: '科室', width:100,templet: '<div>{{d.keshi.kname}}</div>', align:"center"},
            {field: 'ischangeshifts', title: '是否替班', width:100,templet: function(d){ return d.ischangeshifts==true ? "是":"否"},align:"center"},
            {field: 'changeinfo', title: '原值班医生', width:150, templet: '<div>{{d.changeinfo ? d.changeinfo.tname : "无" }}</div>', align:"center" },
            ]]
    });
    
    // 搜索(layui模板固定用法)点击请求
    $(".search_btn").on("click",function(){
            table.reload("mydutyTable",{
            	// 请求方式
            	method:'post',
                page: {
                    curr: 1 // 重新从第 1 页开始
                },
                where: {
                	// 参数列表
                    start: $("#begin").val(),  // 搜索的关键字
                    end: $("#end").val(),  // 搜索的关键字

                }
            });
       
    });
    
    
    $("input[name=mname]").css({
		"position":"relative"
	});
	
	$("#lns").css({
		"border":"1px #ccc solid",
		"width":"202px",
		"position":"absolute",
		"top":"37px",
		"left":"2px",
		"display":"none",
		"z-index":"999"
	});
	
	// 删除左右两端空格的方法
	 function trim(str){ // 删除左右两端的空格
	　　     return str.replace(/(^\s*)|(\s*$)/g, "");
	　　 }
	
	
	
    
    // 添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "userAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".userName").val(edit.userName);  // 登录名
                    body.find(".userEmail").val(edit.userEmail);  // 邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  // 性别
                    body.find(".userGrade").val(edit.userGrade);  // 会员等级
                    body.find(".userStatus").val(edit.userStatus);    // 用户状态
                    body.find(".userDesc").text(edit.userDesc);    // 用户简介
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
        // 改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    
    
    $(".addNews_btn").click(function(){
        addUser();
    });

  

   

})
