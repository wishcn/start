<%--
  Created by IntelliJ IDEA.
  User: xxstop
  Date: 14-6-20
  Time: 下午5:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
  <title>Index</title>
</head>
<body>

<h2>
  Hello, <%=request.getSession().getAttribute("username") != null
        ? request.getSession().getAttribute("username") : ""%>
</h2>

<h3>
  You can:
</h3>

<ul>
  <li><a href="/loginout.do">loginout</a></li>
</ul>

</body>
</html>
