<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>标签列表</title>
</head>
<body>
<table align="center" border="1">
    <tr>
        <td>ID</td>
        <td>标签名</td>
    </tr>
    <c:forEach items="${tags}" var="tag">
        <tr>
            <td>${tag.id}</td>
            <td>${tag.tagName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
