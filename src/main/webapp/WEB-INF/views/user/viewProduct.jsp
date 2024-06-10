<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss/allCss.jsp" %>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	
	<!--item  products  -->
	<div class="item-review">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<img alt="" class="fixXY-img" src="<c:url value="/images/layout-key/${viewProduct[0].img}"/>">
				</div>
				<div class="col-8">
					<form action="<c:url value="/addCart/${viewProduct[0].idProduct}"/>" method="get">
						<h1 class="item-product-title">${viewProduct[0].productName}</h1>
						<p class="item-product-price txt-red">$${viewProduct[0].price}</p>
		                
		                <p>Type: cabble</p>
		                <p>Vendor: <span>${viewProduct[0].producer}</span></p>
		                <p class="item-product-script">
		                    ${viewProduct[0].title}
		                </p>
		                <p class="item-product-description">
		                    ${viewProduct[0].description}
		                </p>
		                <a type="submit" class="btn btn-primary mb-3" onclick="addToCart()" href="<c:url value="/addCart/${viewProduct[0].idProduct}"/>">Add to cart</a>
		                <!-- <div class="purchase-group-selection"> 
		               		<div class="row">
		               			<div class="col-1">
									<label for="quantity">Quantity: </label>
								</div>
								<div class="col-5">
									<input type="number" id="quantity" name="quantity" value="1" class="form-control" min="1" > 
								</div>
								<div class="col-2">
									  <button type="submit" class="btn btn-primary mb-3" onclick="addToCart()">Add to cart</button>
								</div>
		               		</div>
		                </div> -->
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>