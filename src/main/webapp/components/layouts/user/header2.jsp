<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Finalproject.DB.DBConnection" %>
 --%>

<div class="header-group-2">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container">
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/final_project/user/home">Home</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Category
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	          	<c:forEach var="tag" items="${tag}" varStatus="índex">
				    <li><a class="dropdown-item" href="<c:url value="/user/product/${tag.id}"/>">${tag.name}</a></li>
				</c:forEach>
	          </ul>
	        </li>
	        <c:if test="${not empty LoginInfo }">
	        	<li class="nav-item">
		          	<a class="nav-link" href="<c:url value="/user/order"/>" >Order</a>
		        </li>
	        </c:if>
	        
	      </ul>
	    </div>
	  </div>
	</nav>
</div>