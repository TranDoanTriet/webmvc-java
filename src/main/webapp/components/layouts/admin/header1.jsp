<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="bg-black">
	<div class="container">
	  <div class="row">
	    <div class="col">
	      <c:choose>
			    <c:when test="${not empty LoginInfo}">
			        <a href="<c:url value="/authen/logout"/>" class="txt-white">Log out</a>
			    </c:when>
			    <c:otherwise>
			        <a href="<c:url value="/authen/login"/>" class="txt-white">Log in</a>
			    </c:otherwise>
			</c:choose>
	    </div>
	    <div class="col txt-center">
	    	<c:choose>
			    <c:when test="${not empty LoginInfo}">
			        <a href="#" class="txt-white">${ LoginInfo.fullname}</a>
			    </c:when>
			    <c:otherwise>
			        <a href="#" class="txt-white">Welcome to our online store!</a>
			    </c:otherwise>
			</c:choose>
	     
	    </div>
	    <div class="col">
	    </div>
	  </div>
	</div>
</div>



<div class="header-group-1">
	<div class="container">
	  <div class="row">
	     <div class="col-8"><a href="#" class="logo-home">Keyboard</a></div>
	     <div class="col-4 txt-end">
		     	<div class="row">
		     		<div class="col-10">
		     			<input type="password" class="form-control" id="inputPassword" placeholder="search">
		     		</div>
		     		<div class="col-2">
		     			<button class="btn btn-secondary">Search</button>
		     		</div>
		     	</div>
		      	
	    	</div>
	     </div>
	 </div>
</div>