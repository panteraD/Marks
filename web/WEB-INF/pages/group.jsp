<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Groups </span></div>
        <table class="table table-hover">
            <%--Declare headers--%>
            <thead>
            <tr>
                <th>id</th>
                <th>speciality</th>
                <th>course</th>
                <th>group number</th>
                <th>faculty</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.id}</td>
                    <td>${group.speciality.specialityName}</td>
                    <td>${group.course}</td>
                    <td>${group.groupNumber}</td>
                    <td>${group.faculty}</td>

                    <td><a href="<c:url value='/edit-user-${group.id}' />"
                           class="btn btn-success custom-width">edit</a>
                    </td>


                    <td><a href="<c:url value='/delete-group-${group.id}' />"
                           class="btn btn-danger custom-width">delete</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%--<sec:authorize access="hasRole('ADMIN')">--%>
    <div class="well">
        <a href="<c:url value='/newuser' />">Add New User</a>
    </div>
    <%--</sec:authorize>--%>
</div>
</body>
</html>