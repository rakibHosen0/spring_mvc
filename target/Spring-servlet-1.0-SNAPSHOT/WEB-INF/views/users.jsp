
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
<div class="main">
    <%@include file="common/sidebar.jsp"%>
    <main class="main_content">
        <%@include file="common/navbar.jsp"%>
        <div class="container py-3 pt-4">
            <div class="alert alert-light alert-bottom-border">User List</div>
        </div>

        <div class="container">
            <table class="table table-striped table-hover table-bordered bg-light">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Role</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${users}" >
                    <tr>
                        <th scope="row">${user.id}</th>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td></td>
                        <td class="d-flex justify-content-end">
                            <button  class="btn btn-primary px-3 me-3">Edit</button>
                            <button class="btn btn-danger px-3"><a class="text-decoration-none text-light" href="/user/delete/${user.id}">Delete</a></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </main>
</div>







</body>
</html>
