<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
    body
    {
        width:100%;height:100%;margin:0;overflow:hidden;
    }
    /* 导航css */	
    body, div, ul, li{margin:0; padding:0;font-style: normal;font:12px/22px "\5B8B\4F53",Arial, Helvetica, sans-serif} 
	/* \5B8B\4F53 代表 宋体，更多中文字体转 Unicode http://www.divcss5.com/jiqiao/j325.shtml */ 
	ol, ul ,li{list-style:none} 
	img {border: 0; vertical-align:middle} 
	body{color:#000000;background:#FFF; text-align:center} 
	.clear{clear:both;height:1px;width:100%; overflow:hidden; margin-top:-1px} 
	a{color:#000000;text-decoration:none}  
	a:hover{color:#BA2636} 
	 
	.red ,.red a{ color:#F00} 
	.lan ,.lan a{ color:#1E51A2} 
	.pd5{ padding-top:5px} 
	.dis{display:block} 
	.undis{display:none} 
	 
	ul#nav{ width:100%; height:60px; background:#00A2CA;margin:0 auto} 
	ul#nav li{display:inline; height:60px} 
	ul#nav li a{display:inline-block; padding:0 20px; height:60px; line-height:60px; 
	color:#FFF; font-family:"\5FAE\8F6F\96C5\9ED1"; font-size:16px} 
	ul#nav li a:hover{background:#0095BB} 
	
	
	    /* 滑动css */
		.slideBox{ width:960px; height:500px; overflow:hidden; margin:0 auto;  }
		.slideBox .bd{ position:relative; height:100%; z-index:0;   }
		.slideBox .bd li{ zoom:1; vertical-align:middle; }
		.slideBox .bd img{ width:960px; height:500px; display:block;  }
		
		/*广告css border:1px solid #ddd;*/
		.activity{ width:960px; height:225px; overflow:hidden; margin:0 auto;  }
		.activity li{ zoom:1; vertical-align:middle;float:left;margin-left:15px;margin-top:15px;}
		.activity li img{ width:120px; height:80px; display:block;  }
	
	 /**商品文字css**/
	  .good_title a{color:#778899}
	  .good_title a:hover{color:#B22222}
	  .tag_price{color:#778899;font-size:14px;text-decoration:line-through}
	  .market_price{color:#B22222;font-size:16px}
	  .tag_currcy{color:#778899;font-size:12px}
	  .market_currcy{color:#B22222;font-size:12px}
    </style>
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">

</script>
<title>购物网站${type}</title>
</head>
	 <body style="overflow-x:hidden;overflow-y:scroll">
	     <ul id="nav"> 
			<!--  <li><a href="${basePath}">首页</a></li> -->
			<li><a href="${basePath}/goodIndexList?type=1"><%int type=Integer.parseInt(request.getParameter("type"));if(type==1){%><font color="red">鞋子</font><%}else{ %>鞋子 <%} %></a></li> 
			<li><a href="${basePath}/goodIndexList?type=2"><%if(type==2){%><font color="red">口红</font><%}else{ %>口红<%} %></a></li> 
			<li><a href="${basePath}/goodIndexList?type=3"><%if(type==3){%><font color="red">拉箱</font><%}else{ %>拉箱<%} %></a></li> 
			<li><a href="${basePath}/goodIndexList?type=4"><%if(type==4){%><font color="red">包包</font><%}else{ %>包包<%} %></a></li>  
			<li><a href="${basePath}/login">登录</a></li>
		 </ul>
		 <div id="slideBox" class="slideBox">
			<div class="bd">
				<ul>
					<li><a href="http://www.SuperSlide2.com" target="_blank"><img src="${basePath}/img/show.jpg" /></a></li>
					<li><a href="http://www.SuperSlide2.com" target="_blank"><img src="${basePath}/img/pic2.jpg" /></a></li>
					<li><a href="http://www.SuperSlide2.com" target="_blank"><img src="${basePath}/img/pic3.jpg" /></a></li>
					
				</ul>
			</div>
		</div>
		 <div id="activity" class="activity">
			<ul>
			        <c:forEach items="${list}" var="good">
			        <li>
			        <a href="${basePath}/goodIndexList/goodDetail?id=${good.detailId}" target="_blank">
			        <img src="http://127.0.0.1:8082${good.good_image}" />
			        </a>
			        <div class="good_title"><a>${good.title}</a></div>
			        <div><font class="market_currcy"> ¥</font><font class="market_price">${good.good_market_price}</font><font class="tag_currcy"> ¥</font><font class="tag_price">${good.good_tag_price}</font></div>
			        </li>
			        </c:forEach>
			</ul>
		</div>
		<script type="text/javascript">
		jQuery(".slideBox").slide({mainCell:".bd ul",autoPlay:true});
		</script>
	 </body>
</html>