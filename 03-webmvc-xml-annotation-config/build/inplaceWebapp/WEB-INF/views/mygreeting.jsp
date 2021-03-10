<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" var="bootstrapCss"/>
    <link rel="stylesheet" type="text/css" href="${bootstrapCss}">
    <c:url value="/resources/css/main.css" var="mainCss"/>
    <link rel="stylesheet" type="text/css" href="${mainCss}">
</head>

<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#about">About</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template">
        <h1>Spring boot Web JSP Example</h1>
        <h2>
            <c:if test="${not empty name}">
                Hello ${name}
            </c:if>

            <c:if test="${empty name}">
                Welcome MVC User!
            </c:if>
        </h2>

        <h2>Articles count: ${fn:length(articles)}</h2>
        <table class="article-table">
            <thead>
            <tr>
                <th>Number</th>
                <th>Title</th>
                <th>Content</th>
                <th>Date</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="article" varStatus="status" items="${articles}">
                <tr>
                    <td>${status.index}</td>
                    <td>${article.title}</td>
                    <td>${article.content}</td>
                    <td>
                        <fmt:formatDate value="${article.created}" pattern="dd.MM.yyyy - HH:mm:ss"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<c:url value="/webjars/jquery/3.1.1/jquery.min.js" var="jquery"/>
<script type="text/javascript" src="${jquery}"></script>
<c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" var="bootstrapJS"/>
<script type="text/javascript" src="${bootstrapJS}"></script>
</body>
</html>