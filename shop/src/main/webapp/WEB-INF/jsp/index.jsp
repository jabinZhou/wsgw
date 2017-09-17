<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
    body
    {
        width:100%;height:100%;margin:0;overflow:hidden;
    }	
    </style>
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

</script>
<title>Hello world Example</title>
</head>
	 <body>
	     <h1>好好啊红烧豆腐阿斯蒂芬</h1>
	 </body>
</html>