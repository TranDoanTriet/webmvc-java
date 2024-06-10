<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss/allCss.jsp" %>
<style type="text/css">
	.input-addProduct{
		width: 400px;
		border: 1px solid black;
	}
</style>
</head>
<body>
<!-- header -->
	<%@include file="/components/layouts/admin/header1.jsp" %>
	<%@include file="/components/layouts/admin/header2.jsp" %>
	
	<div class="container">
		<h1>Add product</h1>  
    
		<form:form method="post" action="/final_project/admin/add-product" enctype="multipart/form-data"> 
			<!-- tên -->
			<p><label for="productName">Product Name</label></p>  
	    	<p><input class="input-addProduct" name="productName" id="productName" type="text" /></p>
			<!-- gia -->
			<p><label for="productPrice">Price</label></p>  
	    	<p><input class="input-addProduct" name="productPrice" id="productPrice" type="number" step="0.01" /></p>  
			<!-- id tag -->
			<p>
				<label for="idTag">Category</label>
		        <select name="idTag" id="idTag">
		            <c:forEach var="tag" items="${tag}">
		                <option value="${tag.id}">${tag.name}</option>
		            </c:forEach>
		        </select>
	   		</p>
	   		<!-- nhà cung cấp -->
	   		<p><label for="productProducer">Producer</label></p>  
	    	<p><input class="input-addProduct" name="productProducer" id="productProducer" type="text"/></p>
	    	<!-- productTitle -->
	   		<p><label for="productTitle">Title</label></p>  
	    	<p><input class="input-addProduct" name="productTitle" id="productTitle" type="text" /></p>
	    	<!-- mô tả -->
	    	<p><label for="productDescription">Description</label></p>
			<p><textarea class="input-addProduct" name="productDescription" id="productDescription"></textarea></p>
	    	<!-- số lượng -->
	    	<p><label for="productQuantity">Quantity</label></p> 
	    	<p><input class="input-addProduct" name="productQuantity" id="productQuantity" type="number" min="1"/></p>
	    	
			<p><label for="fileToUpload">Choose Image</label></p>
			<p><input name="file" id="fileToUpload" type="file" /></p>
			
			<p><input type="submit" value="ADD"></p>  
		</form:form>
	</div>
	  
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>