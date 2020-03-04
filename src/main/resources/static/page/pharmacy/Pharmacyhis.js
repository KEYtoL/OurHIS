//引入layui模块
layui.use(['form','layer','table','laydate'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        table = layui.table;
    
    
    //日期
    laydate.render({
      elem: '#date'
    });


    //用户列表
    var tableIns = table.render({
        elem: '#pharmacyhis',//表id
        url : '/pharmacy/selectHisPharmacy',//请求地址
        cellMinWidth : 95,
        page : true,//确认启动分页
        height : 400,
        limits : [10,15,20,25],//分页大小选项
        limit : 10,//默认大小
        //请求参数名 页码默认page，页面大小为limit
        id : "pharmacyhisTable",
        cols : [[
        	{field: 'yfnum', title: '序号', width:80, align:"center"},
        	{field: 'yfid', title: '入库编号', width:330, align:"center"},
        	//属性为对象需要加templet: '<div>{{d.medicine.mname}}</div>'
        	{field: 'yfcount', title: '总价', width:160, align:"center"},
        	{field: 'yfdate', title: '入库时间', width:190, align:"center",
        templet: "<div>{{ layui.util.toDateString(d.yfdate,'yyyy-MM-dd HH:mm:ss')}}</div>"},
        	{field: 'yfuser', title: '经手人', width:160, align:"center"},
            {title: '操作', minWidth:50, templet:'#pharmacyhisListBar',fixed:"right",align:"center"}
        ]]
    });
    
    
    //搜索(layui模板固定用法)点击请求
    $(".search_btn").on("click",function(){
            table.reload("pharmacyhisTable",{
            	//请求方式
            	method:'post',
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                	//参数列表
                	yfdate : $("#date").val(),
                    selectWay: $(this).attr("value"),  //搜索的关键字
                    
                }
            });
       
    });
    
  //添加用户
    function selectmx(edit){
        var index = layui.layer.open({
            title : "入库详情",
            type : 2,
            content : "pharmacymx.html",
            success : function(layero, index){
            	 var body = layui.layer.getChildFrame('body', index);
                $.get("/pharmacy/selectPharmacyByYfid", {
            		yfid : edit.yfid
            	}, function(data) {
            		$(".x").remove();
            		$(data).each(function() {
            			var html = "<tr class='x'>";
            			html += "<th>" + this.medicine.mname + "</th>";
            			html += "<th>" + this.medicine.msize + "</th>";
            			html += "<th>" + this.medicine.munit + "</th>";
            			html += "<th>" + this.medicine.manufacturer + "</th>";
            			html += "<th>" + this.medicine.mprice + "</th>";
            			html += "<th>" + this.yfmxnum + "</th>";
            			html += "<th>" + this.yfmxcount + "</th>";
            			html += "</tr>";
            			$(html).appendTo(body.find("#mxtable"));
            		});
            	});
               
                
                setTimeout(function(){
                    layui.layer.tips('点击此处返回入库列表', '.layui-layer-setwin .layui-layer-close', {
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
    
    
    //列表操作
    table.on('tool(pharmacyhis)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        	selectmx(data);
       
    });
   

})
