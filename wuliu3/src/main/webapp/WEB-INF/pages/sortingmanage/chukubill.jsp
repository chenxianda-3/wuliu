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
	
	init("${pageContext.request.contextPath}/chukubill/findBypage");
	
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
		action:'${pageContext.request.contextPath}/chukubill/importXls',
		name:'importFile',
		onSubmit:function () {
			var isImportUrl = "${pageContext.request.contextPath}/chukubill/isImport";
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
	$('#association_chukudetails').datagrid( {
		fit : true,
		border : true,
		rownumbers : true,
		striped : true,
		url : "${pageContext.request.contextPath}/chukubill/findChukudetailsByid?id="+data.id,
		columns : [[{
			field : 'workorderId',
			title : '工作单号',
			width : 120,
			align : 'center'
		},{
			field : 'chukubillId',
			title : '关联出库交接单',
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
			field : 'vol',
			title : '体积',
			width : 120,
			align : 'center'
		},{
			field : 'scantime',
			title : '扫描时间',
			width : 120,
			align : 'center'
		},{
			field : 'productname',
			title : '品名',
			width : 120,
			align : 'center'
		},{
			field : 'shouhuopeople',
			title : '收货人',
			width : 120,
			align : 'center'
		},{
			field : 'shouhuoaddress',
			title : '收货地址',
			width : 120,
			align : 'center'
		},{
			field : 'timelimit',
			title : '送达时限',
			width : 120,
			align : 'center'
		},{
			field : 'destination',
			title : '到达地',
			width : 120,
			align : 'center'
		}
		]]
	});
	
}





