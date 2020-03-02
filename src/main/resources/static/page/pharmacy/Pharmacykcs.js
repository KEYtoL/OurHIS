layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#pharmacykc',
        url : '/pharmacykc/selectAllPharmacykc',
        cellMinWidth : 95,
        page : true,
        height : 400,
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        cols : [[
        	{field: 'yfkcid', title: '库存编号', width:100, align:"center"},
            {field: 'medicine', title: '药品名称', width:300,templet: '<div>{{d.medicine.mname}}</div>', align:"center" },
            {field: 'medicine', title: '药品价格（元）', width:150,templet: '<div>{{d.medicine.mprice}}</div>', align:"center"},
            {field: 'medicine', title: '药品规格', width:150,templet: '<div>{{d.medicine.msize}}</div>', align:"center"},
            {field: 'medicine', title: '计数单位', width:100,templet: '<div>{{d.medicine.munit}}</div>', align:"center"},
            {field: 'medicine', title: '生产厂家', width:200,templet: '<div>{{d.medicine.manufacturer}}</div>', align:"center"},
            {field: 'yfkcnum', title: '库存数量', width:100, align:"center"},
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
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
    
    
    $(".addNews_btn").click(function(){
        addUser();
    });

  

   

})
