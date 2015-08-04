<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Users</title>
</head>
<body>
    <h2>Current list of users:</h2>
    <c:forEach var="user" items="${userList}" varStatus="counter" >
        <p><c:out value="First Name: ${user.firstName}"/></p>
        <p><c:out value="Last Name: ${user.lastName}"/></p>
        <p><c:out value="Age: ${user.age}"/></p>
        <br/>
    </c:forEach>
</body>
</html>
