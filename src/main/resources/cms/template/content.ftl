<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb312"/> 
    <title>新闻资讯</title>
    <meta content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" name="viewport" />
    <link rel="stylesheet" href="../style/style.css">
</head>

<body>

<div class="wrap">
	<!-- 
    <div id="top">
        <div id="top1"><a href="#"><img src="images/jiantou.png" width="17" height="20"></a></div>
        <div id="top2">最新资讯</div>
        <div id="top1"><a href="#"><img src="images/fenxiang.png" width="20" height="20"></a></div>
    </div>
	-->
    <div class="news">
        <h1 id="infor_title">${info_title}</h1>
        <h2>
            <!-- 
            <i><img src="images/shijian.png" width="17" height="17"></i>
             -->
            <span id="infor_create_time" style="float:left; width:100px; height:20px; line-height:20px; background:url(../images/shijian.png) no-repeat left center; text-indent:15px; font-size:14px; color:#9fa0a2;">${create_date}</span>
            <!-- 
            <i><img src="images/zuozhe.png" width="17" height="17"></i>
            -->
            <span style="float:left; width:100px; height:20px; line-height:20px; background:url(../images/zuozhe.png) no-repeat left center; text-indent:15px; font-size:14px;  color:#9fa0a2;">${create_name}</span>
        </h2>
        <div id="infor_content">
        	${info_content}
        </div>
    </div>
</div>
</body>
</html>
