<%@page import="Finalproject.DB.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="/components/allCss/allCss.jsp" %>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/admin/header1.jsp" %>
	<%@include file="/components/layouts/admin/header2.jsp" %>
	
	
	
	<!-- <!-- Featured Products -->
	<div class="container">
		<p class="featured-products">
			Featured Products
		</p>
	</div> -->
	
	<!--list  products  -->
	<div class="container my-5">
		<h1>${deleteMessage }</h1>
        <div class="row">
        	
        	<c:forEach var="product" items="${product}" varStatus="índex">
			    <div class="col-md-3 col-sm-6 mb-4">
           			<div class="card h-100 card-hover">
	                    <img src="<c:url value="/images/layout-key/${product.img}"/>" class="card-img-top" alt="${product.img}">
	                    <div class="card-body">
	                        <h5 class="card-title">${product.productName}</h5>
	                        <p class="card-text">$${product.price}</p>
	                        <p class="card-text">${product.idProduct}</p>
	                        <a class="btn btn-danger" href="<c:url value="/deleteProduct/${product.idProduct}"/>">Delete</a>
	                        <a class="btn btn-secondary" href="<c:url value="/updateProduct/${product.idProduct}"/>">Update</a>
	                        <%-- <a class="btn btn-secondary" onclick="addToCart()" href="<c:url value="/addCart/${product.idProduct}"/>">Add to cart</a>
	                        <a href="<c:url value="/user/view-product/${product.idProduct}"/>" class="btn btn-secondary">View</a> --%>
	                        <div id="notification-container"></div>
	                    </div>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>
    
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>