$(function() {

	// 适配
	// iframe
	$(".AccountManagement_c_iframe").css("height", $(document).height());
	// 导航高度
	$(".nav_side").css("height", $(document).height() - 100);

	// iframe 链接
	$(".AccountManagement").click(function() {
		$(".AccountManagement_c_iframe iframe").attr("src", "findAll")
	})
	$(".ColumnManagement").click(function() {
		$(".AccountManagement_c_iframe iframe").attr("src", "findColumnsAll")
	})
	$(".NewsManagement").click(function() {
		$(".AccountManagement_c_iframe iframe").attr("src","page/NewsManagement.jsp")
	})
	$(".NewsList").click(function() {
		$(".AccountManagement_c_iframe iframe").attr("src","findNewsList")
	})

	// pull page 翻页
	$(".pull_page ul li").click(function() {
		var index = $(this).index();
		if ($(this).hasClass("pull_page_df_btn")) {
			return;
		}
		$(this).addClass("on").siblings().removeClass("on");

	})

	// nav
	$(".nav_side>div").click(function() {
		var index = $(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".main_fx>div").eq(index).show().siblings().hide();
		if (index == 0) {
			$(".user_location span").text("账户管理");
		} else if (index == 1) {
			$(".user_location span").text("栏目管理");
		} else if (index == 2) {
			$(".user_location span").text("新闻管理");
		} else if (index == 3) {
			$(".user_location span").text("新闻列表");
		}
	})

	// 弹窗 all
	// z账户管理 -
	// 添加账户
	$("#add_Account_btn").click(function() {
		$("#add_Account").fadeIn(100);
	})
	$(".add_Account_close").click(function() {
		$("#add_Account").fadeOut(100);
		$("#user_column").fadeOut(100);
		$("#delete_Account").fadeOut(100);
		$("#ac_Account").fadeOut(100);
		$("#add_column").fadeOut(100);
		$("#edit_column").fadeOut(100);
		$("#delete_column").fadeOut(100);
	})
	// 编辑账户
	$("#edit_Account_btn").click(function() {
		var id=0;
		//获取页面所有选中的name属性值为choose并且为已选中状态的checkbox对象
		var inp=$("input:checkbox[name=choose]:checked");
		if(inp.length==0){
			alert("请选择要编辑的账户！");
		}else if(inp.length>1){
			alert("只能同时选中一项！");
		}else if(inp.length==1){
			$.each(inp,function(index,i){
				id=$(this).val();
			})
			var username=$("input:checkbox[name=choose]:checked").next().html();
			var userpwd=$("input:checkbox[name=choose]:checked").parent().parent().next().children("label").html();
			$("#uname").val(username);
			$("#upwd").val(userpwd);
			$("#uid").val(id);
			//alert("uname"+username+" upwd:"+userpwd+" uid:"+id);
			$("#user_column").fadeIn(100);
		}
	})
	// 删除账户
	$("#delete_Account_btn").click(function() {
		var inp=$("input:checkbox[name=choose]:checked");
		var id="";
		if(inp.length==0){
			alert("请选择要删除的账户！");
		}else if(inp.length>0){
			$.each(inp,function(index,i){
				id+=$(this).val()+",";
			})
			//var username=$("input:checkbox[name=choose]:checked").next().html();
			//$("#del_name").val(username);
			$("#del_uid").val(id);
			
			$("#delete_Account").fadeIn(100);
		}
	})
	// 编辑账户
	$("#ac_Account_btn").click(function() {
		$("#ac_Account").fadeIn(100);
	})

	// 栏目管理 -
	//add column
	$("#add_column_btn").click(function() {
		 $("#add_column").fadeIn(100);
	})
	// 编辑栏目
	$("#edit_column_btn").click(function() {
		var id=0;
		//获取页面所有选中的name属性值为choose并且为已选中状态的checkbox对象
		var inp=$("input:checkbox[name=choose]:checked");
		if(inp.length==0){
			alert("请选择要编辑的用户！");
		}else if(inp.length>1){
			alert("只能同时选中一项！");
		}else if(inp.length==1){
			$.each(inp,function(index,i){
				id=$(this).val();
			})
			var colname=$("input:checkbox[name=choose]:checked").parent().parent().next().children("label").html();
			$("#columnName").val(colname);
			$("#columnId").val(id);
			$("#edit_column").fadeIn(100);
		}
	})
	// 删除栏目
	$("#delete_column_btn").click(function() {
		var inp=$("input:checkbox[name=choose]:checked");
		var id="";
		if(inp.length==0){
			alert("请选择要删除的栏目！");
		}else if(inp.length>0){
			$.each(inp,function(index,i){
				id+=$(this).val()+",";
			})
			$("#ids").val(id);
			
			$("#delete_column").fadeIn(100);
		}
	})
	
	//新闻管理
	//添加新闻
	$("#add_news_btn").click(function(){
		window.location.href="toNewsAdd";
	})

	// 确定 btn
	$("#add_Account_ok_btn").click(function() {
		$("#add_Account").fadeOut(100);
	})
	$("#user_column_ok_btn").click(function() {
		$("#user_column").fadeOut(100);
	})
	$("#delete_Account_ok_btn").click(function() {
		$("#delete_Account").fadeOut(100);
	})
	$("#ac_Account_ok_btn").click(function() {
		$("#ac_Account").fadeOut(100);
	})
	$("#add_column_ok_btn").click(function() {
		$("#add_column ").fadeOut(100);
	})
	$("#edit_column_ok_btn").click(function() {
		$("#edit_column ").fadeOut(100);
	})

	$("#delete_column_ok_btn").click(function() {
		$("#delete_column").fadeOut(100);
	})

})