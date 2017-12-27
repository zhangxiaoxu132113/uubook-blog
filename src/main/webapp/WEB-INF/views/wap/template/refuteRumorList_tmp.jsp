<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="urlHelper" class="com.ask39.piyao.utils.UrlHelper" scope="application"></jsp:useBean>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
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