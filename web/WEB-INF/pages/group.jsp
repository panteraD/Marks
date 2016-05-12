<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a Person
</h1>

<c:url var="addAction" value="/group/add" ></c:url>

<form:form action="${addAction}" commandName="group">
    <table>
        <c:if test="${!empty group.faculty}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="course">
                    <spring:message text="Course"/>
                </form:label>
            </td>
            <td>
                <form:input path="course" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="groupNumber">
                    <spring:message text="groupNumber"/>
                </form:label>
            </td>
            <td>
                <form:input path="groupNumber" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty group.faculty}">
                    <input type="submit"
                           value="<spring:message text="Edit group"/>" />
                </c:if>
                <c:if test="${empty group.course}">
                    <input type="submit"
                           value="<spring:message text="Add group"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
    <table class="tg">
        <tr>
            <th width="80">group ID</th>
            <th width="120">course</th>
            <th width="120">group number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listGroups}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.course}</td>
                <td>${group.groupNumber}</td>
                <td><a href="<c:url value='/edit/${group.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${group.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>