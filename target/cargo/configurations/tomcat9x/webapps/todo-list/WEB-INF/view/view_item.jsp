<%--
  Created by IntelliJ IDEA.
  User: Datta kadam
  Date: 7/20/2018
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<%@ page import="academy.learnprogramming.util.AttributeNames" %>

<html>
<head>
    <title>View Item</title>
</head>
<body>
   <div align="center">
       <c:url var="listItem" value="${Mappings.ITEMS}" />
       <a href="${listItem}">Back to List</a>
        <table>
            <tr>
                <td><label>ID</label></td>
                <td>
                    <label>${todoItem.id}</label>
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td><label>${todoItem.title}</label></td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td><label>${todoItem.deadline}</label></td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td><label>${todoItem.details}</label></td>
            </tr>
        </table>
   </div>
</body>
</html>
