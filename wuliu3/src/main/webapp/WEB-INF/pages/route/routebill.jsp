<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理取派员</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui-validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
<script
src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/js/common/crud.js"
	type="text/javascript"></script>
<script type="text/javascript">


$(function() {
	
	init("${pageContext.request.contextPath}/routebill/findBypage");

	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/routebill/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/routebill/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});



</script>
</head>
<body   style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/routebill/addRoutebill')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/routebill/findById?id=','${pageContext.request.contextPath }/routebill/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/routebill/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
        <span style="margin-left: 10px">发站省&nbsp;</span><input name="startprovince" type="text" class="easyui-textbox" style="width:100px" > 
        <span style="margin-left: 10px">发站市&nbsp;</span><input name="startcity" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">发站区&nbsp;</span><input name="startdistrict" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站省&nbsp;</span><input name="endprovince" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站市&nbsp;</span><input name="endcity" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">到站区&nbsp;</span><input name="enddistrict" type="text" class="easyui-textbox" style="width:100px" >
        <span style="margin-left: 10px">时限&nbsp;</span><select name="timelimit" type="text"  class="easyui-combobox"  multiple="multiple" style="width:100px" > <option value="1">一天</option><option value="2">两天</option><option value="3">三天</option><option value="4">四天</option></select>
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery()">查询</a> 
      </td>
      </tr>
    </table>
    </div>

	
<table id="grid"  >
	<thead>
			<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="title : '独立节点路由编号',hidden:true,align : 'center',checkbox : false" ></th>
			<th field="name" data-options="width : 200,title : '独立节点路由名称',align : 'center'" ></th>
			<th field="timelimit" data-options="width : 120,title : '时限(天)',align : 'center'" ></th>
			<th field="mileage" data-options="width : 120,title : '里程（公里）',align : 'center'" ></th>
			<th field="routeprice" data-options="width : 120,title : '路由成本（元）',align : 'center'" ></th>
			<th field="startcity" data-options="width : 120,title : '发站市',align : 'center'" ></th>
			<th field="endcity" data-options="width : 120,title : '到站市',align : 'center',checkbox : false" ></th>
			<th field="transfernode1" data-options="width : 120,title : '中转节点1',align : 'center'"  ></th>
			<th field="transfernode2" data-options="width : 120,title : '中转节点2',align : 'center'" ></th>
			<th field="transfernode3" data-options="width : 120,title : '中转节点3',align : 'center',checkbox : false" ></th>
			<th field="transfernode4" data-options="width : 120,title : '中转节点4',align : 'center',checkbox : false" ></th>
			<th field="weight" data-options="width : 120,title : '承载实际重量',align : 'center'"  ></th>
			<th field="vol" data-options="width : 120,title : '承载实际体积',align : 'center'"  ></th>
		</tr>
	
	</thead>
  </table>  


	 
</body>
</html>
