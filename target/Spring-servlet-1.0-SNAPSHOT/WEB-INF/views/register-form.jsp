<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>User Form</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>

<div class="main">
  <%@include file="common/sidebar.jsp"%>
  <main class="main_content">
    <%@include file="common/navbar.jsp"%>
    <div class="container py-3 pt-4">
      <div class="alert alert-light alert-bottom-border text-center">Register Form</div>
    </div>
    <div class="container">
      <div style="width: 70%; margin: 0 auto" class="">
        <form:form method="post" action="/user/register" modelAttribute="userDto">
          <div class="mb-3">
            <label for="name" class="form-label">User Name</label>
            <form:input type="text" path="userName" class="form-control" id="name" placeholder="Enter your name" />
            <form:errors path="userName" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <form:input type="email" class="form-control" id="email" placeholder="Enter your email" path="email"/>
            <form:errors path="email" cssClass="text-danger"/>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input type="password" class="form-control" id="password" placeholder="Enter password" path="password"/>
            <form:errors path="password" cssClass="text-danger"/>

          </div>
          <div class="mb-3">
            <label for="repassword" class="form-label">RePassword</label>
            <form:input type="password" class="form-control" id="repassword" placeholder="Enter repassword"  path="rePassword"/>
            <form:errors path="rePassword" cssClass="text-danger"/>
          </div>
          <button type="submit" class="btn btn-primary px-5">Register</button>
        </form:form>
      </div>
  </main>
</div>
</body>
</html>
