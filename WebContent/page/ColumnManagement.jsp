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
	<!-- 栏目管理 -->
	<div class="AccountManagement_c" id="ColumnManagement_c">
		<h3>
			栏目管理
			<div class="amcl fr">
				<input type="text" placeholder="用户名" class="fl" name="">
				<div class="search fl">
					<img src="<%= basePath %>/images/search.png">
				</div>
			</div>
		</h3>
		<div class="AM_ct text_center">
			<div class="AM_ct_in">
				<div class="add_btn df_btn fl" id="add_column_btn">添加</div>
				<div class="edit_btn df_btn fl" id="edit_column_btn">编辑</div>
				<div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
			</div>
		</div>

		<div class="list">
			<ul class="list_h">
				<li class="b20"><label><input type="checkbox" name=""><span>序号</span></label></li>
				<li class="b80"><label>栏目名称</label></li>
			</ul>
			<!-- 栏目列表展示 -->
			<div class="list_b_c">
				<c:forEach items="${columnsLists }" var="columns" varStatus="i">
					<ul class="list_b">
						<li class="b20">
							<label>
								<input type="checkbox" name="choose" id="inp" value="${columns.id }">
									<span>${i.index+1 }</span>
							</label>
						</li>
						<li class="b80"><label>${columns.columnName }</label></li>
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


	<!-- 添加栏目 -->
	<div class="add_Account dn" id="add_column">
		<div class="add_Account_c">
			<form action="addColumn" method="post">
				<div class="add_Account_h">
					<div class="add_Account_h_in">
						添加栏目 <span class="fr add_Account_close"><img
							src="<%= basePath %>/images/close.png"></span>
					</div>
				</div>
				<div class="user_name user_i">
					<label>栏目名</label> <input type="text" placeholder="请输入栏目名" name="columnName">
				</div>
				<input type="submit" value="添加" class="add_Account_ok_btn text_center" style="margin:auto 40px"/>
			</form>
		</div>
	</div>

	<!-- 编辑栏目 -->
	<div class="add_Account dn" id="edit_column">
		<div class="add_Account_c">
			<form action="updateColumns" method="post">
				<input type="hidden" name="id" id="columnId">
				<div class="add_Account_h">
					<div class="add_Account_h_in">
						编辑栏目 <span class="fr add_Account_close"><img
							src="<%= basePath %>/images/close.png"></span>
					</div>
				</div>
				<div class="user_name user_i">
					<label>栏目名</label> 
						<input type="text" placeholder="输入栏目名" name="columnName" id="columnName">
				</div>
				<input type="submit" value="确定" class="add_Account_ok_btn text_center" style="margin:auto 40px">
			</form>
		</div>
	</div>

	<!-- 删除栏目 -->
	<div class="add_Account dn" id="delete_column">
		<div class="add_Account_c">
			<form action="deleteColumn" method="post">
				<input type="hidden" name="ids" id="ids">
				<div class="add_Account_h">
					<div class="add_Account_h_in">
						删除栏目 <span class="fr add_Account_close"><img
							src="<%= basePath %>/images/close.png"></span>
					</div>
				</div>
				<div class="delete_text">
					确定删除该栏目吗？
				</div>
				<input type="submit" value="确定" class="add_Account_ok_btn text_center" style="margin:auto 40px">
			</form>
		</div>
	</div>


</body>
<script type="text/javascript" src="<%= basePath %>/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/main.js"></script>
</html>