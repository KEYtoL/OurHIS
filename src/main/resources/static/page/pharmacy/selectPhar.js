//引入layui模块
layui.use(['form','layer','table','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        table = layui.table;
    
    
    //日期
    laydate.render({
      elem: '#cfdate'
    });


})
