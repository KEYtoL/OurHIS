//引入layui模块
layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#pharmacykc',//表id
        url : '/pharmacykc/selectAllPharmacykc',//请求地址
        cellMinWidth : 95,
        page : true,//确认启动分页
        height : 400,
        limits : [10,15,20,25],//分页大小选项
        limit : 10,//默认大小
        //请求参数名 页码默认page，页面大小为limit
        id : "pharmacykcTable",
        cols : [[
        	{field: 'yfkcid', title: '库存编号', width:100, align:"center"},//属性为对象需要加templet: '<div>{{d.medicine.mname}}</div>'
            {field: 'medicine', title: '药品名称', width:300,templet: '<div>{{d.medicine.mname}}</div>', align:"center" },
            {field: 'medicine', title: '药品价格（元）', width:150,templet: '<div>{{d.medicine.mprice}}</div>', align:"center"},
            {field: 'medicine', title: '药品规格', width:150,templet: '<div>{{d.medicine.msize}}</div>', align:"center"},
            {field: 'medicine', title: '计数单位', width:100,templet: '<div>{{d.medicine.munit}}</div>', align:"center"},
            {field: 'medicine', title: '生产厂家', width:200,templet: '<div>{{d.medicine.manufacturer}}</div>', align:"center"},
            {field: 'yfkcnum', title: '库存数量', width:100, align:"center"},
        ]]
    });
    
    //搜索(layui模板固定用法)点击请求
    $(".search_btn").on("click",function(){
            table.reload("pharmacykcTable",{
            	//请求方式
            	method:'post',
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                	//参数列表
                    mname: $(".searchVal").val(),  //搜索的关键字
                    key: $("input[name='selectA']:checked").val()  //搜索的关键字

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
	
	//删除左右两端空格的方法
	 function trim(str){ //删除左右两端的空格
	　　     return str.replace(/(^\s*)|(\s*$)/g, "");
	　　 }
	
	// 键盘松开的时候Ajax请求
	$("input[name=mname]").keyup(function(){
		var mname = $(this).val();
		if(mname != ""){
			$.ajax({
				url:"/pharmacykc/selectMname",
				type:"post",
				data:{"mname":mname},
				dataType:"html",
				async:true,
				success:function(result){
					$("#lns").show();
					$("#lns").html(result);
					
					// 点击模糊列表的值，并且赋值
					$(".choose").click(function(){
						$("input[name=mname]").val(trim($(this).text()));
						$("input[name=mname]").focus();
						$("#lns").hide();
					});
					
					$("body").click(function(){
						$("#lns").hide();
						
					});
				
				}
			});
		}else{
			$("#lns").html("");
			$("#lns").hide();
		}
	});
	
    
    //添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "userAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
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
    
   

  

   

})
