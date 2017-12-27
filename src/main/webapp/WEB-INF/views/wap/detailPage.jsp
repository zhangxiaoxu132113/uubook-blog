<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="urlHelper" class="com.ask39.piyao.utils.UrlHelper" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${refuteRumorDto.topicTitle}【辟谣】- 健康辟谣专题_39健康网</title>
    <meta name="Keywords" content="${refuteRumorDto.topicTitle}"/>
    <meta name="description" content="${refuteRumorDto.topicTitle}--${fn:substring(refuteRumorDto.analyze,0,60)}"/>
    <meta name="viewport" content="width=640"/>
    <script type="text/javascript" src="http://image.39.net/ask/wap/js/mobile-util.js"></script>
    <!-- <script type="text/javascript" src="http://image.39.net/ask/wap/js/jquery.lazyload.js"></script> -->
    <link rel="stylesheet" href="http://image.39.net/ask/wap/css/piyao/content.css?2017061508">

</head>
<body>

</body>
</html>