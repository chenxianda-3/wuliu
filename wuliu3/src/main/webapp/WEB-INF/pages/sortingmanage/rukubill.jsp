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
	
	init("${pageContext.request.contextPath}/rukubill/findBypage");
	
	$('#addWindow').window({
		width : 700,
		modal : true,
		shadow : true,
		closed : true,
		height : 550,
		resizable : false
	});


	//onclickup插件的初始化，提供上传时候的用户交互
	$("#button-import").upload({
		action:'${pageContext.request.contextPath}/rukubill/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/rukubill/isImport";
			importExcWithprogress(isImportUrl,200,200);
		 },
		 onComplete:function (data) {
			 showCloseReload3(data);
		 }
		
	});
	//改变样式插件与easyui的样式有点冲突
	$("#button-import").parent().addClass("easyui-linkbutton l-btn l-btn-small l-btn-plain");
	
});


function doDblClickRow(index,data){

	//创建展示客户数据的数据表格
	$('#association_rukudetails').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/rukubill/findRukudetailsByid?id="+data.id,
		columns : [[{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'rukubillId',
			title : '关联入库交接单',
			width : 120,
			align : 'center'
		}
		,{
			field : 'combinebillId',
			title : '合包号',
			width : 120,
			align : 'center'
		},{
			field : 'weight',
			title : '重量',
			width : 120,
			align : 'center'
		},{
			field : 'chukubillId',
			title : '关联出库交接单号',
			width : 120,
			align : 'center'
		},{
			field : 'status',
			title : '状态',
			width : 120,
			align : 'center'
		}
		]]
	});
	
}



function save(saveUrl) {
	doCancel2();
	var param =  new Object();
	var inserted;
	//添加工作单
	if ($("#subareaGrid").datagrid('getChanges').length) { 
		inserted = $("#subareaGrid").datagrid('getChanges', "inserted"); 
		if (inserted.length) { 
			param["inserted"] = JSON.stringify(inserted); 
			} 
		
	}else{
		inserted = $("#subareaGrid").datagrid('getChecked'); 
		if (inserted.length) { 
			param["inserted"] = JSON.stringify(inserted); 
			} 
	}
	//添加表单
		var formData = $("#formAdd").serializeArray();
		    formData.forEach(function (e) {
			                    	if(e.value != '00'){
			                    		param[e.name] = e.value;
			                    	}
			                    });
	
	   
	$.ajax({
		url : saveUrl,
		type : "POST",
		data :  param,
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload(data);
		}
	});
	

	
}



function otherQuery2(){
 	var formSerialize =$("#formQuery2").form().serializeArray();
 	var obj=serializeObject(formSerialize);
 	if(false==obj){
 		return false;
 	}
    $("#subareaGrid").datagrid('load',obj);

}

//添加
function doAdd2(){
	 $("#subareaGrid").datagrid('appendRow', {}); 
	 var rows =$("#subareaGrid").datagrid('getRows'); 
	 $("#subareaGrid").datagrid('beginEdit', rows.length - 1); 
}

//编辑
function doEdit2(){
	var row =$("#subareaGrid").datagrid('getSelected'); 
	if (row) { 
		var rowIndex =$("#subareaGrid").datagrid('getRowIndex', row); 
		$("#subareaGrid").datagrid('beginEdit', rowIndex); 
		} 
}

//删除
function doDelete2(){
	var row = $("#subareaGrid").datagrid('getSelected'); 
	if (row) { 
	var rowIndex = $("#subareaGrid").datagrid('getRowIndex', row); 
	$("#subareaGrid").datagrid('deleteRow', rowIndex); 
	} 
}

$("#").val();

//结束编辑
function doCancel2(){
	var rows = $("#subareaGrid").datagrid('getRows'); 
	for ( var i = 0; i < rows.length; i++) { 
	$("#subareaGrid").datagrid('endEdit', i); 
	} 
}




