<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="websample.LoginUB" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java入門</title>
<link href="css/shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="login_pane">
			<h1>管理画面</h1>
			「<jsp:getProperty property="name" name="user_db"/>」さん！ お疲れ様です。
			<form action="../LoginMaServlet" method="post">
				<table class="table_form">
					<tbody>
						<tr>
							<%-- ログイン済みの場合はIDを表示 --%>
							<!-- <th>ID管理</th> -->
							<%--//TODO ①　user.getId 入力してください --%>
							<td><input type="submit" name="sunmit" value="ID  管理"/></td>
							<td><input type="submit" name="sunmit" value="商品管理"/></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
</body>
</html>