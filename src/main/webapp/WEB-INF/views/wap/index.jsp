<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>IT博文分享平台_编程无忧网</title>
    <meta name="Keywords" content="优质技术博文，软件开发，编程语言，数据库开发，"/>
    <meta name="description"
          content="编程无忧网_IT博文分享平台，包含系统运维,云计算,大数据分析,Web开发入门,PHP教程,Python入门,Java,数据库文章,网络安全文章,人工智能,移动开发技术,服务器,考试认证等"/>
    <meta name="viewport" content="width=640"/>
    <link rel="stylesheet" href="<%=basePath%>/commons/iconfont/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/wap/css/common.css">
    <link rel="stylesheet" href="<%=basePath%>/asset/wap/css/index.css">
</head>
<body>
<div class="container">
    <div class="b_top">
        <h2>uubook博客</h2>
        <ul>
            <li><i class="iconfont"></i></li>
        </ul>
    </div>
    <div class="b_body">
        <div class="b_body_h">
            <div class="carousel-panel">

            </div>
            <div class="module-category">
                <ul>
                    <li>
                        <a href="">
                            <img src="" alt="">
                            <span></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="b_body_main">
            <div class="article_list">
                <dd>
                    <dl></dl>
                    <dt></dt>
                </dd>
            </div>
        </div>
    </div>
</div>
</body>
</html>
