<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务通知单</title>
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
	init("${pageContext.request.contextPath}/workbill/findBypage");
	
	// 添加或者修改的窗口
	$('#addWindow').window({
		width : 700,
		modal : true,
		shadow : true,
		closed : true,
		height : 500,
		resizable : false
	});
	
});


function doAttach(url){
	var rows = $("#grid").datagrid("getSelections");
	if (rows.length == 0 || rows.length > 1) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "有且需要选中一条记录", "warning");
	} else {
		var object = rows[0];//json对象
		var id = object.id;
		$.ajax({
			type : "get",
			url : url+ id,
			error : function() {
				alert("网络出现错误！");
			},
			success : function(data) {
				showCloseReload2(data);
			}
		});
	}
}


function showCloseReload2(data){
	var message;
	if("true"==data){
		message="成功!!!";
		$.messager.show({
    		title:'提示消息',
    		msg:message,
    		timeout:4000,
    		showType:'slide'
    	});
    	// 重新加载数据:
    	$("#addWindow").window("close");
    	$("#grid").datagrid("reload");
	}else if("noallow"==data){
		message="不符合常规操作！";
		$.messager.alert("错误信息",message,"error");
		$("#addWindow").window("close");
		$("#grid").datagrid("reload");
	}else{
		message="后台发生错误";
		$.messager.alert("错误信息",message,"error");
	}
	 
}

//修改的时候回传数据
function doUpdate(findByIdUrl,updataByIdUrl) {
	var rows = $("#grid").datagrid("getSelections");
	var city;
	if (rows.length == 0 || rows.length > 1) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "有且需要选中一条记录", "warning");
	} else {
		var object = rows[0];//json对象
		var id = object.id;
		if(4==object.type){
			$.messager.alert("提示信息", "已销单，不能追单", "warning");
			return;
		}
		$("#addWindow").window("open");
		$('#formAdd').form("clear");
		$.ajax({
			type : "get",
			dataType : "json",
			url : findByIdUrl+ id + "",
			error : function() {
				alert("网络出现错误！");
			},
			success : function(data) {
				//成功则回显数据
				$('#formAdd').form('load',{
					id:data.id,
					"noticebill.id":data.noticebill.id,
					"pickaddress" :data.pickaddress,
					"picktime" :data.picktime,
					"noticebill.telephone" :data.noticebill.telephone,
					"noticebill.delegater" :data.noticebill.delegater,
					"remark" :data.remark,
				});

			}
		});
		$("#save").attr("onclick", "update('"+updataByIdUrl+"');");
		$("input[name='id']").css({
			display : "none"
		});
		
	}
}


function showCloseReload(data){
	var message;
	if(true==data){
		message="成功!!!";
		$.messager.show({
    		title:'提示消息',
    		msg:message,
    		timeout:4000,
    		showType:'slide'
    	});
    	// 关闭窗口:
    	$("#addWindow").window("close");
    	// 重新加载数据:
    	$("#grid").datagrid("reload");
	}else{
		message="后台发生错误";
		$.messager.alert("错误信息",message,"error");
	}
	 
}



function update(updataByIdUrl) {
	
    $.ajax({
        url: updataByIdUrl,
        type:"post",
        data:$("#formAdd").serialize(),
        error : function() {
			alert("网络出现错误！");
		},
			success : function(data) {
				showCloseReload2(data);
		}
    });
	
}

	
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	
	<div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAttach('${pageContext.request.contextPath }/workbill/attachWorkbill?id=')">追单</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/workbill/findById?id=','${pageContext.request.contextPath }/workbill/updateById')">改单</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/workbill/deleteBatch?ids=')">销单</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">客户电话&nbsp;</span><input name="noticebill.telephone" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'mobile'"> 
        <span style="margin-left: 30px">取派员名字 &nbsp;</span><input name="staff.name" type="text" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="validType:'name'"> 
        <span style="margin-left: 30px">受理时间 &nbsp;</span><input name="buildtime" type="text" class="easyui-datebox" style="width:100px" >  
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
			<th field="id" data-options="width : 120,title : '工单编号',align : 'center',checkbox : false" ></th>
			<th field="type" data-options="width : 120,title : '工单类型',align : 'center',formatter : function(data, row, index) {if (data == '1') {return '新单';} else if (data == '2'){return '追单';} else{return '销单';}}" ></th>
			<th field="pickstate" data-options="width : 120,title : '取单状态',align : 'center',formatter : function(data, row, index) {if (data == '1') {return '新单';} else if (data == '2'){return '已通知';} else if (data == '3'){return '已确认';}else if (data == '4'){return '已取件';}else{return '已取消';}}" ></th>
			<th field="buildtime" data-options="width : 120,title : '受理时间',align : 'center'"  ></th>
			<th field="attachbilltimes" data-options="width : 120,title : '追单次数',align : 'center'" ></th>
			<th field="remark" data-options="width : 200 ,title : '备注',align : 'center'" ></th>
			<th field="staff.name" data-options="width : 200 ,title : '取派员名字',align : 'center',formatter:function(value,row,index){var data= row.staff;if(null!=data){  return data.name;}else{return '无';}}" ></th>
			<th field="pickaddress" data-options="width : 200 ,title : '取件地址',align : 'center'" ></th>
			<th field="picktime" data-options="width : 200 ,title : '取件时间',align : 'center'" ></th>
			<th field="noticebill.telephone" data-options="width : 200 ,title : '客户电话',align : 'center',formatter:function(value,row,index){var data= row.noticebill;if(null!=data){  return data.telephone;}else{return '无';}}" ></th>
			<th field="noticebill.customerName" data-options="width : 200 ,title : '客户名字',align : 'center',formatter:function(value,row,index){var data= row.noticebill;if(null!=data){  return data.customerName;}else{return '无';}}" ></th>
		</tr>
	</thead>
  </table>  


	<div class="easyui-window" title="改单" id="addWindow"
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
				<table class="table-edit" width="90%" align="center">
					<tr class="title">
						<td colspan="2">工单信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>工单编号</td>
						<td><input type="text" name="id" class="easyui-validatebox"
							required="true" /></td>
					</tr>
					<tr style="display:none;">
						<td>业务受理单编号</td>
						<td><input type="hidden" name="noticebill.id" class="easyui-validatebox"
							required="true" /></td>
					</tr>
					<tr>
						<td>取件地址</td>
						<td><input type="text" name="pickaddress"
							required="true" /></td>
					</tr>
					<tr>
						<td>取件时间</td>
						<td><input type="text" class="easyui-datebox" name="picktime"
						data-options="required:true, editable:false" /></td>
					</tr>
					<tr>
						<td>客户电话</td>
						<td><input type="text" name="noticebill.telephone"
							class="easyui-validatebox" required="true"  data-options="validType:'mobile'" /></td>
					</tr>
					<tr>
						<td>联系人名字</td>
						<td><input type="text" name="noticebill.delegater"
							class="easyui-validatebox" required="true" /></td>
					</tr>
					<tr>
					<td>备注:</td>
					<td colspan="3"><textarea rows="5" cols="80" type="text" class="easyui-validatebox" name="remark" data-options="validType:'unnormal'"
						 ></textarea></td>
				</tr>

				</table>
			</form>
		</div>
	</div>




	

</body>
</html>