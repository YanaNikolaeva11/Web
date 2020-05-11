<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" type="text/css" href="add.css">

</head>
<body>
<form  action='<c:url value="/add" />' method="post"  >
    <div class="container">
        <input type="text" name="name" class="inf" placeholder="Name Product"  required checked/>
        <input type="text" name="price" class="inf" placeholder="Price" required checked/>

        <p><strong class="choisecategory">Choise category </strong></p>
        <p><select name="category" class="choisecategory">
            <option value="1">Phone</option>
            <option value="2">Computers</option>
            <option value="3">Kitchen appliances</option>
        </select></p>

        <p><input type="submit" name="add" class="add" value="Add"></p>

    </div>
</form>
</body>
</html>
