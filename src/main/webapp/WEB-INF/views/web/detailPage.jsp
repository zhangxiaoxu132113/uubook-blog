<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="urlHelper" class="com.ask39.piyao.utils.UrlHelper" scope="application"/>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${refuteRumorDto.topicTitle}【辟谣】- 健康辟谣专题_39健康网</title>
    <meta name="Keywords" content="${refuteRumorDto.topicTitle}"/>
    <meta name="description" content="${refuteRumorDto.topicTitle}--${fn:substring(refuteRumorDto.analyze,0,60)}"/>
    <script type="text/javascript" src="http://image.39.net/ask/2013/js/jquery-1.7.2.min.js"></script>
    <link rel="stylesheet" href="http://image.39.net/ask/pc/css/piyao/content.css?2017061508">
</head>

<body>
<jsp:include page="common/page_header.jsp"/>

<div class="page-content clearfix">
    <div class="page-left-content clearfix">
        <div class="article-view">
            <c:choose>
                <c:when test="${refuteRumorDto.truth == 1}">
                    <i class="true-pose"></i>
                </c:when>
                <c:otherwise>
                    <i class="false-pose"></i>
                </c:otherwise>
            </c:choose>
            <p class="article-title">${refuteRumorDto.topicTitle}</p>

            <p class="article-sub-title">结论</p>

            <p class="article-content">${refuteRumorDto.conclusion}</p>

            <p class="article-sub-title">分析</p>

            <div class="article-content">${refuteRumorDto.anlayizerHtml}</div>
        </div>
        <div class="doctor-msg">
            <a href="http://my.39.net/${refuteRumorDto.doctorUserName}" target="_blank">
					<span class="doctor-msg-pic">
						<img src="${refuteRumorDto.doctorHeaderImage}" alt="">
					</span>
                <span class="doctor-msg-name">${refuteRumorDto.doctorName}</span>
                <span class="doctor-msg-job">主治医师</span>
            </a>
            <a class="ask-btn" href="http://ask.39.net/addtopic.aspx?tomid=${refuteRumorDto.doctorId}" target="_blank">向TA提问</a>
        </div>
        <c:if test="${topicsDtos.size() > 0}">
            <div class="relevant-question item-list">
                <%--<p class="item-title">相关问题<a--%>
                        <%--href="javascript:void(0);" target="_self" id="more-info-btn"--%>
                        <%--onclick="">查看更多问题>></a>--%>
                <%--</p>--%>
                <p class="item-title">相关问题<a
                        href="javascript:void(0);" target="_self" id="more-info-btn">查看更多问题>></a>
                </p>
                <ul class="item-list-content clearfix">
                    <c:forEach var="topic" items="${topicsDtos}">
                        <li><a href="http://ask.39.net/question/${topic.tid}.html"
                               target="_blank">${fn:substring(topic.title,0,15)}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </div>
    <div class="page-right-content">
        <div class="item-list">
            <p class="item-title">热门谣言</p>
            <ul class="item-list-content clearfix">
                <c:forEach var="refuteRumor" items="${hostRetuteRumors}">
                    <li>
                        <a href="<%=path%>${urlHelper.pcDebug()}/detail/${refuteRumor.topicId}.html"
                           target="_blank">${fn:substring(refuteRumor.topicTitle,0,20)}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@include file="common/page_footer.html" %>
<script charset="utf-8">
    $(document).ready(function () {
        $("#more-info-btn").bind('click',function() {
            <%--window.open('http://so.39.net/wd?words=' + encodeURI('${refuteRumorDto.topicTitle}'));--%>
            window.open('http://so.39.net/wd?words=${refuteRumorDto.topicTitle}');
        });
    });
</script>
</body>
</html>
