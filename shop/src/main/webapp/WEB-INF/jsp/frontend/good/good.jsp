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
                        <input id="key" class="mini-textbox" emptyText="请输入标题或名称" style="width:150px;" onenter="onKeyEnter"/>   
                        <a class="mini-button" onclick="search()">查询</a>
                    </td>
                </tr>
            </table>           
        </div>
    </div>
    <div id="datagrid1" class="mini-datagrid" style="width:800px;height:280px;" allowResize="true"
        url="<%=basePath%>/frontend/good/goodList"  idField="id" multiSelect="true" 
    >
        <div property="columns">
            <!--<div type="indexcolumn"></div>        -->
            <div type="checkcolumn" ></div>        
            <div field="title" width="120" headerAlign="center" allowSort="true">标题</div> 
            <div field="name" width="120" headerAlign="center" allowSort="true">名称</div>    
            <div field="good_image" width="120" headerAlign="center" allowSort="true">图片地址</div>
            <!-- <div field="status" width="120" headerAlign="center" allowSort="true" renderer="onTypeRenderer">商品状态</div> -->
            <div field="good_tag_price" width="120" headerAlign="center" >标签价</div> 
            <div field="good_market_price" width="120" headerAlign="center" >上架价</div>     
            <div field="categoryName" width="120" headerAlign="center">所属分类</div> 
            <div field="activityName" width="120" headerAlign="center">所属活动</div> 
            <div field="activity_title" width="120" headerAlign="center" >活动标题</div> 
            <div field="activity_price" width="120" headerAlign="center" >活动价</div>    
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
                url: "${basePath}/frontend/good/editGood",
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
                    url: "${basePath}/frontend/good/editGood",
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
                    $.post("${basePath}/frontend/good/delGood?id=" +id, function(info) {
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
        
        var Types = [{ id: 0, text: '待审核' }, { id: 1, text: '审核通过'}, { id: 2, text: '审核不通过'}];        
        function onTypeRenderer(e) {
            for (var i = 0, l = Types.length; i < l; i++) {
                var g = Types[i];
                if (g.id == e.value) return g.text;
            }
            return "";
        }
        
    </script>
	 </body>
</html>