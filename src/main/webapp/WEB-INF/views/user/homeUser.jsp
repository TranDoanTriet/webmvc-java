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
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
<%-- 	<h1>${LoginInfo.idUser }</h1> --%>
	<!--product type  -->
	<%-- <div class="product-type">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<div class="product-type-tab">
						<img alt="" src="<c:url value="/images/layout-key/layout-100.jpg"/>" alt="Image">
						<p class="product-type-tab-title">Sale</p>
						<span class="product-type-tab-content">Keyboard for sale</span>
					</div>
				</div>
				<div class="col-4">
					<div class="product-type-tab">
						<img alt="" src="<c:url value="/images/layout-key/layout-96.jpg"/>" alt="Image">
						<p class="product-type-tab-title">Best choice</p>
						<span class="product-type-tab-content">Best saling in month</span>
					</div>
				</div>
				<div class="col-4">
					<div class="product-type-tab">
						<img alt="" src="<c:url value="/images/layout-key/layout-75.jpg"/>" alt="Image">
						<p class="product-type-tab-title">Best for gaming</p>
						<span class="product-type-tab-content">Make your gaming better</span>
					</div>
				</div>
			</div>
		</div>
	</div> --%>
	
	
	
	<!-- Featured Products -->
	<div class="container">
		<p class="featured-products">
			Featured Products
		</p>
	</div>
	
	<!--list  products  -->
	<div class="container my-5">
		
        <div class="row">
        	<c:set var="countList" value="${product.size()}"/>
        	<c:if test="${product.size() > 7}">
        		<c:set var="countList" value="7"/>
        	</c:if>
        	<c:forEach var="product" items="${product}" varStatus="índex" begin="0" end="${countList }">
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
    
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>