<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域设置</title>
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
	
	init("${pageContext.request.contextPath}/region/findBypage");

	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/region/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/region/isImport";
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
<body class="easyui-layout" style="visibility:hidden;">


 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/region/findById?id=','${pageContext.request.contextPath }/region/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/region/deleteBatch?ids=')">删除</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">省&nbsp;</span><input name="province" class="easyui-textbox" style="width:100px" data-options="validType:'CHS'"> 
        <span style="margin-left: 30px">市 &nbsp;</span><input name="city"  class="easyui-textbox " style="width:100px" data-options="validType:'CHS'"> 
        <span style="margin-left: 30px">区 &nbsp;</span><input name="district"  class="easyui-textbox" style="width:100px" data-options="validType:'CHS'">  
         <span style="margin-left: 30px">邮编 &nbsp;</span><input name="postcode"  class="easyui-textbox " style="width:100px" data-options="validType:'zipcode'">  
        <span style="margin-left: 30px">简码 &nbsp;</span><input name="shortcode"  class="easyui-textbox " style="width:100px" data-options="validType:'english'">  
        <span style="margin-left: 30px">城市编码 &nbsp;</span><input name="citycode"  class="easyui-textbox " style="width:100px" data-options="validType:'english'">  
        
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
			<th field="id" data-options="width : 120,title : '区域编号',align : 'center',checkbox : false" ></th>
			<th field="province" data-options="width : 120,title : '省',align : 'center'" ></th>
			<th field="city" data-options="width : 120,title : '市',align : 'center'" ></th>
			<th field="district" data-options="width : 120,title : '区',align : 'center'"  ></th>
			<th field="postcode" data-options="width : 120,title : '邮编',align : 'center'" ></th>
			<th field="shortcode" data-options="width : 120 ,title : '简码',align : 'center'" ></th>
			<th field="citycode" data-options="width : 200 ,title : '城市编码',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  
	
	<div class="easyui-window" title="区域修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">区域信息</td>
					</tr >
						<tr style="display : 'none';">
						<td>区域编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
						<td>省</td>
						<td><input type="text" name="province" class="easyui-validatebox" required="true" data-options="validType:'CHS'"/></td>
					</tr>
					<tr>
						<td>市</td>
						<td><input type="text" name="city" class="easyui-validatebox" required="true" data-options="validType:'CHS'"/></td>
					</tr>
					<tr>
						<td>区</td>
						<td><input type="text" name="district" class="easyui-validatebox" required="true" data-options="validType:'CHS'"/></td>
					</tr>
					<tr>
						<td>邮编</td>
						<td><input type="text" name="postcode" class="easyui-validatebox" required="true" data-options="validType:'zipcode'"/></td>
					</tr>

					</table>
			</form>
		</div>
	</div>
</body>
</html>