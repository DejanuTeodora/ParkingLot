<%-- 
    Document   : users
    Created on : 16.11.2020, 21:57:40
    Author     : theo_
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle = "Users">
    <h1> Users</h1>
    <c:if test="${pageContext.request.isUserInRole('AdminRole')}">
        <a class="btn btn-primary btn-lg" role="button" href="${pageContext.request.contextPath}/Users/Create">Add User</a>
    </c:if>
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md-4">
                ${user.username}
            </div>
            <div class="col-md-4">
                ${user.email}
            </div>
            <div class="col-md-4">
                ${user.position}
            </div>
        </div>
    </c:forEach>


</t:pageTemplate>
