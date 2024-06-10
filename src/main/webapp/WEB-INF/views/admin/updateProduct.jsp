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
	<%@include file="/components/layouts/admin/header1.jsp" %>
	<%@include file="/components/layouts/admin/header2.jsp" %>
	
	
	<!--item  products  -->
	<div class="item-review">
		<div class="container">
			<div class="row">
				<div class="col-4">
					<img alt="" class="fixXY-img" src="<c:url value="/images/layout-key/${viewProduct[0].img}"/>">
				</div>
				<div class="col-8">
					<form action="<c:url value="/updateProduct/${viewProduct[0].idProduct}"/>" method="post">
						<div class="form-group mb-3">
							<label>Product name</label>
							<input class="form-control" name="updateProductName" value="${viewProduct[0].productName}"/>
						</div>
						<div class="form-group mb-3">
							<label>Product price</label>
							<input class="form-control txt-red" type="number" step="0.1" name="updateProductPrice"  value="${viewProduct[0].price}"/>
						</div>
		                <div class="form-group mb-3">
		                	<label>Product title</label>
		                	<input class="form-control txt-red" name="updateProductTitle"  value="${viewProduct[0].title}"/>
		                </div>
		                <p class="item-product-description">
		                    ${viewProduct[0].description}
		                </p>
		                <button type="submit" class="btn btn-secondary mb-3" >Update</button>
		                
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