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
<!-- <style type="text/css">
.pagination {
  display: flex;
  justify-content: flex-end;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #6c757d;
  color: white;
  border: 1px solid #6c757d;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style> -->
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	<!--product quick options  -->
	<%-- <%@include file="/components/layouts/user/product-quick-options.jsp" %> --%>
	

	<!-- Featured Products -->
	<div class="container">
		<p class="featured-products">
			${tag[idCategory - 1].name }
		</p>
	</div>
	<!--list  products  -->
	<div class="container my-5">
		<div class="mb-2">
			<select>
				<option>Price: Low - High</option>		
				<option>Price: High - Low</option>		
			</select>
		</div>
        <div class="row">
			<c:forEach var="item" items="${allProductById}" varStatus="index">
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="card h-100 card-hover">
                        <img src="<c:url value="/images/layout-key/${item.img}"/>" class="card-img-top" alt="${item.img}">
                        <div class="card-body">
                            <h5 class="card-title">${item.productName}</h5>
                            <p class="card-text">$${item.price}</p>
                            <a class="btn btn-secondary" onclick="addToCart()" href="<c:url value="/addCart/${item.idProduct}"/>">Add to cart</a>
                            <a href="<c:url value="/user/view-product/${item.idProduct}"/>" class="btn btn-secondary">View</a>
                            <div id="notification-container"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        
		<%-- <div class="pagination">
            <a href="<c:url value='/user/product/${idCategory}/${paginateInfo.currentPage - 1}'/>">&laquo;</a>
            <c:forEach var="item" begin="${paginateInfo.start}" end="${paginateInfo.end}" varStatus="loop">
                <a href="<c:url value='/user/product/${idCategory}/${loop.index}'/>" class="<c:if test='${item == paginateInfo.currentPage}'>active</c:if>">${loop.index}</a>
            </c:forEach>
            <a href="<c:url value='/user/product/${idCategory}/${paginateInfo.currentPage + 1}'/>">&raquo;</a>
        </div> --%>
    </div>
    
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>