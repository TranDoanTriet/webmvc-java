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
        <h2>Đặt lại mật khẩu</h2>
        <form action="/final_project/reset-password" method="POST">
            <input type="hidden" name="token" value="${token}">
            <div class="form-group">
                <label for="password">Mật khẩu mới:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Đặt lại mật khẩu</button>
        </form>
    </div>
</body>
</html>