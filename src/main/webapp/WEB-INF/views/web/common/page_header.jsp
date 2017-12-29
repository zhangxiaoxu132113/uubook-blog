<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:useBean id="urlHelper" class="com.ask39.piyao.utils.UrlHelper" scope="application"></jsp:useBean>
<div class="header_bg">
    <div class="head_cont">
        <div class="head_l">
            <a>
                <img src="http://image.39.net/ask/pc/imgs/common/piyao_logo.png?2017061501" alt="">
            </a>
            <span></span>
        </div>
        <div class="head_c">
            <form id="searchForm" action="http://ask.39.net/ask39/ajaxData/searchTarget?from=dh" target="_blank"
                  accept-charset="utf-8">
                <p class="search">
                    <input type="text" name="words" id="askwords" class="problem" placeholder="请在此输入您的问题">
                    <span class="search_int" id="searchBtn"
                          onclick="document.getElementById('searchForm').submit()">搜索</span>
                </p>

                <p class="ask_doctor"><a href="javascript:void(0)"
                                         onclick="document.getElementById('askwords').value == '' ? window.open('http://ask.39.net/addtopic?from=dh') : window.open('http://ask.39.net/addtopic?from=dh&words=' + encodeURI(document.getElementById('askwords').value));">向医生提问</a>
                </p>
            </form>
        </div>
        <div class="head_r" id="Logged">
            <div class="user">
                <span class="notLogged">
                    <a href="javascript:void(0);" target="_self"
                       onclick="javascript: Passport.SetOptions({ LoginCallback: TopLoginCallback, PopSkip: false,ScanCode:false }); Passport.PopShow();"
                       title="登录" rel="nofollow">登录</a>
                    /
                    <a href="javascript:void(0);" target="_self"
                       onclick="window.open('http://my.39.net/register.aspx?ReturnURL=' + window.location.href);"
                       title="注册" rel="nofollow">注册</a>
                </span>
            </div>
        </div>
    </div>
</div>

<script src="<%=path%>${urlHelper.pcDebug()}/js/page-common.js"></script>
<script type="text/javascript" src="http://my.39.net/js/Passport.js"></script>
<script type="text/javascript" src="http://ask.39.net/js/39ask/templates.js?v=20140924"></script>
<script type="text/javascript" src="http://image.39.net/ask2016/js/autosize.min.js"></script>
<script src="http://image.39.net/pass/js/passCommon.js" type="text/javascript"></script>
<script src='http://my.39.net/js/myMesg.js' type='text/javascript'></script>
<script src='<%=path%>${urlHelper.pcDebug()}/userloginjs' type='text/javascript'></script>

<script type="text/javascript" src="http://ask.39.net/js/askimg/wtcount.js" type="text/javascript"></script>