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
                    <td >广告名称：</td>
                    <td >    
                        <input name="name" class="mini-textbox" required="true" emptyText="请输入广告名称" vtype="rangeChar:1,20"/>
                    </td>
                    <td style="width:70px;"></td>
	                <td >           
	                </td>
                </tr>
               
                
                <tr>
                    <td >分类：</td>
                    <td >  
                    	<%-- <input name="goodCategoryType" class="mini-combobox" valueField="id" textField="name" 
                            url="<%=basePath%>/backend/goodCategory/getGoodCategoryList"
                             required="false"  
                             emptyText="请选择分类"
                            />  --%>
                            <input id="parentId"  name="parentId" class="mini-buttonedit" onbuttonclick="onButtonEdit" allowInput="false"/> 
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
            $.post("${basePath}/backend/goodActivityCategory/saveGoodActivityCategory", $("#form1").serialize(), function(info) {
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
                $.post("${basePath}/backend/goodActivityCategory/getGoodActivityCategory?id=" + data.id, function(info) {
             	if (info.status) {
								
                		var o=mini.decode(info.attr.data);
                		form.setData(o);
                        form.setChanged(false);
                   
                        if(o.parentIdName!=null){
                        	mini.get("parentId").setText(o.parentIdName);
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