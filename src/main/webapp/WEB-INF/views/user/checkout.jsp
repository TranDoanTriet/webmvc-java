<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss/allCss.jsp" %>
<base href="${pageContext.servletContext.contextPath }"/>
<style type="text/css">
	.a-checkout{
		width: 150px;
	}
</style>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	
	<div class="container mt-5 mb-5">
        
        <div class="row">
        	<div class="col-3"></div>
        	<div class="col-6">
        		<h2>Checkout</h2>
        		<form:form action="final_project/user/checkout" method="POST" modelAttribute="bill">
		            <div class="form-group">
		                <label for="fullName">Full Name:</label>
		                <form:input type="text" path="fullname" class="form-control" id="fullName" name="fullName" required="required"/>
		            </div>
		            <div class="form-group">
		                <label for="email">Email:</label>
		                <form:input type="email" path="email" class="form-control" id="email" name="email" required="required"/>
		            </div>
		            <div class="form-group">
		                <label for="phone">Phone:</label>
		                <form:input type="tel" path="phone" class="form-control" id="phone" name="phone" required="required"/>
		            </div>
		            <div class="form-group">
		                <label for="address">Address:</label>
		                <form:textarea class="form-control" path="address" id="address" name="address" rows="3" required="required"></form:textarea>
		            </div>
		            <div class="form-group">
		                <label for="note">Note:</label>
		                <form:textarea class="form-control" path="note" id="note" name="note" rows="3" ></form:textarea>
		            </div>
		            <div class="d-flex justify-content-end ">
		            	<button type="submit" class="btn btn-secondary mt-2 a-checkout">BUY</button>
		            </div>
		        </form:form>
        	</div>
        	<div class="col-3"></div>
        </div>
    </div>
	
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>