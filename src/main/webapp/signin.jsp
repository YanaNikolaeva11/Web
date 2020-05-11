<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" type="text/css" href="signin.css">
</head>
<body>

<header class="text">TechWorld</header>
<form  action='<c:url value="/signin" />' method="post"  >
    <div class="container">
        <input type="text" name="name" class="login" placeholder="Name"  required checked/>
       <%-- <input type="text" name="surname" class="login" placeholder="Surname" required checked/>
        <input type="text" name="patronymic" class="login" placeholder="Patronymic"  required checked/>--%>
        <input type="password" name="password" class="login" placeholder="password" required checked/>
        <%--<input type="radio" name="role" value="adm" class="role" required checked/> Admin<Br>
        <input type="radio" name="role" value="user" class="role" required checked/> User<Br>
        <input type="radio" name="gender" value="women" class="gender" required /> Female<Br>
        <input type="radio" name="gender" value="man" class="gender" required /> Male<Br>--%>
<%--
        <p><strong class="choisecountry">Choise country </strong></p>
        <p><select name="country" class="choisecountry">
            <option value="1">Russia</option>
            <option value="2">USA</option>
            <option value="3">Great Britain</option>
            <option value="4">Switzerland</option>
            <option value="5">China</option>
        </select></p>--%>

        <p><input type="submit" name="signin" class="signin" value="Sign In"></p>

    </div>
</form>


</body>
</html>
