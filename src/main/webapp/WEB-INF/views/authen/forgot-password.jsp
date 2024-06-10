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
	<div class="container mt-5">
        <h2>Quên mật khẩu</h2>
        <form action="/final_project/forgot-password" method="POST">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <button type="submit" class="btn btn-primary">Gửi</button>
        </form>
    </div>
</body>
</html>