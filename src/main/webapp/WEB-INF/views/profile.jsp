<%@ page import="org.spring.dto.UserDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<div class="main">
    <%
        UserDto userDto = (UserDto) session.getAttribute("user");
    %>
    <%@include file="common/sidebar.jsp"%>
    <main class="main_content">
        <%@include file="common/navbar.jsp"%>
        <div class="container py-3 pt-4">
            <div class="alert alert-light border-start border-5">profile</div>
            <div class="container">

                <% if(userDto != null){ %>
                <button class="btn btn-outline-warning bg-primary"><a class="text-decoration-none text-light" href="/user/logout">Logout</a></button>
                <h1>Hello ${userDto.name} welcome to profile</h1>
                <div class="card" style="width: 18rem;">
                    <img src="../../resources/img/profile.jpg" class="card-img-top" alt="Profile Picture">
                    <div class="card-body">
                        <h5 class="card-title">${userDto.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${userDto.email}</h6>
                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla varius tincidunt ex at tristique.</p>
                        <a href="#" class="card-link">Website</a>
                        <a href="#" class="card-link">LinkedIn</a>
                    </div>
                </div>
                <% }%>
            </div>
        </div>

    </main>
</div>

</body>
</html>
