<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="user.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<title>Products</title>
</head>
<body>
	<header>
		<div>
			<a class="name-shop">TechWorld</a>
			<form method="get" action='<c:url value="/search" />' class="form" >
				<input type="search"  name="search" class="input">
				<i class="fa fa-search"></i>
			</form>
		</div>
	</header>

	<div class="upper-container">
		<div>
			<form method="get" action='<c:url value="/basket" />'>
				<a>
					<%--<input type="hidden" name="customerID" value="${customerID}">--%>
					<input type="submit" class="button-basket" value="Basket">
				</a>
				<p class="text-count-products">Products all:${count}</p>

			</form>
		</div>
	</div>

	</div>
	<section>
			<%--<div class="lower-container-products">
				<ul class="products">
					<c:forEach var="product" items="${products}">
						<li>
							<div class="product" >

								<p>${product.name}</p>
								<p>Price: ${product.price}</p>
								<p>Rating: ${product.rating}</p>

								&lt;%&ndash;<form method="post" action='<c:url value="/buy" />' style="display:inline;">
									<input type="hidden" name="buyID" value="${product.idProduct}">
									<input class="buy" type="submit" value="In Basket" >
								</form>&ndash;%&gt;
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>--%>
				<div class="container-fluid">
					<div class="row">
						<div class="col-3">
							<div class="categories">
								<form method="get" action='<c:url value="/phone" />'>
									<a><input type="submit" value="Phone" class="category-bottom"></a>
								</form>

								<form method="get" action='<c:url value="/computers" />'>
									<a><input type="submit" value="Computers" class="category-bottom"></a>
								</form>

								<form method="get" action='<c:url value="/kitchen" />'>
									<a><input type="submit" value="Kitchen appliances" class="category-bottom"></a>
								</form>
							</div>
						</div>
						<div class="col-6">
							<ul class="products">
								<c:forEach var="product" items="${products}">
									<li>
										<div class="product" >
											<form method="get" action='<c:url value="/info" />'>
												<p>
													<input type="hidden" name="infoID" value="${product.idProduct}">
													<input type="submit" class="text-reset" style="border-radius: 25px; background-color: teal" value="${product.name}">
												</p>
											</form>

											<p>Price: ${product.price}</p>
											<p>Rating: ${product.rating}</p>
							<%--<div class="col-3">
								<div class="categories">
									<c:forEach var="categories" items="${categories}">
									<form method="get" action='<c:url value="/productByCategory" />'>
										<a><input type="submit" name="categoryName" value="${categories.nameCategory}" class="category-bottom"></a>
									</form>
								</div>
							</div>
							</c:forEach>
							<div class="col-6">
								<ul class="products">
									<c:forEach var="product" items="${products}">
										<li>
											<div class="product" >

												<p>${product.name}</p>
												<p>Price: ${product.price}</p>
												<p>Средняя оценка: ${rating}</p>
												<form method="post" action='<c:url value="/rate" />'>
													<input type="hidden" name="id" value="${product.idProduct}">
													<p>Оцените товар:</p><input title="Your rate: " type="text" name="rate">
													<input type="submit" value="OK">
												</form>--%>

											<form method="post" action='<c:url value="/basket" />'>
												<%--<button type="button" class="btn btn-primary btn-sm" style="border-radius: 25px ;border: 2px  ;border-bottom-color: dimgrey ; margin-top: 15px" value="info">Info</button>--%>
												<input type="hidden" name="buyID" value="${product.idProduct}">
												<button  type="submit" class="btn btn-secondary btn-sm" style="border-radius: 25px ;border: 2px ; border-bottom-color: dimgrey ; margin-top: 15px">in Basket</button>
											</form>

										</div>
									</li>
								</c:forEach>
							</ul>

						</div>
						<div class="col-3">
							<%--<label for="customRange2">Sort price</label>
							<input type="range" class="custom-range" min="0" max="110000" id="customRange2">
--%>
								<h2 style="margin-top: 30px">Price Sort</h2>
								<form method="get" action='<c:url value="/priceSort" />' class="form-inline">
									<input type="text" class="form-control" style="margin-top: 3px; border-radius: 25px;" placeholder="from theprice "  name="min">
									<input type="text" class="form-control" style="margin-top: 3px; border-radius: 25px;" placeholder="up to price"  name="max">
									<button type="submit" class="btn btn-outline-danger" style="margin-top: 3px; border-radius: 25px;"  name="Ok">Ok</button>
								</form>
								<h2 style="margin-top: 3px">Product sorting</h2>
								<form action='<c:url value="/sortingByPriceorName" />' method="get" class="form-inline" style="margin-top: 1px">
									<p>
										<select  name="sorting" style="border-radius: 25px; width: 300px; height: 35px; margin-top: 10px">
											<option disabled selected>Choose sort: </option>
											<option value="1">Sort by price</option>
											<option value="2">Sort by Name</option>
										</select>

									</p>
									<button type="submit" class="btn btn-outline-danger" style="border-radius: 25px;"  name="Ok">Ok</button>
								</form>
						</div>
					</div>
				</div>
	</section>
</body>
</html>

<%--onchange="document.location=this.options[this.selectedIndex].value"--%>


<%--
<form method="post" action='<c:url value="/open" />' style="display:inline;">
	<input type="hidden" name="id" value="${product.idProduct}">
	<input type="submit" value="Open">
</form>

<form method="post" action='<c:url value="/buy" />' style="display:inline;">
	<input type="hidden" name="id" value="${product.idProduct}">
	<input type="submit" value="Buy">
</form>--%>
