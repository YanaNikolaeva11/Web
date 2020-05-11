<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="add.css">
    <title>Info</title>
</head>
<body>
<form  action='<c:url value="/addInfoComputert" />' method="post"  >


    <div class="container">
        <input type="text" name="OC" class="inf" placeholder="OC"  required checked/>
        <input type="text" name="Processor" class="inf" placeholder="Processor" required checked/>
        <input type="text" name="SSD" class="inf" placeholder="SSD" required checked/>
        <input type="text" name="RAM" class="inf" placeholder="RAM" required checked/>
        <p>
            <input type="hidden" name="infoID" value="${product}">
            <input type="submit" name="add" class="add" value="Add">
        </p>
    </div>


</form>

</body>
</html>
