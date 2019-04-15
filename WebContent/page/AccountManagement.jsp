<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<title></title>
<meta charset="utf-8">
<link href="<%= basePath %>/css/main.css" rel="stylesheet">
</head>
<body>
	<div class="AccountManagement_c " id="AccountManagement_c">
		<h3>
			账户管理
			<div class="amcl fr">
			<form action="findUser" method="post">
				<input type="text" placeholder="用户名" class="fl" name="userName">
				<%-- <div class="search fl">
					<img src="<%=basePath %>/images/search.png">
				</div> --%>
				<input type="submit" value="查询">
			</form>
			</div>
		</h3>
		<div class="AM_ct text_center">
			<div class="AM_ct_in">
				<div class="add_btn df_btn fl" id="add_Account_btn">添加</div>
				<div class="edit_btn df_btn fl" id="edit_Account_btn">编辑</div>
				<div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
				<div class="fr df_btn ac_btn" id="ac_Account_btn">账号授权</div>
			</div>
		</div>

		<div class="list">
			<ul class="list_h">
				<li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
				<li class="b20"><label>密码</label></li>
				<!-- <li class="b60"><label>授权形式</label></li> -->
			</ul>
			<div class="list_b_c">
				<!-- <ul class="list_null">
					<li class="text_center">未添加管理员账户！</li>
				</ul> -->

			<c:forEach items="${userLists }" var="u">
				<ul class="list_b">
					<li class="b20">
						<label>
							<input type="checkbox" name="choose" value="${u.id }">
							<span>${u.userName }</span>
						</label>
					</li>
					<li class="b20">
						<label>${u.userPwd }</label>
					</li>
				</ul>
			</c:forEach>



			</div>

			<div class="pull_page">
				<div class="fl pull_page_up">上一页</div>
				<ul>
					<li class="on">1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li class="pull_page_df_btn">…</li>
					<li>12</li>
				</ul>
				<div class="fl pull_page_down">下一页</div>
			</div>


		</div>
	</div>


	<!-- 弹窗 -->
	<!-- 添加账户 -->
	<div class="add_Account dn" id="add_Account">
		<div class="add_Account_c">
		<form action="addUser" method="post">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					添加账户 <span class="fr add_Account_close">
							<img src="<%=basePath %>/images/close.png">
						   </span>
				</div>
			</div>
			<div class="user_name user_i">
				<label>用户名</label> <input type="text" placeholder="输入用户名" name="userName" required>
			</div>
			<div class="user_password user_i">
				<label>密&nbsp;&nbsp;&nbsp;码
				</label> <input type="password" placeholder="输入密码" name="userPwd" required>
			</div>
			<input type="submit" value="添加" class="add_Account_ok_btn text_center" style="margin:auto 40px"/>
		</form>
		</div>
	</div>

	<!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
        <div class="add_Account_c">
        <form action="updateUser" method="post">
        	<input type="hidden" name="id" id="uid">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    编辑账户
                    <span class="fr add_Account_close"><img src="<%=basePath %>/images/close.png"></span>
                </div>
            </div>
            <!-- <div class="column_now ">正在编辑 “<span>xxx</span>”账户</div> -->
            <div class="user_name user_i">
                <label>用户名</label><input type="text" placeholder="输入用户名" name="userName" id="uname">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label><input type="text" placeholder="输入密码" name="userPwd" id="upwd">     
            </div>
            <input type="submit" value="确定" class="add_Account_ok_btn text_center" style="margin:auto 40px">
         </form>
        </div>
    </div>

	<!-- 删除账户 -->
	
	<div class="add_Account dn" id="delete_Account">
		<div class="add_Account_c">
		<form action="deleteUser" method="post">
			<input type="hidden" name="ids" id="del_uid">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					删除账户 <span class="fr add_Account_close"><img
						src="<%= basePath %>/images/close.png"></span>
				</div>
			</div>
			<div class="delete_text">
				<!-- 确定删除“<span id="del_name"></span>”账户吗？ -->
				确定删除?
			</div>
			<input type="submit" value="确定" class="add_Account_ok_btn text_center" style="margin:auto 40px">
		</form>
		</div>
	</div>

	<!-- 账户授权 -->
	<div class="add_Account dn" id="ac_Account">
		<div class="add_Account_c">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					账户栏目授权 <span class="fr add_Account_close"><img
						src="<%= basePath %>/images/close.png"></span>
				</div>
			</div>
			<ul>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
				<li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
			</ul>
			<div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">
				保<i>呀</i>存
			</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="<%= basePath %>/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/main.js"></script>
</html>