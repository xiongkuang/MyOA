<%--
  Created by IntelliJ IDEA.
  User: xiongkuang
  Date: 3/5/16
  Time: 02:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>List</title>
  </head>
  <body>
  <s:iterator value="#roleList">
    <s:property value="id"/>
    <s:property value="name"/>
    <s:property value="description"/>
    <s:a action="role_delete?id=%{id}" onclick="return confirm('Delete?')">Delete</s:a>
    <s:a action="role_editUI?id=%{id}">Edit</s:a>
    <br/>
  </s:iterator>
  <br/>
  <s:a action="role_addUI">Add</s:a>

</html>
