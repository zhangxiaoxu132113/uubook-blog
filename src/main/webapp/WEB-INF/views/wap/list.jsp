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
    <title>健康辟谣专题_39健康网</title>
    <meta name="Keywords" content="健康辟谣专题"/>
    <meta name="description" content="39健康辟谣频道，识破那些路人皆知的“常识”谣言，内容包含健康辟谣,饮食辟谣,饮食谎言,生活辟谣,流行谣言等"/>
    <meta name="viewport" content="width=640"/>
    <link rel="stylesheet" href="https://image.39.net/ask/wap/css/piyao/index.css?2017061508">
    <style>
        .loading-more-inner p {
            text-align: center;
            line-height: 48px;
            vertical-align: middle;
            margin-bottom: 1em;
        }

        .loading-more-inner p img {
            margin-right: 1em;
        }

        .loading-more-inner p span {
            height: 32px;
        }

        .loading-more-info {
            display: none;
        }
    </style>
</head>
<body>
<div class="top-toolnav ">
    <a href="http://wapask.39.net/so/Assist"></a>
</div>
<section class="page-content">
    <div class="list-content">
        <c:forEach var="refuteRumor" items="${refuteRumorDtoList}">
            <a class="list-unit" href="<%=path%>${urlHelper.wapDubug()}/detail/${refuteRumor.topicId}.html">
                <c:choose>
                    <c:when test="${refuteRumor.truth == 1}">
                        <i class="true-pose"></i>
                    </c:when>
                    <c:otherwise>
                        <i class="false-pose"></i>
                    </c:otherwise>
                </c:choose>
                <p class="list-unit-title">${fn:substring(refuteRumor.topicTitle,0,15)}</p>

                <div class="doctor-msg">
                    <span class="doctor-msg-pic">
						    <img src="${refuteRumor.doctorHeaderImage}" alt="">
					    </span>
                    <span class="doctor-msg-name">${refuteRumor.doctorName}</span>
                    <span class="doctor-msg-job">主治医师</span>
                </div>
                <p class="list-unit-content">${refuteRumor.conclusion}</p>
            </a>
        </c:forEach>
    </div>
</section>
<div class="loading-more">
    <div class="loading-more-inner">
        <p class="load-more-info">加载更多</p>

        <p class="loading-more-info"><img src="<%=path%>${urlHelper.wapDubug()}/img/loading-more.gif" alt=""/><span>正在努力加载</span>
        </p>
    </div>
</div>
</body>

<script type="text/javascript" src="http://image.39.net/ask/2013/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://image.39.net/ask/wap/js/mobile-util.js"></script>
<script>
    $(document).ready(function () {
        var pageSize = 10;
        var currentPage = 1;
        var monitorWindowScroll = function () {
            $('body').bind('touchmove', function (e) {
                if ($(document).scrollTop() + $(window).height() >= $('body').height()) {
                    $('body').unbind('touchmove');
                    $('.load-more-info').css('display', 'none');
                    $('.loading-more-info').css('display', 'block');
                    currentPage++;
                    $.ajax({
                        url: "<%=path%>${urlHelper.wapDubug()}/getRefuteRumorListByAjax?currentPage=" + currentPage + "&pageSize=" + pageSize,
                        type: "GET",
                        cache: false,
                        success: function (data, status) {
                            data = mytrim(data);
                            $('.loading-more-info').css('display', 'none');
                            if (data == '') {
                                $('.load-more').css('display', 'none');
                                return;
                            }
                            $('.list-content').append(data);
                            if ($('.list-unit').size() % 10 != 0) {
                                $('.load-more').css('display', 'none');
                                return;
                            }
                            $('.load-more-info').css('display', 'block');
                            monitorWindowScroll();
                        },
                        error: function () {
                            console.log("异步请求出现异常！");
                            $('.loading-more').css('display', 'none');
                            return false;
                        },
                        dataType: "html"
                    });
                }
            });
        };
        monitorWindowScroll();
    });
    function mytrim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, '');
    }
</script>
</html>
