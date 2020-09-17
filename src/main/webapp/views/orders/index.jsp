<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Bakery</title>
  </head>
  <body>
    <c:set var="orders" value="${requestScope.orders}" />

    <div>
      <ul>
      <c:forEach items="${orders}" var="order">
          <li><a href=<c:out value="${order.id}" />> <c:out value="${order.itemName} for ${order.username}"/></a></li>
      </c:forEach>
      </ul>
    </div>
  </body>
</html>