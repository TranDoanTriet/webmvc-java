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
	
	<!--list  products  -->
	<div class="container my-5">
		<h2>${listSearchProduct.size()} Products</h2>
        <div class="row">
        	
        	<c:forEach var="product" items="${listSearchProduct}" varStatus="índex">
			    <div class="col-md-3 col-sm-6 mb-4">
           			<div class="card h-100 card-hover">
	                    <img src="<c:url value="/images/layout-key/${product.img}"/>" class="card-img-top" alt="${product.img}">
	                    <div class="card-body">
	                        <h5 class="card-title">${product.productName}</h5>
	                        <p class="card-text">$${product.price}</p>
	                        <p class="card-text">${product.idProduct}</p>
	                        <a class="btn btn-secondary" onclick="addToCart()" href="<c:url value="/addCart/${product.idProduct}"/>">Add to cart</a>
	                        <a href="<c:url value="/user/view-product/${product.idProduct}"/>" class="btn btn-secondary">View</a>
	                        <div id="notification-container"></div>
	                    </div>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>
	
</body>
</html>