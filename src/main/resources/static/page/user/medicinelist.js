layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/medicine/selectAllMedicine',
        cellMinWidth : 95,
        page : true,
        height : 350,
        limits : [10,15,20,25],
        limit : 20,
        id : "userListTable",
        cols : [[
            {field: 'mid', title: '药品编号', width:80, align:"center"},
            {field: 'mname', title: '药品名称', width:300, align:"center"},
            {field: 'mprice', title: '药品价格', width:100, align:"center"},
            {field: 'msize', title: '药品规格', width:100, align:"center"},
            {field: 'munit', title: '计数单位', width:80, align:"center"},
            {field: 'manufacturer', title: '生产厂家', width:300, align:"center"}
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
 
})
