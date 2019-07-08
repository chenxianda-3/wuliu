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
	
	init("${pageContext.request.contextPath}/workorder/findBypage");

	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/workorder/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/workorder/isImport";
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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/workorder/addWorkorder')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/workorder/findById?id=','${pageContext.request.contextPath }/workorder/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/workorder/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">寄件人电话&nbsp;</span><input name="senderphone" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" > 
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
			<th field="id" data-options="width : 250,title : '工作单编号',align : 'center',checkbox : false" ></th>
			<th field="state" data-options="width : 120,title : '工作单状态',align : 'center',checkbox : false,formatter : function(data, row, index) {if (data == '0') {return '已揽收';}else if (data == '1') {return '正在配送';}else if (data == '2') {return '拒绝签收';}else if (data == '3') {return '已经签收';} else {return '无';}}" ></th>
			<th field="sendername" data-options="width : 120,title : '寄件人姓名',align : 'center'" ></th>
			<th field="senderphone" data-options="width : 120,title : '寄件人电话',align : 'center'" ></th>
			<th field="senderaddr" data-options="width : 120,title : '寄件人地址',align : 'center'"  ></th>
			<th field="receivername" data-options="width : 120,title : '收件人姓名',align : 'center'" ></th>
			<th field="receiverphone" data-options="width : 120 ,title : '收件人电话',align : 'center'" ></th>
			<th field="receiveraddr" data-options="width : 200,title : '收件人地址',align : 'center'" ></th>
			<th field="product" data-options="width : 60 ,title : '产品',align : 'center'" ></th>
			<th field="num" data-options="width : 60,title : '件数',align : 'center'" ></th>
			<th field="weight" data-options="width : 60 ,title : '重量',align : 'center'" ></th>
			<th field="floadreqr" data-options="width : 120,title : '配载要求',align : 'center'" ></th>
			<th field="vol" data-options="width : 60 ,title : '体积',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  

	<div class="easyui-window" title="对工作单进行添加或者修改" id="addWindow"
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
						<td>工作单编号</td>
						<td><input type="text" name="id" class="easyui-validatebox"
							required="true" /></td>
					</tr>
					<tr>
						<td>寄件人姓名</td>
						<td><input type="text" name="sendername" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>寄件人电话</td>
						<td><input type="text" name="senderphone" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>寄件人地址</td>
						<td><input type="text" name="senderaddr" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>收件人姓名</td>
						<td><input type="text" name="receivername" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>收件人电话</td>
						<td><input type="text" name="receiverphone" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>收件人地址</td>
						<td><input type="text" name="receiveraddr" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>产品</td>
						<td><input type="text" name="product" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>件数</td>
						<td><input type="text" name="num" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>重量</td>
						<td><input type="text" name="weight" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>配载要求</td>
						<td><input type="text" name="floadreqr" class="easyui-validatebox"/></td>
					</tr>
					<tr>
						<td>体积</td>
						<td><input type="text" name="vol" class="easyui-validatebox"/></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>


	 
</body>
</html>