function save(saveUrl) {
	doCancel2();
	var rows = $("#subareaGrid").datagrid("getSelections");
	var workorderIds=null;
	if (rows.length >0) {
		var array = new Array();
		//确定,发送请求
		//获取所有选中的取派员的id
		for (var i = 0; i < rows.length; i++) {
			var object = rows[i];//json对象
			var workorderId = object.workorderId;
			array.push(workorderId);
		}
		workorderIds = array.join(",");//1,2,3,4,5
	}
	
	$('#formAdd').form({
		url : saveUrl,
		onSubmit: function (param) {
			param.workorderIds = workorderIds
		    },
		error : function() {
			alert("网络出现错误！");
		},
		success : function(data) {
			showCloseReload(data);
		}
	});
	// submit the form    
	$('#formAdd').submit();
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
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="doAdd('${pageContext.request.contextPath }/chukubill/addChukubill')">新增</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="doUpdate('${pageContext.request.contextPath}/chukubill/findById?id=','${pageContext.request.contextPath }/chukubill/updateById')">修改</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="doDelete('${pageContext.request.contextPath }/chukubill/deleteBatch?ids=')">删除出库交接单</a>
        <a  href="#" id="button-import" class="easyui-linkbutton" data-options="iconCls:'icon-redo',plain:true" >导入数据</a>
      <form id="formQuery"  class="easyui-linkbutton" data-options="plain:true" >
       <span style="margin-left: 10px">出库交接单号&nbsp;</span><input name="id" type="text" class="easyui-textbox" style="width:100px"> 
        <span style="margin-left: 30px">接货人 &nbsp;</span><input name="jiehuopeople" type="text" class="easyui-textbox " style="width:100px"> 
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
        <span style="margin-left: 15px">工作单号&nbsp;</span><input name="workorderId" type="text" class="easyui-textbox " style="width:100px" >  
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
			<th field="id" data-options="width : 250,title : '出库交接单号',align : 'center',checkbox : false" ></th>
			<th field="type" data-options="width : 120,title : '交接单类型',align : 'center',formatter : function(data, row, index) {if (data == '0') {return '市内物流交接单';}else if (data == '1') {return '长途物流交接单';}else if (data == '2') {return '派送清单';}else if (data == '3') {return '发货交接单';}else {return '无';}}" ></th>
			<th field="lineresource" data-options="width : 120,title : '线路资源',align : 'center'" ></th>
			<th field="linedirection" data-options="width : 120,title : '物流方向',align : 'center'" ></th>
			<th field="transportway" data-options="width : 120,title : '运输方式',align : 'center'"  ></th>
			<th field="jiehuopeople" data-options="width : 120,title : '接货人',align : 'center'" ></th>
			<th field="jiaohuopeople" data-options="width : 120,title : '交货人',align : 'center'" ></th>
			<th field="jiaohuotime" data-options="width : 120,title : '交货时间',align : 'center'"  ></th>
			<th field="jiaohuostation" data-options="width : 120,title : '交货单位',align : 'center'" ></th>
		</tr>
	</thead>
  </table>  
</div>  
  

	<div  region="south" border="false" style="height:150px;" >
	<div id="tabs" fit="true" class="easyui-tabs">
			<div title="出库交接单明细" style="width:100%;height:100%;overflow:hidden">
				<table id="association_chukudetails"></table>
			</div>	
		</div>
	</div>
	
	
	<div class="easyui-window" title="出库交接单添加修改" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px;">
		<div style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="formAdd" method="post">
				<table class="table-edit" width="100%" align="center">
					<tr class="title">
						<td colspan="2">出库交接单信息</td>
					</tr>
					<tr>
						<td>交接单类型</td>
						<td><select name="type">
								<option value="0">市内物流交接单</option>
								<option value="1">长途物流交接单</option>
								<option value="2">派送清单</option>
								<option value="0">发货交接单</option>
						</select></td>
					</tr>
					<tr>
						<td>线路资源</td>
						<td><input type="text" name="lineresource"   class="easyui-validatebox"  /></td>
					</tr>
					<tr>
						<td>物流方向</td>
						<td><input type="text" name="linedirection"  class="easyui-validatebox"  /></td>
					</tr>
					<tr>
						<td>运输方式</td>
						<td><input type="text" name="transportway"  class="easyui-validatebox"  /></td>
					</tr>
					<tr>
						<td>接货人</td>
						<td><input type="text" name="jiehuopeople"   class="easyui-validatebox"  /></td>
					</tr>
					
					<tr>
						<td>交货人</td>
						<td><input type="text" name="jiaohuopeople"   class="easyui-validatebox"  /></td>
					</tr>
					<tr>
						<td>交货时间</td>
						<td><input type="text" name="jiaohuotime"   class="easyui-datetimebox"  /></td>
					</tr><tr>
						<td>交货单位</td>
						<td><input type="text" name="jiaohuostation"   class="easyui-validatebox"  /></td>
					</tr>
	
				
					<tr height="300" id="guanlianworkorder">
						<td valign="top">已配载的工作单</td>
						<td>
							<table id="subareaGrid" style="width:580px;height:300px;"  class="easyui-datagrid" border="false"   data-options="url:'${pageContext.request.contextPath}/peizaiinfo/findBypageOfPeizaied',fitColumns:true,singleSelect:false,pagination : true,	toolbar : '#tb2',pageSize:10,pageList : [ 4,8,10]"  >
								<thead>  
							        <tr>  
							            <th field="" data-options="checkbox : true" ></th>
										<th field="workorderId" data-options="width : 120,title : '工作单号',align : 'center'" ></th>
										<th field="combineId" data-options="width : 120,title : '合包号',align : 'center'" ></th>
										<th field="operateunit" data-options="width : 120,title : '操作单位',align : 'center'" ></th>
										<th field="lineId" data-options="width : 120,title : '航班车次',align : 'center'" ></th>
										<th field="product" data-options="width : 120,title : '品名',align : 'center'" ></th>
										<th field="timelimit" data-options="width : 120,title : '送达时限',align : 'center'" ></th>
										<th field="shouhuoaddress" data-options="width : 120,title : '收货地址',align : 'center'" ></th>
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
