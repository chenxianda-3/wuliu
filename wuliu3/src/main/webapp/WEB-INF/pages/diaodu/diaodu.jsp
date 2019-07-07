<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人工调度</title>
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
	init("${pageContext.request.contextPath}/workbill/diaoDuBypage");

});

function doChongFa(chongFaBatchUrl) {
	//获取数据表格中所有选中的行，返回数组对象
	var rows = $("#grid").datagrid("getSelections");
	if (rows.length == 0) {
		//没有选中记录，弹出提示
		$.messager.alert("提示信息", "请选择需要重发的条目！", "warning");
	} else {
		//选中了取派员,弹出确认框
		$.messager
				.confirm("删除确认","你确定要重发选中的条目吗？",
						function(r) {
							if (r) {

								var array = new Array();
								//确定,发送请求
								//获取所有选中的取派员的id
								for (var i = 0; i < rows.length; i++) {
									var object = rows[i];//json对象
									var id = object.id;
									array.push(id);
								}
								var ids = array.join(",");//1,2,3,4,5
								$.ajax({
											type : "get",
											url : chongFaBatchUrl+ ids,
											error : function() {
												alert("网络出现错误！");
											},
											success : function(data) {
												if("false"==data){
													message="后台发生错误";
										    		$.messager.alert("错误信息",message,"error");
												}else{
													$("#grid").datagrid("reload");
												}
											}
										});

							}
						});
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
		$("#addWindow").window("open");
		$('#formAdd').form("clear");
		$('#formAdd').form(
				'load',
				findByIdUrl+ id + "");
		showStaffName();
		$("#save").attr("onclick", "update('"+updataByIdUrl+"');");
	}
}



function  update(updataByIdUrl) {
    $.ajax({
        url: updataByIdUrl,
        type:"post",
        data:$("#formAdd").serialize(),
        error : function() {
			alert("网络出现错误！");
		},
			success : function(data) {
				showCloseReload(data)
		}
    });
	
}


function showStaffName(){
	
	$.ajax({
		 url : '/wuliu3/staff/findAll',
		 type: "POST",
		 dataType: 'json',  
	     success: function (json) {
			$('#staffname').combobox({
				data: json,  
				valueField:'id',
				textField:'name',
				editable:false

			});
		        			
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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doChongFa('${pageContext.request.contextPath }/workbill/diaoDuBatch?ids=')">重发</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/workbill/findById?id=','${pageContext.request.contextPath }/workbill/updateStaffId')">手动重发</a>
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


<!-- 添加 修改分区 -->
	<div class="easyui-window" title="指定工单给取派员" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd">
				<table class="table-edit" width="100%" align="center">
					<tr style="display:none;">
						<td>工单编号</td>
						<td><input type="hidden" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>选择负责人</td>
						<td>
							<select  name="staffId"  id="staffname" 
    							 class="easyui-combobox easyui-validatebox" style="width:150px;"  required="true" >  </select>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	
	
</body>
</html>