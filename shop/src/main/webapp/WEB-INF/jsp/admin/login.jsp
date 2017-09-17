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
function login(){
	console.log("login");
	$.post("${basePath}/admin/ajaxLogin", $("#loginForm").serialize(), function(info) {
		if (info.status) {
			if(info.code=="2"){
				alert(info.info);
			}else{
				location.href = "${basePath}/admin/main";
			}
		} else {
			alert(info.info);
		}
	});
}
function cancle(){
	console.log("cancle");
}
function varifyPhone(){
	console.log("varifyPhone");
}
function varifyPassword(){
	console.log("varifyPassword");
}
</script>
<title>Hello world Example</title>
</head>
	 <body>
	     <div class="content" style="width:350px;height:165px;margin-left: 400;
    margin-top: 500;">
	     <h1>用户登录</h1>
	     <form id="loginForm" method="post">
	     <lable>用户名：</lable>
	     <input type="text" name="phone" id="phone" onblur="varifyPhone()">
	     <p>
	     <lable>密&nbsp&nbsp&nbsp码：</lable>
	     <input type="text" name="password" id="password" onblur="varifyPassword()">
	     <p>
	     <button type="button"style="width:50px;height:35px;" onclick="login()">登录</button>
	     <button type="button"style="width:50px;height:35px;" onclick="cancle()">取消</button>
	     </form>
	     </div>
	 </body>
</html>