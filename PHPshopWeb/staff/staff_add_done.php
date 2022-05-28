
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ベトナム農園</title>
</head>
<body>

<?php

try
{

$staff_name=$_POST['name'];
$staff_pass=$_POST['pass'];

$dsn='mysql:dbname=LAA1362922-shop;host=mysql154.phy.lolipop.lan';
$user='LAA1362922';
$password='Cncl93tc';
$dbh=new PDO($dsn,$user,$password);

$dbh->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);

$sql='INSERT INTO mst_staff (name,password) VALUES (?,?)';
$stmt=$dbh->prepare($sql);
$data[]=$staff_name;
$data[]=$staff_pass;
$stmt->execute($data);

$dbh=null;

print $staff_name;
print 'さんを追加しました。<br />';

}catch (Exception $e){
	print 'ただいま障害により大変ご迷惑をお掛けしております。';
	exit();
}

?>

<a href="staff_list.php"> 戻る</a>

</body>
</html>