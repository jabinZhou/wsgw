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
<link rel="stylesheet" href="<%=basePath%>/css/situation.css">
	<link rel="stylesheet" href="<%=basePath%>/css/login.css">
	<script src="<%=basePath%>/js/jquery.min.js"></script>
	<script src="<%=basePath%>/js/lb.js"></script>
<script type="text/javascript">
function login(){
	console.log("login");
	$.post("${basePath}/ajaxLogin", $("#loginForm").serialize(), function(info) {
		if (info.status) {
			if(info.code=="2"){
				alert(info.info);
			}else{
				if(info.arg1==0){
					location.href = "${basePath}/frontend/user/buyMain";
				}else{
					location.href = "${basePath}/frontend/user/sellMain";
				}
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
$(document).ready(function(){
	$('.box').imgtransition({
		speed:3000,  //图片切换时间
		animate:1000 //图片切换过渡时间
	});
});
</script>
<title>登录</title>
</head>
	 <body>
	     <!--  <h1>user</h1>
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
	     </div>-->
	     
	     <div class="box">
		<ul class="box-ul">
			<li class="">
				<img src="<%=basePath%>/img/bg2.png" alt="">
			</li>
			<li class="">
				<img src="<%=basePath%>/img/bg1.png" alt="" >
			</li>
			
		</ul>
		<div class="login">
			<div class="login-left">
				<img src="<%=basePath%>/img/user.png" alt="" class="user_img">
			</div>
			<div class="login-right">
				<img src="<%=basePath%>/img/little-logo.png" alt="" class="logo" width="157px" height="41px">
				<form id="loginForm" method="post">
					<div class="same">
						<p>用户名：</p>
						<input type="text" class="input_1" name="phone" id="phone" onblur="varifyPhone()">
					</div>
					<div class="same">
						<p>密&emsp;码：</p>
						<input type="password" class="input_2" name="password" id="password" onblur="varifyPassword()">
					</div>
					<!--<div class="same">
						<p>验证码：</p>
						<input type="text" class="input_3">
						<img src="statics/images/code.png" alt="" class="code">
				    </div>-->
					<button class="butt" onclick="login()"></button>	
				</form>
			</div>
		</div>	
		<div class="foot">
			<p>Copyright © 2003-2013 www.botuu.com, 粤ICP备 11018280号-1, All Rights Reserved</p>
		</div>	
	</div>
	 </body>
</html>