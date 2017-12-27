<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:forEach var="refuteRumor" items="${refuteRumorDtoList}">
    <a class="list-unit" href="<%=path%>${urlHelper.pcDebug()}/detail/${refuteRumor.topicId}.html" target="_blank">
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
        <div class="list-unit-content">
            <dl class="list-unit-article clearfix">
                <dt>结论：</dt>
                <dd class="text-overflow">${refuteRumor.conclusion}</dd>
            </dl>
            <dl class="list-unit-article clearfix">
                <dt>分析：</dt>
                <dd>${refuteRumor.analyze}</dd>
            </dl>
        </div>
    </a>
</c:forEach>
