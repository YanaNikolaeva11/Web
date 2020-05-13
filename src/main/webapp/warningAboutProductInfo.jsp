<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <title>Information</title>
</head>
<body style="background-color: aliceblue">
<h1 style="text-align: center; margin-top: 5%">Warning</h1>
<h2 style="text-align: center; margin-top: 5%"> The characteristics of this product are already known</h2>

<%--<p class="text-muted">
    <a href="admin.jsp" class="text-reset" style="margin-left: 47%; margin-top: 5%;"><h2>Back</h2></a>
</p>--%>


<form method="post" action='<c:url value="/updateInfo" />' style="margin-left: 48%">
    <input type="hidden" name="idProduct" value="${product}">
    <input type="hidden" name="idCategory" value="${category}">
    <button type="submit" class="btn btn-success">Success</button>
</form>
</body>
</html>
