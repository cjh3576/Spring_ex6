<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1> ${board }Write Form</h1>
<form action="${board }Write" method = "post" enctype="multipart/form-data">
	<div class="form-group">
		<label for="title">Title:</label>
		<input type ="text" class="form-control" id="title" name="title">
	</div>
	<div class="form-group">
		<label for="writer">Writer:</label>
		<input type ="text" class="form-control" id="writer" name="writer">
	</div>
	<div class="form-group">
		<label for="writer">Contents:</label>
		<textarea class="form-control" rows="10" cols="" name = "contents"></textarea>
	</div>
	<div class="from-group">
		<label for="file">File</label>
		<input type="file" name="f1">
		<input type="file" name="f1">
	</div>
	<button type="submit" class="btn btn-default">write</button>
</form>
</div>
</body>
</html>