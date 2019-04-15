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
<script type="text/javascript" src="<%= basePath %>/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="<%= basePath %>/js/jquery.js"></script>
<script type="text/javascript">
	CKEDITOR.replace('texts');
</script>
</head>
<body>
	<!-- 新闻管理 -->
	<div class="AccountManagement_c" id="NewsManagement_c">
		<h3>
			新闻管理
		</h3>
		<div class="list" id="release_news">
			<ul class="list_h">
				<li class="b80"><label>发布新闻</label></li>
			</ul>
			<div class="list_b_c" id="release_news_in">
				<div class="release_news">
				<form action="addNews" method="post"> 
					<div class="news_title">
						<label class="text_center">标题</label> 
						<input type="text" placeholder="填写标题" name="title">
					</div>
					<div class="column_name">
						<label class="text_center">栏目</label> 
						<select class="column_name_release" name="columnId">
							<c:forEach items="${columnsList }" var="c">
								<option value="${c.id }">${c.columnName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="column_name">
						<label class="text_center">是否置顶</label> 
						<select class="column_name_release" name="type">
							<option value="1">置顶</option>
							<option value="0">不置顶</option>
						</select>
					</div>
					<div class="column_name">
						<label class="text_center">关键字</label>
						<input type="text" placeholder="填写关键字" name="keyWord"> 
					</div>
					<textarea id="texts" class="release_news_content" rows="20" cols="10" placeholder="编辑正文" name="content">
					</textarea>
					<input type="submit" value="添加" />
					</form>
				</div>


			</div>
		</div>
	</div>
</body>
</html>