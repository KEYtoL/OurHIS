layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;
    
    
    $("#Phsubmit").click(function(){
    	$.post("/pharmacy/insertPharmacy",
    	{
            a : "a" //将需要删除的mname作为参数传入
        },
        function(data){
        	if(data==1){
        		layer.msg("请添加数据！");
        	}else{
        		layer.msg("添加成功！");
    		}

        });
    	setTimeout(function(){
            tableIns.reload();
        },1000);
        return false;
    });

    //用户列表
    var tableIns = table.render({
        elem: '#pharmacy',
        url : '/pharmacy/selectFalsePharmacy',
        cellMinWidth : 95,
        page : true,
        height : 350,
        limits : [10,15,20,25],
        limit : 10,
        id : "pharmacyTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'medicine', title: '药品名称', width:260,templet: '<div>{{d.medicine.mname}}</div>', align:"center" },
            {field: 'medicine', title: '药品价格（元）', width:140,templet: '<div>{{d.medicine.mprice}}</div>', align:"center"},
            {field: 'medicine', title: '药品规格', width:100,templet: '<div>{{d.medicine.msize}}</div>', align:"center"},
            {field: 'medicine', title: '计数单位', width:100,templet: '<div>{{d.medicine.munit}}</div>', align:"center"},
            {field: 'medicine', title: '生产厂家', width:150,templet: '<div>{{d.medicine.manufacturer}}</div>', align:"center"},
            {field: 'yfmxnum', title: '数量', minWidth:100, align:"center"},
            {field: 'yfmxcount', title: '小计', minWidth:100, align:"center"},
            {title: '操作', minWidth:125, templet:'#pharmacyListBar',fixed:"right",align:"center"}
        ]]
    });
    
    
    //添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "入库详情",
            type : 2,
            content : "pharmacyAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".mname").val(edit.medicine.mname);  //药品名
                    body.find(".msize").val(edit.medicine.msize);  //规格
                    body.find(".munit").val(edit.medicine.munit);  //规格
                    body.find(".manufacturer").val(edit.medicine.manufacturer);  //厂家
                    body.find(".mprice").val(edit.medicine.mprice);  //价格
                    body.find(".yfmxnum").val(edit.yfmxnum);  //价格
                    body.find(".hidnum").val(edit.yfmxnum);  //价格
                    form.render();
                }
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
    $(".addNews_btn").click(function(){
        addUser();
    })
    
    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('pharmacyTable'),
            data = checkStatus.data,
            mnames = [];
        if(data.length > 0) {
            for (var i in data) {
            	mnames.push(data[i].medicine.mname);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                 $.post("/pharmacy/delectPharmacyOrder",
                		 {
                	 mnames :  mnames  //将需要删除的newsId作为参数传入
                 },
                 function(data){
                tableIns.reload();
                layer.close(index);
                 })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })
    //提交入库
    
    //列表操作
    table.on('tool(pharmacy)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        	
        if(layEvent === 'edit'){ //编辑
            addUser(data);
        }else if(layEvent === 'del'){ //删除
        	mnames = [];
        	mnames.push(data.medicine.mname);
            layer.confirm('确定删除此数据？',{icon:3, title:'提示信息'},function(index){
                 $.post("/pharmacy/delectPharmacyOrder",{
                     mnames :  mnames //将需要删除的mname作为参数传入
                 },
                 function(data){
                    tableIns.reload();
                    layer.close(index);
                 })
            });
        }
    });

})
