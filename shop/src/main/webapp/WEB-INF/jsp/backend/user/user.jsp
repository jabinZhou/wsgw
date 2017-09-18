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
<title>Hello world Example</title>
</head>
	 <body>
	     <h1>DataGrid 数据表格</h1>      

    <div style="width:800px;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
            <table style="width:100%;">
                <tr>
                    <td style="width:100%;">
                        <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                        <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                        <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>       
                    </td>
                    <td style="white-space:nowrap;">
                        <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid1" class="mini-datagrid" style="width:800px;height:280px;" allowResize="true"
        url="<%=basePath%>/backend/user/userList"  idField="id" multiSelect="true" 
    >
        <div property="columns">
            <!--<div type="indexcolumn"></div>        -->
            <div type="checkcolumn" ></div>        
            <div field="name" width="120" headerAlign="center" allowSort="true">用户名称</div>    
            <div field="user_type" width="120" headerAlign="center" allowSort="true" renderer="onTypeRenderer">用户类型</div>  
            <div field="type_name" width="120" headerAlign="center" allowSort="true" >所属分类</div>
            <div field="phone" width="120" headerAlign="center" allowSort="true">用户账户</div>    
            <div field="status" width="120" headerAlign="center" allowSort="true" renderer="onStatusRenderer">用户状态</div>    
            <div field="create_date" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" renderer="onTimeRenderer">创建时间</div> 
            <div field="update_date" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true" renderer="onTimeRenderer">更新时间</div>       
                              
        </div>
    </div>
    

    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("datagrid1");
        grid.load();
        grid.sortBy("create_date", "desc");

        
        function add() {
            
            mini.open({
                url: "${basePath}/backend/user/editUser",
                title: "新增员工", width: 600, height: 400,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = { action: "new"};
                    iframe.contentWindow.SetData(data);
                },
                ondestroy: function (action) {

                    grid.reload();
                }
            });
        }
        function edit() {
         
            var row = grid.getSelected();
            if (row) {
                mini.open({
                    url: "${basePath}/backend/user/editUser",
                    title: "编辑员工", width: 600, height: 400,
                    onload: function () {
                        var iframe = this.getIFrameEl();
                        var data = { action: "edit", id: row.id };
                        iframe.contentWindow.SetData(data);
                        
                    },
                    ondestroy: function (action) {
                        grid.reload();
                        
                    }
                });
                
            } else {
                alert("请选中一条记录");
            }
            
        }
        function remove() {
            
            var rows = grid.getSelecteds();
            if (rows.length > 0) {
                if (confirm("确定删除选中记录？")) {
                    var ids = [];
                    for (var i = 0, l = rows.length; i < l; i++) {
                        var r = rows[i];
                        ids.push(r.id);
                    }
                    var id = ids.join(',');
                    grid.loading("操作中，请稍后......");
                    $.post("${basePath}/backend/user/delUser?id=" +id, function(info) {
                		if (info.status) {
                			 grid.reload();
                		} else {
                			alert(info.info);
                			grid.reload();
                		}
                	});
                }
            } else {
                alert("请选中一条记录");
            }
        }
        function search() {
            var key = mini.get("key").getValue();
            grid.load({ key: key });
        }
        function onKeyEnter(e) {
            search();
        }
        /////////////////////////////////////////////////
        function onTimeRenderer(e) {
            var value = e.value;
            if (value) return mini.formatDate(value, 'yyyy-MM-dd');
            return "";
        }
        var Types = [{ id: 0, text: '买家' }, { id: 1, text: '卖家'}];        
        function onTypeRenderer(e) {
            for (var i = 0, l = Types.length; i < l; i++) {
                var g = Types[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
      
        var Status = [{ id: 0, text: '可用' }, { id: 1, text: '不可用'}];       
        function onStatusRenderer(e){
        	for (var i = 0, l = Status.length; i < l; i++) {
                var g = Status[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
    </script>
	 </body>
</html>