</script>
</head>
<body class="easyui-layout"   style="visibility: hidden;" >

 <div id="tb" style="padding:5px;height:auto">
 <table cellpadding="0" cellspacing="0" style="width: 100%">
    <tr >
      <td>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/rukubill/addRukubill')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/rukubill/findById?id=','${pageContext.request.contextPath }/rukubill/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/rukubill/deleteBatch?ids=')">删除入库交接单</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入数据</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">入库交接单号&nbsp;</span><input name="id" type="text" class="easyui-textbox easyui-numberbox" style="width:100px" data-options="validType:'length[0,32]',validType:'isBlank'"> 
        <span style="margin-left: 30px">接货人 &nbsp;</span><input name="jiehuopeople" type="text" class="easyui-textbox easyui-validatebox" style="width:100px" data-options="validType:'name'"> 
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery()">查询</a> 
      </td>
      </tr>
    </table>
    </div>
    
    
      <div id="tb2" style="padding:5px;height:auto" >
 <table cellpadding="0" cellspacing="0" style="width: 100%">
      <tr>
      <td style="margin-left: 0px;">
       <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd2();">添加</a>
       <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doEdit2();">编辑</a>
       <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="doDelete2();">删除</a>
       <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doCancel2();">结束编辑</a>
        <form id="formQuery2"  class="easyui-linkbutton" data-options="plain:true" >
        <span style="margin-left: 15px">出库交接单号&nbsp;</span><input name="id" type="text" class="easyui-textbox " style="width:100px" >  
        </form>
        <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false" onclick="otherQuery2()">查询</a> 
      </td>
      </tr>
    </table>
    </div> 
    
    

<div region="center" border="false">	
<table id="grid"  data-options="onDblClickRow: doDblClickRow" >
	<thead>
		<tr>
			<th field="xxx" data-options="checkbox : true" ></th>
			<th field="id" data-options="width : 120,title : '入库交接单号',align : 'center',checkbox : false" ></th>
			<th field="jiehuotime" data-options="width : 120,title : '接货时间',align : 'center'" ></th>
			<th field="jiehuopeople" data-options="width : 120,title : '接货人',align : 'center',checkbox : false" ></th>
			<th field="jiehuostation" data-options="width : 120,title : '接收单位',align : 'center'" ></th>
			<th field="fahuopeople" data-options="width : 120,title : '发货人',align : 'center'"  ></th>
			<th field="fahuostation" data-options="width : 120,title : '发货单位',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  
</div>  
  

	<div  region="south" border="false" style="height:150px;" >
	<div id="tabs" fit="true" class="easyui-tabs">
			<div title="入库交接单明细" style="width:100%;height:100%;overflow:hidden">
				<table id="association_rukudetails"></table>
			</div>	
		</div>
	</div>
	
	
		<!-- 添加修改合包 -->
	<div class="easyui-window" title="入库交接单添加修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd" method="post">
				<table class="table-edit" width="100%" align="center">
					<tr class="title">
						<td colspan="2">合包信息</td>
					</tr>
					<tr>
						<td>接货时间</td>
						<td><input type="text" name="jiehuotime"   class="easyui-datetimebox" required="true"/></td>
					</tr>
					<tr>
						<td>接货人</td>
						<td><input type="text" name="jiehuopeople"   class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>接收单位</td>
						<td><input type="text" name="jiehuostation"  class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>发货人</td>
						<td><input type="text" name="fahuopeople"  class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>发货单位</td>
						<td><input type="text" name="fahuostation"   class="easyui-validatebox" required="true"/></td>
					</tr>
				
					<tr height="300" id="guanlianworkorder">
						<td valign="top">已扫描的工作单</td>
						<td>
							<table id="subareaGrid" style="width:580px;height:300px;"  class="easyui-datagrid" border="false"   data-options="url:'${pageContext.request.contextPath}/chukubill/findChukudetailsByid',fitColumns:true,singleSelect:false,pagination : true,	toolbar : '#tb2',pageSize : 8,pageList : [ 2,4,8]"  >
								<thead>  
							        <tr>  
							            <th field="" data-options="checkbox : true" ></th>
										<th field="workorderId" data-options="width : 120,title : '工作单号',align : 'center',checkbox : false,editor:'validatebox' " ></th>
							            <th data-options="field:'combinebillId',width:120,editor:'validatebox'">合包号</th>  
							            <th data-options="field:'chukubillId',width:150,editor:'validatebox'">关联的出库交接单</th>  
							            <th data-options="field:'weight',width:120,editor:'validatebox'">重量</th>  
							            <th  class="easyui-combobox"  data-options="field:'status',width:120,editor:{
							         type:'combobox',
		                            options:{
		                            	data: [{'code':'0','name':'中转入库'},{'code':'1','name':'二次入库'},{'code':'2','name':'初始入库','selected':true},{'code':'3','name':'有货无单'}]  ,
		                                valueField:'code',
		                                textField:'name'
		                                }
		                              }
							            ">状态</th>  
							        </tr>  
							    </thead> 
							</table>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	
	

	 
</body>
</html>
