layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery; 
    
    
    $("input[name=mname]").css({
		"position":"relative"
	});
	
	$("#lns").css({
		"border":"1px #ccc solid",
		"width":"189px",
		"position":"absolute",
		"top":"37px",
		"left":"0px",
		"display":"none",
		"z-index":"999"
	});
	
	//删除左右两端空格的方法
	 function trim(str){ //删除左右两端的空格
	　　     return str.replace(/(^\s*)|(\s*$)/g, "");
	　　 }
	
	// 键盘松开的时候Ajax请求
	$("#mname").keyup(function(){
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
						$("#mname").val(trim($(this).text()));
						$("#mname").focus();
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
    
   


})