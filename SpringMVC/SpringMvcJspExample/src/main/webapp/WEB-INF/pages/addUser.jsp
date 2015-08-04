<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add a new User</title>
</head>
<body>
  <h2>Add a new user</h2>
  <form:form action="/user/addUser/save" name="user" method="POST" modelAttribute="userForm" >
    First Name:
      <input type="text" name="firstName"><br />
    Last Name:
      <input type="text" name="lastName" /><br />
    Age:
      <input type="number" name="age" /><br />
    <input type="submit" value="Submit" />
  </form:form>
</body>
</html>
