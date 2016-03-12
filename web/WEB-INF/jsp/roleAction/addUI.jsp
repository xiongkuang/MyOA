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
    <title>Add</title>
  </head>
  <body>
    AddUI
  <s:form action = "role_add">
      <s:textfield name="name"></s:textfield>
      <s:textarea name="description"></s:textarea>
      <s:submit value="Submit"></s:submit>
  </s:form>
  </body>
</html>
