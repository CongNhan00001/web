<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java 入門</title>
<link href="css/shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
		<div class="login_pane">
			<h1>新人登録画面</h1>
			<p>下に入力してください</p>
			<form action="../LoginServletShopping" method="post">
				<table class="table_form">
					<tbody>
					
						<tr>
							<%-- ログイン済みの場合はIDを表示 --%>
							<th>ID</th>
							<%--//TODO ①　user.getId 入力してください --%>
							<td><input type="text" name="id"/></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="pass"/></td>
						</tr>
						<tr>
							<%-- ログイン済みの場合はIDを表示 --%>
							<th>名前</th>
							<%--//TODO ①　user.getId 入力してください --%>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<%-- ログイン済みの場合はIDを表示 --%>
							<th>歳：</th>
							<%--//TODO ①　user.getId 入力してください --%>
							<td><input type="text" name="age"/></td>
						</tr>
					</tbody>
				</table>
				<input class="common_button" type="submit" name="submit" value="送信"/>
				
			</form>
		</div>
</body>
</html>