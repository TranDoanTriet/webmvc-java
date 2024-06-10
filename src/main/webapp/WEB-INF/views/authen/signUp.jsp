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
<style>
    .background-radial-gradient {
      background-color: hsl(218, 41%, 15%);
      background-image: radial-gradient(650px circle at 0% 0%,
          hsl(218, 41%, 35%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%),
        radial-gradient(1250px circle at 100% 100%,
          hsl(218, 41%, 45%) 15%,
          hsl(218, 41%, 30%) 35%,
          hsl(218, 41%, 20%) 75%,
          hsl(218, 41%, 19%) 80%,
          transparent 100%);
    }

    #radius-shape-1 {
      height: 220px;
      width: 220px;
      top: -60px;
      left: -130px;
      background: radial-gradient(#cecdcf, #c2bbc6);
      overflow: hidden;
    }

    #radius-shape-2 {
      border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
      bottom: -60px;
      right: -110px;
      width: 300px;
      height: 300px;
      background: radial-gradient(#cecdcf, #c2bbc6);
      overflow: hidden;
    }

    .bg-glass {
      background-color: hsla(0, 0%, 100%, 0.9) !important;
      backdrop-filter: saturate(200%) blur(25px);
    }
  </style>
</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	
	<section class="background-radial-gradient overflow-hidden">
  
<h1>${status }</h1>
  <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
      <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
        <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
          The best offer <br />
          <span style="color: hsl(218, 81%, 75%)">for your business</span>
        </h1>
        <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
        Welcome to KeyMasters, your ultimate destination for premium keyboards. 
        We specialize in offering a diverse range of keyboards, including mechanical, ergonomic, 
        and RGB models. Our collection features top-quality keyboards from leading manufacturers, 
        ensuring durability, precision, and comfort. Whether you're a gamer, a professional typist, 
        or someone who values aesthetics, we have the perfect keyboard for you. At KeyMasters, we're 
        committed to providing exceptional customer service and helping you find the ideal keyboard 
        to enhance your computing experience. Explore our selection today and discover the difference 
        that a quality keyboard can make in your daily life.
        </p>
      </div>
      
      

      <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
        <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
        <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

        <div class="card bg-glass">
          <div class="card-body px-4 py-5 px-md-5">
          	<h2 class="text-center mb-4">Welcome</h2>
            <form:form action="final_project/authen/sign-up" method="POST" modelAttribute="user">
              <!-- 2 column grid layout with text inputs for the first and last names -->

              <div class="row">
                <div class="col-md-6 mb-4">
                  <div data-mdb-input-init class="form-outline">
                  	<form:input type="text" path="fullname" class="form-control" id="form3Example1" required="required"/> 
                    <!-- <input type="text" id="form3Example1" class="form-control" re %>/> -->
                    <label class="form-label" for="form3Example1">Full name</label>
                  </div>
                </div>
                <div class="col-md-6 mb-4">
                  <div data-mdb-input-init class="form-outline">
                    <!-- <input type="text" id="form3Example2" class="form-control" /> -->
                    <form:input type="text" path="phone" class="form-control" id="form3Example2" required="required"/> 
                    <label class="form-label" for="form3Example2">Phone</label>
                  </div>
                </div>
              </div>

              <!-- Email input -->
              <div data-mdb-input-init class="form-outline mb-4">
                <!-- <input type="text" id="form3Example3" class="form-control" /> -->
                <form:input type="text" path="username" class="form-control" id="form3Example3" required="required"/> 
                <label class="form-label" for="form3Example3">User name</label>
              </div>

              <!-- Password input -->
              <div data-mdb-input-init class="form-outline mb-4">
                <!-- <input type="password" id="form3Example4" class="form-control" /> -->
                <form:input type="password" path="password" class="form-control" id="form3Example4" required="required"/> 
                <label class="form-label" for="form3Example4">Password</label>
              </div>
              
              <!-- email -->
              <div data-mdb-input-init class="form-outline mb-4">
                <!-- <input type="email" id="form3Example5" class="form-control" /> -->
                <form:input type="text" path="email" class="form-control" id="form3Example5" required="required"/> 
                <label class="form-label" for="form3Example5">Email</label>
              </div>
              
              <!-- Address -->
              <div data-mdb-input-init class="form-outline mb-4">
                <!-- <input type="email" id="form3Example5" class="form-control" /> -->
                <form:input type="text" path="address" class="form-control" id="form3Example6" required="required"/> 
                <label class="form-label" for="form3Example6">Address</label>
              </div>

              <!-- Submit button -->
              <button type="submit" class="btn btn-secondary btn-block mb-4">
                Sign up
              </button>

              
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	
	
	
	<!-- footer -->
	<%@include file="/components/layouts/user/footer.jsp" %>
	
	
	<!-- function -->
   	<script type="text/javascript" src="<c:url value="/script/script.js"/>"></script>
</body>
</html>