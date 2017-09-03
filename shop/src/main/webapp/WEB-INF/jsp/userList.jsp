<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello world Example</title>
</head>
	 <body>
	     <h1>Hello ${user}, How are you?</h1>
	     <br>
	     <p>JSP demo, works!</p>
	     <img src="/img/show.jpg" style="width:300px;height:200px;">
	     
	     <table border="1">
	        <c:forEach items="${userList}" var="user" varStatus="vs">
			<tr>
			  <td>${user.id}</td><td>${user.name}</td> <td>${user.phone}</td>
			</tr>
			</c:forEach>
		 </table>
	 </body>
</html>