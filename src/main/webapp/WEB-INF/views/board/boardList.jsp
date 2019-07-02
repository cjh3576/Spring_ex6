<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  		var kind = '${pager.kind}';
  		$(".k").each(function(){
  			if($(this).val() == kind){
  				$(this).prop("selected", true);
  			}
  		});
  	});
  
  </script>
</head>
<body>
<div class="container">
<h1> ${board } List</h1>
<form action="./${board}List" class="form-inline" >
	<div class="from-group col-xs-2">
		<select name = "kind" class="form-control">
			<option class="k" value="1">Title</option>
			<option class="k" value="2">Writer</option>
			<option class="k" value="3">Contents</option>
		</select>
	</div>

	<div class="form-group col-xs-2">
		<input type="text" class="form-control" name="search">
	</div>
	<div class="form-group col-xs-2">
		<button class="form-control">Search</button>
	</div>

</form>

<table class="table table-hover">
	<thead>
	<tr>
		<th>NUM</th>
		<th>title</th>
		<th>wrtier</th>
		<th>date</th>
		<th>hit</th>
	</tr>
	</thead>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.num }</td>
			<td><a href="${board }Select?num=${dto.num}">${dto.title }</a></td>
			<td>${dto.writer }</td>
			<td>${dto.reg_date }</td>
			<td>${dto.hit }</td>
		</tr>
	</c:forEach>
</table>
	<ul class="pagination">
	<c:if test="${pager.curBlock >1 }">
		<li><a href="./${board }List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">[이전]</a></li>
	</c:if>
	
	<c:forEach begin="${pager.startNum }" end ="${pager.lastNum}" var="i">
		<li><a href="./${board }List?curPage=${i }&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
	</c:forEach>
	
	<c:if test="${pager.curBlock < pager.totalBlock }">
		<li><a href="./${board }List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">	[다음]</a></li>s
	</c:if>
	</ul>
	<div>
	<a href="${board }Write" class="btn btn-primary">write</a>
	</div>
</div>
</body>
</html>