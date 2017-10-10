<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="<%=basePath%>/css/demo.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>/scripts/boot.js" type="text/javascript"></script> 
<script src="<%=basePath%>/js/common.js" type="text/javascript"></script> 
<script src="<%=basePath%>/js/TreeSelectWindow.js" type="text/javascript"></script> 
<script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
<style type="text/css">
    html, body
    {
        font-size:12px;
        padding:0;
        margin:0;
        border:0;
        height:100%;
        overflow:hidden;
    }
    </style>
<title>Hello world Example</title>
</head>
	 <body>
	     <form id="form1" method="post">
        <input name="id" class="mini-hidden" />
        <div style="padding-left:11px;padding-bottom:5px;">
            <table style="table-layout:fixed;">
               
                <tr>
                    <td >标题：</td>
                    <td >    
                        <input name="title" class="mini-textbox" required="true" emptyText="请输入标题" vtype="rangeChar:1,20"/>
                    </td>
                    <td style="width:70px;">名称：</td>
	                <td >                        
	                     <input name="name" class="mini-textbox" required="true" emptyText="请输入名称" vtype="rangeChar:1,20"/>
	                </td>
                </tr>
               
                <tr>
                    <td >地址：</td>
                    <td >    
                        <input name="goodImage" class="mini-textbox" required="true"  emptyText="请输入地址" requiredErrorText="地址不能为空" vtype="rangeChar:1,255"/>
                    </td>
                    <td style="width:70px;">商品状态：</td>
	                <td >                        
	                     <input name="status" class="mini-combobox" valueField="value" textField="name" 
                            url="<%=basePath%>/backend/dict/dictList?key=goodStatus"
                             required="true"
                             emptyText="请选择商品状态"
                            />
	                </td>
                    
                </tr> 
                <tr>
                    <td >分类：</td>
                    <td >  
                    	<input id="goodCategoryType"  name="goodCategoryType" class="mini-buttonedit" onbuttonclick="onButtonEdit" allowInput="false"/> 
                    </td>
                    <td style="width:70px;">活动：</td>
	                <td>                        
	                      <input id="goodActivityId" name="goodActivityId" class="mini-buttonedit" onbuttonclick="onButtonEdit2" allowInput="false"/>
	                </td>
                    
                </tr>  
                <tr>
                    <td >  
                    	<input name="detailId" class="mini-hidden">
                    </td>
                    
                </tr> 
                <tr>
                    <td >商品多图:</td>
                    <td >  
                    	<input name="goodImages" class="mini-textbox" required="true">
                    </td>
                    <td >商品详情图：</td>
                    <td >  
                    	<input name="goodDetail" class="mini-textbox" required="true">
                    </td>
                    
                </tr> 
                <tr>
                    <td >商品标签价格：</td>
                    <td >  
                    	<input name="goodTagPrice" class="mini-textbox" required="true" vtype="int">
                    </td>
                    <td >商品上架价格：</td>
                    <td >  
                    	<input name="goodMarketPrice" class="mini-textbox" required="true" vtype="int">
                    </td>
                    
                </tr> 
                 
            </table>
        </div>
        <div style="text-align:center;padding:10px;">               
            <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>       
            <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>       
        </div>        
    </form>
    <script type="text/javascript">
    
        mini.parse();

        var form = new mini.Form("form1");

        function SaveData() {
            var o = form.getData();            

            form.validate();
            if (form.isValid() == false){ 
            	 var errors =  form.getErrorTexts();
                 var t = errors[0]
                 mini.alert(t)	
            return;
            }

            var json = mini.encode([o]);
            $.post("${basePath}/backend/good/saveGood", $("#form1").serialize(), function(info) {
        		if (info.status) {
        			CloseWindow("save");
        		} else {
        			alert(info.info);
        			CloseWindow();
        		}
        	});
        }

        ////////////////////
        //标准方法接口定义
        function SetData(data) {
            if (data.action == "edit") {
                //跨页面传递的数据对象，克隆后才可以安全使用
                data = mini.clone(data);
                $.post("${basePath}/backend/good/getGood?id=" + data.id, function(info) {
                	if (info.status) {
                		var o=mini.decode(info.attr.data);
                		form.setData(o);
                        form.setChanged(false);
                        if(o.categoryName!=null){
                        	mini.get("goodCategoryType").setText(o.categoryName);
                        }
                        if(o.activityName!=null){
                        	mini.get("goodActivityId").setText(o.activityName);
                        }
                        
            		} else {
            			alert(info.info);
            		}
            	});
               
            }
        }

        function GetData() {
            var o = form.getData();
            return o;
        }
        function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        }
        function onOk(e) {
            SaveData();
        }
        function onCancel(e) {
            CloseWindow("cancel");
        }


        function onButtonEdit(e) {
            var buttonEdit = e.sender;
            
            var win = new TreeSelectWindow();
            win.set({
//                multiSelect: true,
//                showFolderCheckBox: true,
//                checkRecursive: true,                
                url: "${basePath}/backend/goodCategory/goodCategoryListClick",    
                title: "选择树形",
                width: 350,
                height: 350
            });
            
            win.show();

            //初始化数据
            win.setData(null, function (action) {
                if (action == "ok") {
                    //获取数据
                    var data = win.getData();
                    if (data) {
                        buttonEdit.setValue(data.id);
                        buttonEdit.setText(data.text);

                    }
                }
            });
        }

        function onButtonEdit2(e) {
            var buttonEdit = e.sender;
            
            var win = new TreeSelectWindow();
            win.set({
//                multiSelect: true,
//                showFolderCheckBox: true,
//                checkRecursive: true,                
                url: "${basePath}/backend/goodActivityCategory/goodActivityCategoryListClick",    
                title: "选择树形",
                width: 350,
                height: 350
            });
            
            win.show();

            //初始化数据
            win.setData(null, function (action) {
                if (action == "ok") {
                    //获取数据
                    var data = win.getData();
                    if (data) {
                        buttonEdit.setValue(data.id);
                        buttonEdit.setText(data.text);

                    }
                }
            });
        }

    </script>
</body>
</html>