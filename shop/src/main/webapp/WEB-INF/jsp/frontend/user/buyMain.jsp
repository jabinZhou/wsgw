<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<html>
<head>
    <title>Hello MiniUI!</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <link href="<%=basePath%>/css/demo.css" rel="stylesheet" type="text/css" />
     <style type="text/css">
    body{
        margin:0;padding:0;border:0;width:100%;height:100%;overflow:hidden;
    }    
    .header
    {
        background:url(<%=basePath%>/img/header.gif) repeat-x 0 -1px;
    }
    </style>
    <script src="<%=basePath%>/scripts/boot.js" type="text/javascript"></script> 
    <!--jQuery js-->
    <script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
    <!--MiniUI-->
    <link href="<%=basePath%>/scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css" />        
    <script src="<%=basePath%>/scripts/miniui/miniui.js" type="text/javascript"></script>
</head>
<body>
<!--Layout-->
<div id="layout1" class="mini-layout" style="width:100%;height:100%;">
    <div class="header" region="north" height="70" showSplit="false" showHeader="false">
        <h1 style="margin:0;padding:15px;cursor:default;font-family:微软雅黑,黑体,宋体;">购物网站管理系统 </h1>
        <div style="position:absolute;top:18px;right:10px;">
            <!--  <a class="mini-button mini-button-iconTop" iconCls="icon-add" onclick="onQuickClick" plain="true">快捷</a>    
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >首页</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-date" onclick="onClick"  plain="true" >消息</a>        
            <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick"  plain="true" >设置</a> -->       
            <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="onClick"  plain="true" >首页</a>        
             <!--<a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="test"  plain="true" >操作</a>  -->
            
           
        	<!-- <form id="followForm" method="post">
		     <input name="userId" value="2">
		     <input name="goodId" value="2">
		      <input name="goodDetailId" value="2">
		     <input name="goodNum" value="10"> 
		     
		     <input name="list[0].userId" value="2">
		     <input name="list[0].goodId" value="1">
		     <input name="list[0].goodDetailId" value="1">
		     <input name="list[0].goodNum" value="10">
		     <input name="list[0].totalPrice" value="6000">
		     <input name="list[1].userId" value="2">
		     <input name="list[1].goodId" value="2">
		     <input name="list[1].goodDetailId" value="2">
		     <input name="list[1].goodNum" value="10">
		     <input name="list[1].totalPrice" value="3500">
		     </form>-->
        </div>
        
    </div>
    <div title="south" region="south" showSplit="false" showHeader="false" height="30" >
        <div style="line-height:28px;text-align:center;cursor:default">Copyright © 上海普加软件有限公司版权所有 </div>
    </div>
    <div title="center" region="center" style="border:0;" bodyStyle="overflow:hidden;">
        <!--Splitter-->
        <div class="mini-splitter" style="width:100%;height:100%;" borderStyle="border:0;">
            <div size="180" maxSize="250" minSize="100" showCollapseButton="true" style="border:0;">
                <!--OutlookTree-->
                <div id="leftTree" class="mini-outlooktree" url="<%=basePath%>/data/buyMain.txt" onnodeclick="onNodeSelect"
                    textField="text" idField="id" parentField="pid"                      
                >
                </div>
                
            </div>
            <div showCollapseButton="false" style="border:0;">
                <!--Tabs-->
                <div id="mainTabs" class="mini-tabs" activeIndex="2" style="width:100%;height:100%;"      
                     plain="false" onactivechanged="onTabsActiveChanged"
                >
                    <!--  <div title="首页" url="../../docs/api/overview.html" >        
                    </div>
                   <div title="子页面关闭" url="../tabs/pages/page1.html" >        
                    </div>
                    <div title="弹出面板" url="../datagrid/datagrid.html" >        
                    </div>
                    <div title="弹出面板" url="../datagrid/fixedcolumns.html" >        
                    </div> -->
                </div>
            </div>        
        </div>
    </div>
</div>

    

    <script type="text/javascript">
        mini.parse();

        var tree = mini.get("leftTree");

        function showTab(node) {
            var tabs = mini.get("mainTabs");

            var id = "tab$" + node.id;
            var tab = tabs.getTab(id);
            if (!tab) {
            	tab = {};
                tab._nodeid = node.id;
                tab.name = id;
                tab.title = node.text;
                tab.showCloseButton = true;
                //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
                 tab.url = "<%=basePath%>/backend/" + node.id + "";
                tabs.addTab(tab);
            }
            tabs.activeTab(tab);
        }

        function onNodeSelect(e) {
            var node = e.node;
            var isLeaf = e.isLeaf;

            if (isLeaf) {
            	$.post("<%=basePath%>/ajaxCommon","",function(data){
            		if(data.status){
                		showTab(node);
            		}else{
            			location.href = "${basePath}/login";
            		}
            	});
            }
        }

        function onClick(e) {
            //var text = this.getText();
            //alert(text);
        	location.href = "${basePath}/";
        }
        
        function test(e){
        	//$.post("${basePath}/frontend/shopCar/ajaxAddShopCar", $("#followForm").serialize(), function(info) {
        		$.post("${basePath}/frontend/order/ajaxAddOrder", $("#followForm").serialize(), function(info) {
	    		if (info.status) {
	    			alert(info.info);
	    		} else {
	    			alert(info.info);
	    		}
    		}); 
        }
        function onQuickClick(e) {
            tree.expandPath("datagrid");
            tree.selectNode("datagrid");
        }

        function onTabsActiveChanged(e) {
            var tabs = e.sender;
            var tab = tabs.getActiveTab();
            if (tab && tab._nodeid) {
                
                var node = tree.getNode(tab._nodeid);
                if (node && !tree.isSelectedNode(node)) {
                    tree.selectNode(node);
                }
            }
        }
    </script>

</body>

</body>
</html>