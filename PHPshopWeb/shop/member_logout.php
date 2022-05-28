<?php
session_start();
$_SESSION=array();

//cookieが存在する場合、cookieを無効にする
if(isset($_COOKIE[session_name()])==true){
	setcookie(session_name(),'',time()-42000,'/');
}
//セッションの削除
session_destroy();
?>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ベトナム農園</title>
</head>
<body>

ログアウトしました。<br />
<br />
<a href="shop_list.php">商品一覧へ</a>

</body>
</html>