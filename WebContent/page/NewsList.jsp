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
<style type="text/css">
.b50 {
	width: 50%;
}

.b50:hover {
	color: red;
	/*text-decoration: underline;*/
}

.nulls:hover {
	color: #33698a;
}

.b15 {
	width: 15%;
}

.b10 {
	width: 10%;
}

#top {
	color: red;
}

#stick, #unstick {
	color: #238e32;
	cursor: pointer;
	text-align: center;
}

#stick:hover, #unstick:hover {
	text-decoration: underline;
	color: red;
}
</style>
</head>
<body>
	<!-- 栏目管理 -->
	<div class="AccountManagement_c" id="ColumnManagement_c">
		<!-- <h3>新闻列表 
                    <div class="amcl fr">
                        <input type="text" placeholder="用户名" class="fl" name="">
                        <div class="search fl"><img src="../images/search.png"></div>
                    </div> 
                </h3> -->
		<h3>
			新闻列表
			<div class="amcl fr">
				<form action="findNewsList" method="post">
					<select class="fl NewsManagement_search" name="columnId" style="width:150px">
						<option value="0">----请选择新闻栏目----</option>
						<c:forEach items="${columnsList }" var="c">
							<option value="${c.id }">${c.columnName }</option>
						</c:forEach>
					</select> 
					<input type="text" placeholder="关键字" class="fl" name="keyWord">
					<input type="submit" value="查询" >
				</form>
			</div>
		</h3>
		
		<div class="AM_ct text_center">
			<div class="AM_ct_in">
				<div class="add_btn df_btn fl" id="add_news_btn">添加</div>
				<div class="edit_btn df_btn fl" id="edit_column_btn">编辑</div>
				<div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
			</div>
		</div>

		<div class="list">
			<ul class="list_h">
				<li class="b50 nulls"><label> <!-- <input type="checkbox" name=""> -->
						<span>新闻标题</span>
				</label></li>
				<li class="b10"><label>栏目名称</label></li>
				<li class="b20"><label>发布时间</label></li>
				<li class="b20"><label>操作</label></li>
			</ul>
			
			<div class="list_b_c">
			<c:forEach items="${newsList }" var="news">
				<ul class="list_b">
					<li class="b50">
						<label><input type="checkbox" name=""><span ></span>
						</label>
						<span><c:if test="${news.type==1 }">
									<span style="color:red">[置顶]</span>
							  </c:if>
						${news.title }
						</span>
					</li>
					<li class="b10"><label>${news.columnsInfo.columnName }</label></li>
					<li class="b20"><label>${news.createTime }</label></li>
					<li class="b20">
						<c:choose>
							<c:when test="${news.type==1 }">
									<a href="<%= basePath %>setNewsTop?tag=0&id=${news.id}"><span id="unstick">[取消置顶]</span></a>
							</c:when>
							<c:otherwise>
									<a href="<%= basePath %>setNewsTop?tag=1&id=${news.id}"><span id="stick">[置顶]</span></a>
							</c:otherwise>
						</c:choose> 
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


	<!-- 添加栏目 -->
	<div class="add_Account dn" id="add_column">
		<div class="add_Account_c">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					添加新闻 <span class="fr add_Account_close"><img
						src="<%= basePath %>/images/close.png"></span>
				</div>
			</div>
			<div class="user_name user_i">
				<label>新闻名</label> <input type="text" placeholder="输入栏目名" name="">
			</div>
			<div class="user_password user_i">
				<label>序<i>调</i>号
				</label> <input type="text" placeholder="输入序号" name="">
			</div>
			<div class="add_Account_ok_btn text_center" id="add_column_ok_btn">
				确<i>皮</i>定
			</div>
		</div>
	</div>

	<!-- 编辑栏目 -->
	<div class="add_Account dn" id="edit_column">
		<div class="add_Account_c">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					编辑新闻 <span class="fr add_Account_close"><img
						src="<%= basePath %>/images/close.png"></span>
				</div>
			</div>
			<div class="user_name user_i">
				<label>新闻名</label> <input type="text" placeholder="输入栏目名" name="">
			</div>
			<div class="user_password user_i">
				<label>序<i>调</i>号
				</label> <input type="text" placeholder="输入序号" name="">
			</div>
			<div class="add_Account_ok_btn text_center" id="edit_column_ok_btn">
				确<i>皮</i>定
			</div>
		</div>
	</div>

	<!-- 删除栏目 -->
	<div class="add_Account dn" id="delete_column">
		<div class="add_Account_c">
			<div class="add_Account_h">
				<div class="add_Account_h_in">
					删除新闻 <span class="fr add_Account_close"><img
						src="<%= basePath %>/images/close.png"></span>
				</div>
			</div>
			<div class="delete_text">
				确定删除“ <span>jiaopwuchu</span> ”新闻吗？
			</div>
			<div class="add_Account_ok_btn text_center" id="delete_column_ok_btn">
				确<i>皮</i>定
			</div>
		</div>
	</div>


</body>
<script type="text/javascript" src="<%= basePath %>/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/main.js"></script>
</html>