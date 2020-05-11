<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="information.css">
    <title>TechWorld</title>
</head>
<body>
<header>
    <div class="shop-name">TechWorld</div>
</header>
<div class="container">
    <div class="row">
        <div class="col-1">
            <div class="card" style="width:60rem; margin-top: 40%; margin-left: 60%; text-align: center">
                <c:forEach var="specifications" items="${specifications}">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item" >${specifications.property} ${specifications.propertyValue}</li>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
