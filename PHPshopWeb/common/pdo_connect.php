<?php
$dsn='mysql:dbname=LAA1362922-shop;host=mysql154.phy.lolipop.lan';
$user='LAA1362922';
$password='Cncl93tc';
$dbh=new PDO($dsn,$user,$password);
$dbh->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
?>