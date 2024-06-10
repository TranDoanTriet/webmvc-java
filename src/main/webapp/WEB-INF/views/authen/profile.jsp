<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss/allCss.jsp" %>

</head>
<body>
	<!-- header -->
	<%@include file="/components/layouts/user/header1.jsp" %>
	<%@include file="/components/layouts/user/header2.jsp" %>
	
	
	<div class="container mt-5 mb-5">
		<div class="row">
			<%-- <div class="col-6">
				<h2>User Profile</h2>
		        <form action="${pageContext.request.contextPath}/authen/updateProfile" method="post">
		            <div class="form-group">
		                <label for="fullname">Full Name</label>
		                <input type="text" class="form-control" id="fullname" name="fullname" value="${user.fullname}" required>
		            </div>
		            <div class="form-group">
		                <label for="email">Email</label>
		                <input type="email" class="form-control" id="email" name="email" value="${user.email}" readonly>
		            </div>
		            <div class="form-group">
		                <label for="address">Address</label>
		                <input type="text" class="form-control" id="address" name="address" value="${user.address}" required>
		            </div>
		            <div class="form-group">
		                <label for="phone">Phone</label>
		                <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" required>
		            </div>
		            <button type="submit" class="btn btn-primary">Update Profile</button>
		        </form>
			</div> --%>
			<div class="col-3"></div>
			<div class="col-6">
				<h3>Change Password</h3>
		        <form action="${pageContext.request.contextPath}/authen/changePassword" method="post">
		            <div class="form-group">
		                <label for="currentPassword">Current Password</label>
		                <input type="password" class="form-control" id="currentPassword" name="currentPassword" required>
		            </div>
		            <div class="form-group">
		                <label for="newPassword">New Password</label>
		                <input type="password" class="form-control" id="newPassword" name="newPassword" required>
		            </div>
		            <div class="form-group">
		                <label for="confirmPassword">Confirm New Password</label>
		                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
		            </div>
		            <button type="submit" class="btn btn-secondary mt-2 a-checkout">Change Password</button>
		        </form>
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