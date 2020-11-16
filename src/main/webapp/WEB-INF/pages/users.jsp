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
    <c:forEach var="user" items="${users}" varStatus="status">
        <div class="row">
            <div class="col-md-4">
                ${user.username}
            </div><!-- comment -->
            <div class="col-md-4">
                ${user.email}
            </div><!-- comment -->
            <div class="col-md-4">
                ${user.position}
            </div><!-- comment -->
        </div>
    </c:forEach>

    
</t:pageTemplate>
