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
	
	init("${pageContext.request.contextPath}/staff/findBypage");

	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/staff/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/staff/isImport";
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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/staff/addStaff')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/staff/findById?id=','${pageContext.request.contextPath }/staff/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/staff/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">取派员编号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'length[0,32]',validType:'isBlank'"> 
        <span style="margin-left: 30px">名字 &nbsp;</span><input name="name" type="text" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="validType:'name'"> 
        <span style="margin-left: 30px">电话 &nbsp;</span><input name="telephone" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'mobile'">  
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
			<th field="id" data-options="width : 120,title : '取派员编号',align : 'center',checkbox : false" ></th>
			<th field="name" data-options="width : 120,title : '姓名',align : 'center'" ></th>
			<th field="telephone" data-options="width : 120,title : '手机号',align : 'center'" ></th>
			<th field="haspda" data-options="width : 120,title : '是否有PDA',align : 'center',formatter : function(data, row, index) {if (data == '1') {return '有';} else {return '无';}}"  ></th>
			<th field="password" data-options="width : 120,title : '密码',align : 'center'" ></th>
			<th field="station" data-options="width : 200 ,title : '所在单位',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  

	<div class="easyui-window" title="对收派员进行添加或者修改" id="addWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top: 20px; left: 200px">
		<div region="north" style="height: 31px; overflow: hidden;"
			split="false" border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" class="easyui-linkbutton" plain="true">保存</a>
			</div>
		</div>

		<div region="center" style="overflow: auto; padding: 5px;"
			border="false">
			<form id="formAdd">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">取派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox"
							required="true" /></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox"
							required="true" data-options="validType:'name'" /></td>
					</tr>
					<tr>
						<td>密码</td>
						<td><input type="text" name="password"
							class="easyui-validatebox" required="true"   /></td>
					</tr>
					<tr>
						<td>手机</td>
						<td><input type="text" name="telephone"
							class="easyui-validatebox" required="true"  data-options="validType:'mobile'" /></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td colspan="2">是否有PDA <select name="haspda">
								<option value="1">是</option>
								<option value="0">否</option>
						</select>
						</td>

					</tr>

				</table>
			</form>
		</div>
	</div>


	 
</body>
</html>
