<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<h1>Member LOGIN</h1>
	<form action="memberLogin" method="post">
	<div class="form-group">
	  <label for="id">ID:</label>
	  <input type="text" class="form-control" id="id" name="id">
	</div>
	<div class="form-group">
	  <label for="pw">Password:</label>
	  <input type="password" class="form-control" id="pw" name="pw">
	</div>
	<button class="btn btn-primary">LOGIN</button>
	
	</form>

</div>
</body>
</html>