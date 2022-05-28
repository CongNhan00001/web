<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="websample.LoginUB" />
<!DOCTYPE html>
<html>
	<head>
		<title>Java 入門</title>
		<link href="css/shop.css" rel="stylesheet" type="text/css"/>
		
	</head>
	<body>
		<div class="login_pane">
			<h1>ログイン管理画面</h1>
			<p>ログインIDとパスワードを入力してください</p>
			<form action="../LoginMaServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<%-- ログイン済みの場合はIDを表示 --%>
							<th>ログインID</th>
							<%--//TODO ①　user.getId 入力してください --%>
							<td><input type="text" name="id" value="<%=user_db.getId() %>"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="pass"/></td>
						</tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" name="submit" value="ログイン"/>
				<%-- ログイン済みの場合はログインボタンを表示 --%>
				<% if("login".equals(session.getAttribute("login_db"))){%>
					<input class="common_button" type="submit" name="submit" value="ログアウト"/>
				<%} %>
			</form>
		</div>
	</body>
</html>