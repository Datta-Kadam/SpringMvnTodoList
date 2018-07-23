<%--
  Created by IntelliJ IDEA.
  User: Datta kadam
  Date: 7/20/2018
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Todo list Application</title>
</head>
<body>
   <div align="center">
       <c:url var="itemsLink" value="${Mappings.ITEMS}" />
       <h2><a href="${itemsLink}" >Show Todo Items</a></h2>
   </div>
</body>
</html>
