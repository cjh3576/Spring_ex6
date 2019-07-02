<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="notice/noticeList">noticeList</a>
<c:if test="${sessionScope.dto eq null }">
<a href="member/memberJoin">JOIN</a>
<a href="member/memberLogin">LOGIN</a>
</c:if>
<c:if test="${sessionScope.dto ne null }">
<a href="member/memberLogout">LOGOUT</a>
</c:if>
</body>
</html>
