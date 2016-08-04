<%--
  Created by IntelliJ IDEA.
  User: xxstop
  Date: 14-6-20
  Time: 下午5:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <title>Login</title>
</head>
<body>
<form action="/login.do" method="POST">
  <label>
    用户名：<input type="text" name="username" value="<%=request.getParameter("username") != null
          ? request.getParameter("username") : ""%>" />
  </label>
  <label>
    密码：<input type="password" name="password" value="<%=request.getParameter("password") != null
          ? request.getParameter("password") : ""%>" />
  </label>
  <% if (request.getAttribute("error") != null) {
    out.print("<b>"+request.getAttribute("error")+"</b>");
  } %>
  <button type="submit" >登录!!!</button>
  <button type="reset" >重置!!!</button>
</form>
</body>
</html>
