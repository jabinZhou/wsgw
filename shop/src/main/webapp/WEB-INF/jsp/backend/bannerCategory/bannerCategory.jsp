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
                        <input id="key" class="mini-textbox" emptyText="请输入广告名称" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
     <div id="treegrid1" class="mini-treegrid" style="width:800px;height:280px;" 
        url="<%=basePath%>/backend/bannerCategory/bannerCategoryList"  treeColumn="taskname" idField="id" 
        parentField="parent_id" resultAsTree="false" expandOnLoad="true" 
    >
<%--     <div id="treegrid1" class="mini-treegrid" style="width:800px;height:280px;"     
    url="<%=basePath%>/data/tasks.txt" showTreeIcon="true" 
    treeColumn="taskname" idField="UID" parentField="ParentTaskUID" resultAsTree="false" expandOnLoad="true"
	> --%>
	
	  <div property="columns">
        <div type="indexcolumn"></div>
        <div name="taskname" field="name" width="300">广告名称</div>
        <div field="create_date" width="100" dateFormat="yyyy-MM-dd">开始日期</div>
        <div field="update_date" width="100" dateFormat="yyyy-MM-dd">完成日期</div>
    </div>
	
        
    </div>
    

    <script type="text/javascript">
        mini.parse();

        var grid = mini.get("treegrid1");
        /* grid.load();
        grid.sortBy("create_date", "desc"); */
   
        
        function add() {
            
            mini.open({
                url: "${basePath}/backend/bannerCategory/editBannerCategory",
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
                    url: "${basePath}/backend/bannerCategory/editBannerCategory",
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
                    $.post("${basePath}/backend/bannerCategory/delBannerCategory?id=" +id, function(info) {
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
      /*   function search() {
            var key = mini.get("key").getValue();
            grid.load({ key: key });
        } */
        function search() {
            var key = mini.get("key").getValue();
            if (key == "") {
            	grid.clearFilter();
            } else {
                key = key.toLowerCase();
                grid.filter(function (node) {
                    var text = node.name ? node.name.toLowerCase() : "";
                    if (text.indexOf(key) != -1) {
                        return true;
                    }
                });
            }
        }
        function onKeyEnter(e) {
            search();
        }
       
    </script>
	 </body>
</html>