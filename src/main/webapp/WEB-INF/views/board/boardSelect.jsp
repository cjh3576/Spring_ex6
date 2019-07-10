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
	<h1>${board } Select Page</h1>
	<table class="table table-hover">
		<thead>
			<tr>
			<th>Title</th>
			<th>Writer</th>
			<th>Contents</th>
			<th>File</th>
			</tr>
		</thead>
			<tbody>
			<tr>
			 	<td>${dto.title }</td>
			 	<td>${dto.writer}</td>
				<td>${dto.contents }</td>
				<c:forEach items="${dto.files }" var="file">
				<td><a href="../resources/upload/${file.fname}">${file.oname }</a></td>
				</c:forEach>
			</tr>
			</tbody>
	</table>
	<a href="./${board }Update?num=${dto.num}" class="btn btn-primary">Update</a>
	<a href="./${board }Delete?num=${dto.num}" class="btn btn-danger">Delete</a>
	<a href="./${board }List" class="btn btn-default">List</a>
	</div>
</body>
</html>