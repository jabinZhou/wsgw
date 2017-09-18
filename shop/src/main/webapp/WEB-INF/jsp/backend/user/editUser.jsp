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
                    <td >用户名称：</td>
                    <td >    
                        <input name="name" class="mini-textbox" required="true" emptyText="请输入用户名称"/>
                    </td>
                    <td style="width:70px;">类型：</td>
	                <td >                        
	                    <select name="userType" class="mini-radiobuttonlist">
	                        <option value="0">买家</option>
	                        <option value="1">卖家</option>
	                    </select>
	                </td>
                </tr>
               
                <tr>
                    <td >账户：</td>
                    <td >    
                        <input name="phone" class="mini-textbox" required="true" vtype="minLength:11" vtype="int" emptyText="请输入账户" requiredErrorText="账户不能为空"/>
                    </td>
                    <td >密码：</td>
                    <td >    
                        <input name="password" class="mini-textbox" required="true" minValue="6"/>
                    </td>
                </tr> 
                <tr>
                    <td >分类：</td>
                    <td >  
                    	<input name="good_category_type" class="mini-combobox" valueField="id" textField="name" 
                            url="<%=basePath%>/backend/goodCategory/goodCategoryList"
                             required="true"
                             emptyText="请选择分类"
                            /> 
                    </td>
                </tr>  
                <tr>
                    <td >状态：</td>
                    <td >  
                    	<select name="status" class="mini-radiobuttonlist">
	                        <option value="0">可用</option>
	                        <option value="1">不可用</option>
	                    </select>  
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
            if (form.isValid() == false) return;

            var json = mini.encode([o]);
            $.post("${basePath}/backend/user/saveUser", $("#form1").serialize(), function(info) {
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
                $.post("${basePath}/backend/user/getUser?id=" + data.id, function(info) {
                	if (info.status) {
                		var o=mini.decode(info.attr.data);
                		form.setData(o);
                        form.setChanged(false);
                        
                        mini.getbyName("good_category_type").setValue(o.name);
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




    </script>
</body>
</html>