<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Send Email</h1>
    <form action="" method="post">
    	<div>
            <label for="from">From:</label>
            <input type="text" id="from" />
        </div>
        <div>
            <label for="to">To:</label>
            <input type="text" id="to" />
        </div>
        <div>
            <label for="subject">Subject:</label>
            <input type="text" id="subject"  />
        </div>
        <div>
            <label for="body">Body:</label>
            <textarea id="body"></textarea>
        </div>
        <div>
            <button type="submit">Send</button>
        </div>
    </form>
</body>
</html>