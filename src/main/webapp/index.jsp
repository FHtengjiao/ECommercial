<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table>
    <tr>
        <th>code</th>
        <th>name</th>
        <th>remark</th>
    </tr>
    <c:forEach items="${list}" var="type">
        <tr>
            <td>${type.code}</td>
            <td>${type.name}</td>
            <td>${type.remark}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
