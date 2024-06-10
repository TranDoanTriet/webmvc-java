<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss/allCss.jsp" %>
<style type="text/css">
.cart-view{
	border-radius: 10px;
	border: 1px solid #e3e4e4;
	padding: 15px;
	margin: 20px 0 20px 0;
}
.cart-summary{
	background: #dddddd;
	border-radius: 5px;
}
.wid-3{
	width: 300px;
}
img{
	border-radius: 10px;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3), 0px 0px 10px rgba(0, 0, 0, 0.1);
}
h1{
	color: #2b3e50;
}
.cart-delete-item{
	background: red;
	border: none;
	padding: 5px 10px 5px 10px;
	color: white;
	border-radius: 5px;
	text-decoration: none;
}
.back-shopping{
	text-decoration: none;
	color: #6c757d;
}
.img-cart-item{
	border: 1px solid #2b3e50;
	width: 80px;
	border-radius: 5px;
}
.a{
	background: #2b3e50;
}
</style>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	
		<div class="container">
			<div class="cart-view">
				<div class="row">
					<div class="col-12">
						<div class="d-flex justify-content-between align-items-center">
							<h1>Shopping cart</h1>
							<div>
								<span id="cart-item-count">${totalQuantity }</span>
				      			<span>items</span>
							</div>
						</div>
						<hr>

		        		<c:forEach var="item" items="${cart}" varStatus="index">
						    <div class="d-flex justify-content-between align-items-center">
								<div>
									<img alt="img" src="<c:url value="/images/layout-key/${item.value.product.img}"/>" style="width: 150px; height: 150px">
								</div>
								<span>${item.value.product.productName}</span>
								<input id="quantity-input-${item.key}" class="img-cart-item" type="number" value="${item.value.quantity}" min="1">
								<span id="price">$${item.value.quantity * item.value.product.price}</span>
								<div>
									<button class="btn btn-secondary edit-cart" data-id="${item.key}" >Edit</button>
									<a class="btn btn-danger" href="<c:url value="/deleteCart/${item.key}"/>">X</a>
								</div>
								
							</div>
						</c:forEach>

					</div>
				</div>
				<hr/>
				<div class="mt-2 text-end d-flex justify-content-between align-items-center mt-2">
					<p>Total:</p>
					<p>$${totalPrice}</p>
				</div>
				<div class="mt-2 text-end d-flex justify-content-between align-items-center mt-2">
					<a class="back-shopping" href="#"><i class="fa-solid fa-arrow-left"></i> continue shopping</a>
					<a href="<c:url value="/user/checkout"/>" class="btn btn-secondary mb-3 wid-3">CHECKOUT</a>
				</div>
			</div>
		</div>
	
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
	<script type="text/javascript">
		$(".edit-cart").on("click", function () {
			let id = $(this).data("id");
			let quantity = $("#quantity-input-"+id).val();
			window.location = "/final_project/editCart/" + id + "/" + quantity;
			/* alert(quantity); */
		})
	
	</script>
</body>
</html>