<%--
  Created by IntelliJ IDEA.
  User: xiongkuang
  Date: 3/27/16
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You have log out</title>
    <%@ include file="/WEB-INF/jsp/public/commons.jspf" %>
    <link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css">
</head>

<body>
<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
    <tr>
        <td align=center>
            <div id=Logout>
                <div id=AwokeMsg>
                    <img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0>
                    <img id=LogoutTitle src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border=0>
                </div>
                <div id=LogoutOperate>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0>
                    <a href="${pageContext.request.contextPath}/user_loginUI.action">Log in</a>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0>
                    <a href="javascript: window.open('','_self');window.close();">Close</a>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>

