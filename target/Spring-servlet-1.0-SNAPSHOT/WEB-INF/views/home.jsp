
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<div class="main">
    <%@include file="common/sidebar.jsp"%>
    <main class="main_content">
        <%@include file="common/navbar.jsp"%>
        <div class="container py-3 pt-4">
            <div class="alert alert-light border-start border-5 ">Dashboard</div>
            <h2>${msg}</h2>
        </div>

    </main>
</div>

</body>
</html>