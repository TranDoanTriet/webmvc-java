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
	.card-img-top{
		width: 100px;
		height: 100px;
	}
	.order-item{
		border: 1px solid #e5e3e3;
		border-radius: 5px;
		padding: 10px;
	}
	.disabled-link{
		 pointer-events: none;
	    cursor: default;
	    opacity: 0.6;
	}
</style>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/admin/header1.jsp" %>
	<%@include file="/components/layouts/admin/header2.jsp" %>
	<div class="container mt-5 mb-5">
		<c:forEach var="billDataByUser" items="${billDataByUser}" varStatus="index">
			<div class="order-item">
				<div class="row">
					<div class="col-3">
						${billDataByUser.fullname}
					</div>
					<div class="col-3">
						Total amount product: ${billDataByUser.quantity}
					</div>
					<div class="col-3">
						Total price: $${billDataByUser.total}
					</div>
					<div class="col-1">
						<c:choose>
					        <c:when test="${billDataByUser.status}">
					            <p>Delivered</p>
					        </c:when>
					        <c:otherwise>
					            <p>Delivering</p>
					        </c:otherwise>
					    </c:choose>
					</div>
					<div class="col-1">
						<c:choose>
					        <c:when test="${billDataByUser.status}">
					            <a class="btn btn-success disabled-link" href="<c:url value="/admin/received/${billDataByUser.idbill}"/>">Delivered</a>
					        </c:when>
					        <c:otherwise>
					            <a class="btn btn-success" href="<c:url value="/admin/received/${billDataByUser.idbill}"/>">Delivered</a>
					        </c:otherwise>
					    </c:choose>
					</div>
					<div class="col-1">
						<c:choose>
					        <c:when test="${billDataByUser.status}">
					            <a class="btn btn-danger disabled-link" href="<c:url value="/admin/order/${billDataByUser.idbill}"/>">Cancel</a>
					        </c:when>
					        <c:otherwise>
					            <a class="btn btn-danger" href="<c:url value="/admin/order/${billDataByUser.idbill}"/>">Cancel</a>
					        </c:otherwise>
					    </c:choose>
					</div>
				</div>
				<hr/>
				<c:forEach var="billDetailDataByUser" items="${billDetailDataByUser}" varStatus="index">
					<c:if test="${ billDataByUser.idbill ==  billDetailDataByUser.idbill}">
						<c:forEach var="product" items="${product}" varStatus="índex">
							<c:if test="${ product.idProduct ==  billDetailDataByUser.productid}">
								<div class="row mb-1">
									<div class="col-2 d-flex align-items-center"></div>
									<div class="col-1 d-flex align-items-center">			
										<img src="<c:url value="/images/layout-key/${product.img}"/>" class="card-img-top" alt="${product.img}">
									</div>
									<div class="col-2 d-flex align-items-center">			
										${product.productName}
									</div>
									<div class="col-1 d-flex align-items-center">			
										Price: $${product.price}
									</div>
									<div class="col-3 d-flex align-items-center">			
										Quantity: ${billDetailDataByUser.quantity}
									</div>
									<div class="col-3 d-flex align-items-center">			
										Total: $${billDetailDataByUser.total}
									</div>
									
								</div>
								<hr/>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</div>
			
			
		</c:forEach>
	</div>
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>