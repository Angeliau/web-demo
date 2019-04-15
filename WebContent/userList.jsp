<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	用户列表：
	<table border=1>
		<tr>
			<td>用户id</td>
			<td>用户名</td>
			<td>密码</td>
		</tr>
		<c:forEach items="${userList }" var="userList">
		<!-- 使用jstl表达式时，从items中取值需和实体类的属性名称保持一致 -->
			<tr>
				<td>${userList.id }</td>
				<td>${userList.userName }</td>
				<td>${userList.userPwd }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>